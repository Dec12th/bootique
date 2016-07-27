package com.nhl.bootique.meta.compiler;

import com.nhl.bootique.meta.ConfigMetadata;

/**
 * Defines API of a "compiler" of {@link ConfigMetadata} for annotated Java types.
 *
 * @since 0.19
 */
public interface ConfigMetadataCompiler {

    default ConfigMetadata compile(Class<?> configType) {
        return compile(configType, null);
    }

    ConfigMetadata compile(Class<?> configType, String description);
}
