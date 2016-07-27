package com.nhl.bootique.meta.compiler;

import com.nhl.bootique.log.BootLogger;
import com.nhl.bootique.meta.ConfigMetadata;
import com.nhl.bootique.meta.ObjectConfigMetadata;
import com.nhl.bootique.meta.ValueConfigMetadata;
import com.nhl.bootique.meta.annotation.ConfigObject;

/**
 * A {@link ConfigMetadataCompiler} based on explicit documentation annotations like
 * {@link com.nhl.bootique.meta.annotation.ConfigObject} and {@link com.nhl.bootique.meta.annotation.ConfigObjectProperty}.
 *
 * @since 0.19
 */
public class AnnotatedConfigMetadataCompiler implements ConfigMetadataCompiler {

    private AnnotatedPropertyCompiler propertyFinder;

    public AnnotatedConfigMetadataCompiler(BootLogger logger) {
        this.propertyFinder = new AnnotatedPropertyCompiler(logger, this);
    }

    @Override
    public ConfigMetadata compile(Class<?> configType, String description) {

        ConfigObject configObjectKind = configType.getAnnotation(ConfigObject.class);
        if (configObjectKind != null) {
            return compileObject(configType, description);
        } else {
            return compileValue(configType, description);
        }
    }

    protected ObjectConfigMetadata compileObject(Class<?> type, String description) {

        ObjectConfigMetadata.Builder builder = ObjectConfigMetadata.builder(type).description(description);

        propertyFinder.findProperties(type).forEach((name, metadata) -> {
            builder.property(name, metadata);
        });

        return builder.build();
    }

    protected ValueConfigMetadata compileValue(Class<?> configType, String description) {
        return ValueConfigMetadata.builder().type(configType).description(description).build();
    }
}


