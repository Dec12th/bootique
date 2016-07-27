package com.nhl.bootique.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents metadata of a configuration that contains a fixed set of child configuration properties.
 *
 * @since 0.19
 */
public class ObjectConfigMetadata extends ConfigMetadata {

    private Map<String, ConfigMetadata> properties;


    protected ObjectConfigMetadata() {
        this.properties = new HashMap<>();
    }

    public static Builder builder(Class<?> type) {
        return new Builder(type);
    }

    public Map<String, ConfigMetadata> getProperties() {
        return properties;
    }

    @Override
    public void accept(ConfigMetadataVisitor visitor) {
        visitor.visitObject(this);
    }

    public static class Builder {
        private ObjectConfigMetadata metadata;

        private Builder(Class<?> type) {
            this.metadata = new ObjectConfigMetadata();
           this. metadata.type = type;
        }

        public ObjectConfigMetadata build() {
            return metadata;
        }

        public Builder description(String description) {
            metadata.description = description;
            return this;
        }

        public Builder property(String name, ConfigMetadata propertyConfig) {
            metadata.properties.put(name, propertyConfig);
            return this;
        }
    }
}
