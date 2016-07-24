package com.nhl.bootique.meta;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Provides runtime metadata for a specific module.
 *
 * @since 0.19
 */
public class ModuleMetadata {

    private String name;
    private String description;
    private Collection<ConfigMetadata> configs;

    private ModuleMetadata() {
        this.configs = new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Collection<ConfigMetadata> getConfigs() {
        return configs;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {

        private ModuleMetadata metadata;

        private Builder() {
            this.metadata = new ModuleMetadata();
        }

        public ModuleMetadata build() {
            return metadata;
        }

        public Builder name(String name) {
            metadata.name = name;
            return this;
        }

        public Builder description(String description) {
            metadata.description = description;
            return this;
        }

        public Builder config(ConfigMetadata config) {
            metadata.configs.add(config);
            return this;
        }
    }
}
