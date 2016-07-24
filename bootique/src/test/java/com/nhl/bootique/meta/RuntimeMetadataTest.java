package com.nhl.bootique.meta;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;


public class RuntimeMetadataTest {

    @Test
    public void testBuilder() {

        ModuleMetadata mmd1 = ModuleMetadata.builder().build();
        assertNotNull(mmd1);
        ModuleMetadata mmd2 = ModuleMetadata.builder().build();
        assertNotNull(mmd2);

        RuntimeMetadata md = RuntimeMetadata.builder().module(mmd1).module(mmd2).build();
        assertNotNull(md);
        assertArrayEquals(new Object[]{mmd1, mmd2}, md.getModules().toArray());
    }
}
