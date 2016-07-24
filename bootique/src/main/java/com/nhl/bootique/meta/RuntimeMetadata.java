package com.nhl.bootique.meta;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Provides Bootique runtime metadata.
 *
 * @since 0.19
 */
public class RuntimeMetadata {

    private Collection<ModuleMetadata> modules;

    private RuntimeMetadata() {
        this.modules = new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    public Collection<ModuleMetadata> getModules() {
        return modules;
    }

    public static class Builder {

        private RuntimeMetadata metadata;

        private Builder() {
            this.metadata = new RuntimeMetadata();
        }

        public RuntimeMetadata build() {
            return metadata;
        }

        public Builder module(ModuleMetadata moduleMetadata) {
            metadata.modules.add(moduleMetadata);
            return this;
        }
    }
}
