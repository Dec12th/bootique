package com.nhl.bootique.meta;

import java.util.Collection;


/**
 * Represents metadata of a configuration that is a collection of arbitrary nested properties, each conforming to one of
 * the predefined config types.
 *
 * @since 0.19
 */
public abstract class CollectionConfigMetadata extends ConfigMetadata {

    private Collection<ConfigMetadata> propertyTypes;

    public Collection<ConfigMetadata> getPropertyTypes() {
        return propertyTypes;
    }
}
