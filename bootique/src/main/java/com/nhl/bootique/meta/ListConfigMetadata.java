package com.nhl.bootique.meta;

import java.util.Collection;

/**
 * Provides metadata for a configuration that is a list of one of the predefined types.
 *
 * @since 0.19
 */
public class ListConfigMetadata extends ConfigMetadata {

    private Collection<ConfigMetadata> valueTypes;

    public Collection<ConfigMetadata> getValueTypes() {
        return valueTypes;
    }
}
