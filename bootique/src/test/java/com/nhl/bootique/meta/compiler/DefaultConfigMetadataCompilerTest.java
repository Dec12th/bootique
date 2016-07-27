package com.nhl.bootique.meta.compiler;


import com.nhl.bootique.meta.ConfigMetadata;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DefaultConfigMetadataCompilerTest {

    private DefaultConfigMetadataCompiler compiler = new DefaultConfigMetadataCompiler();

    @Test
    public void testCompile() {
        ConfigMetadata md1 = compiler.compile(Config1.class);
        assertNotNull(md1);

    }

    public static class Config1 {


    }
}
