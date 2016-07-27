package com.nhl.bootique.meta;

import java.util.Collection;


/**
 * Represents metadata of a configuration that is a collection of arbitrary subconfig properties, each one of a
 * predefined set of types.
 *
 * @since 0.19
 */
public abstract class CollectionConfigMetadata extends ConfigMetadata {

    private Collection<ConfigMetadata> propertyTypes;

    public Collection<ConfigMetadata> getPropertyTypes() {
        return propertyTypes;
    }
}
