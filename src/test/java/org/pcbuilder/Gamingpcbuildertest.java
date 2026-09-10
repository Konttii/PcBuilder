package org.pcbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GamingPCBuilderTest {

    @Test
    void buildsWithDefaultsWhenOptionalFieldsAreUnset() {
        Computer computer = new GamingPCBuilder()
                .setCPU("AMD Ryzen 7 7800X3D")
                .setRAM("32GB DDR5")
                .setStorage("1TB NVMe SSD")
                .build();

        assertEquals("NVIDIA RTX 4050", computer.getGpu());
        assertEquals("Liquid Cooling", computer.getCoolingSystem());
        assertEquals("850W Gold", computer.getPowerSupply());
    }

    @Test
    void rejectsIntegratedGraphicsForAGamingBuild() {
        assertThrows(IllegalStateException.class, () ->
                new GamingPCBuilder()
                        .setCPU("Intel Core i5-14400")
                        .setRAM("16GB DDR4")
                        .setStorage("512GB SSD")
                        .setGPU("Integrated Graphics")
                        .build());
    }

    @Test
    void rejectsMissingRequiredField() {
        assertThrows(IllegalStateException.class, () ->
                new GamingPCBuilder()
                        .setRAM("16GB DDR4")
                        .setStorage("512GB SSD")
                        .build());
    }
}