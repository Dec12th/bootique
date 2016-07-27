package com.nhl.bootique.meta.compiler;

import com.nhl.bootique.meta.ConfigMetadata;

/**
 * @since 0.19
 */
interface NamedMetadata {

    String getName();

    ConfigMetadata getMetadata();
}
