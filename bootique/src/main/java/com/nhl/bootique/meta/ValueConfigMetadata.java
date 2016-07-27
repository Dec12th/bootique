package com.nhl.bootique.meta;

/**
 * Represents metadata describing a single "primitive" configuration property.
 *
 * @since 0.19
 */
public class ValueConfigMetadata extends ConfigMetadata {

    public static Builder builder() {
        return new Builder();
    }

    protected ValueConfigMetadata() {
    }

    @Override
    public void accept(ConfigMetadataVisitor visitor) {
        visitor.visitValue(this);
    }

    public static class Builder {
        private ValueConfigMetadata metadata;

        private Builder() {
            this.metadata = new ValueConfigMetadata();
        }

        public ValueConfigMetadata build() {
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
