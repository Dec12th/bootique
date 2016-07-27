package com.nhl.bootique.meta;

/**
 * Represents metadata describing a single "primitive" configuration property.
 *
 * @since 0.19
 */
public class ConfigMetadata {

    private Class<?> type;
    private String description;

    protected ConfigMetadata() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Class<?> getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private ConfigMetadata metadata;

        private Builder() {
            this.metadata = new ConfigMetadata();
        }

        public ConfigMetadata build() {
            return metadata;
        }

        public Builder type(Class<?> type) {
            metadata.type = type;
            return this;
        }

        public Builder description(String description) {
            metadata.description = description;
            return this;
        }
    }

}
