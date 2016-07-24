package com.nhl.bootique.meta;

import java.util.Collection;

/**
 * Provides metadata for a configuration that is a map with user-provided keys and values are of one of the listed types.
 */
public class MapConfigMetadata extends ConfigMetadata {

    private Collection<ConfigMetadata> valueTypes;

    public Collection<ConfigMetadata> getValueTypes() {
        return valueTypes;
    }
}
