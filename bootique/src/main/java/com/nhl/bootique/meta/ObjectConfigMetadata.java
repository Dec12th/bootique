package com.nhl.bootique.meta;

import java.util.Map;

/**
 * Represents metadata of a configuration that contains a fixed set of child configuration properties.
 *
 * @since 0.19
 */
public class ObjectConfigMetadata extends ConfigMetadata {

    private Map<String, ConfigMetadata> properties;

    public Map<String, ConfigMetadata> getProperties() {
        return properties;
    }

    @Override
    public void accept(ConfigMetadataVisitor visitor) {
        visitor.visitObject(this);
    }
}
