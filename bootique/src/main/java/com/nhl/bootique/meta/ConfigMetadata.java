package com.nhl.bootique.meta;

/**
 * A common superclass of configuration metadata objects.
 *
 * @since 0.19
 */
public abstract class ConfigMetadata {

    protected Class<?> type;
    protected String description;

    protected ConfigMetadata() {
    }

    public abstract void accept(ConfigMetadataVisitor visitor);

    public Class<?> getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
