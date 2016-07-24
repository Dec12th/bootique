package com.nhl.bootique.meta;

import java.util.Collection;

/**
 * Provides metadata for a configuration of a given type which may contain nested configuration objects.
 *
 * @since 0.19
 */
public class ObjectConfigMetadata extends ConfigMetadata {

    private Collection<ConfigMetadata> properties;

    public Collection<ConfigMetadata> getProperties() {
        return properties;
    }
}
