package com.nhl.bootique.meta;

/**
 * @since 0.19
 */
public interface ConfigMetadataVisitor {

    default void visitValue(ValueConfigMetadata metadata) {
    }

    default void visitObject(ObjectConfigMetadata metadata) {
    }

    default void visitList(ListConfigMetadata metadata) {
    }

    default void visitMap(MapConfigMetadata metadata) {
    }
}
