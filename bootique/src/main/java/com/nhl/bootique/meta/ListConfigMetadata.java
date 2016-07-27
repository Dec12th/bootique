package com.nhl.bootique.meta;

/**
 * Represents metadata of a configuration that is a list of predefined types.
 *
 * @since 0.19
 */
public class ListConfigMetadata extends CollectionConfigMetadata {

    @Override
    public void accept(ConfigMetadataVisitor visitor) {
        visitor.visitList(this);
    }
}
