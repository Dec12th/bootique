package com.nhl.bootique.meta.compiler;


import com.nhl.bootique.log.DefaultBootLogger;
import com.nhl.bootique.meta.ConfigMetadata;
import com.nhl.bootique.meta.ConfigMetadataVisitor;
import com.nhl.bootique.meta.ObjectConfigMetadata;
import com.nhl.bootique.meta.ValueConfigMetadata;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnnotatedConfigMetadataCompilerTest {

    private AnnotatedConfigMetadataCompiler compiler = new AnnotatedConfigMetadataCompiler(new DefaultBootLogger(false));

    @Test
    public void testCompile() {
        ConfigMetadata md1 = compiler.compile(Config1.class);
        assertNotNull(md1);
        assertEquals("string: \ninteger: ", toYaml(md1));
    }

    private String toYaml(ConfigMetadata metadata) {
        YamlVisitor visitor = new YamlVisitor();
        metadata.accept(visitor);
        return visitor.get();
    }

    public static class Config1 {

        private String string;
        private int integer;

        public void setString(String string) {
            this.string = string;
        }

        public void setInteger(int integer) {
            this.integer = integer;
        }
    }

    private static class YamlVisitor implements ConfigMetadataVisitor {

        private int offset;
        private StringBuilder buffer;

        YamlVisitor() {
            this.offset = -2;
            this.buffer = new StringBuilder();
        }

        String get() {
            return buffer.toString();
        }

        @Override
        public void visitValue(ValueConfigMetadata metadata) {
            if (metadata.getDescription() != null) {
                buffer.append("# ").append(metadata.getDescription());
            }
        }

        @Override
        public void visitObject(ObjectConfigMetadata metadata) {
            offset += 2;

            buffer.append("\n");

            metadata.getProperties().forEach((property, config) -> {

                for (int i = 0; i < offset; i++) {
                    buffer.append(' ');
                }
                buffer.append(property).append(": ");

                config.accept(this);
                buffer.append("\n");
            });

            offset -= 2;
        }
    }
}
