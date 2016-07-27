package com.nhl.bootique.meta;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ModuleMetadataTest {

    @Test
    public void testBuilder() {

        ConfigMetadata cm1 = ConfigMetadata.builder().build();
        ConfigMetadata cm2 = ConfigMetadata.builder().build();

        ModuleMetadata mmd = ModuleMetadata.builder().name("xx").description("desc").config(cm1).config(cm2).build();
        assertNotNull(mmd);
        assertEquals("xx", mmd.getName());
        assertEquals("desc", mmd.getDescription());
        assertArrayEquals(new Object[]{cm1, cm2}, mmd.getConfigs().toArray());

    }
}
