package org.pcbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OfficePCBuilderTest {

    @Test
    void buildsWithDefaultsWhenOptionalFieldsAreUnset() {
        Computer computer = new OfficePCBuilder()
                .setCPU("Intel Core i3-14100")
                .setRAM("8GB DDR4")
                .setStorage("256GB SSD")
                .build();

        assertEquals("Integrated Graphics", computer.getGpu());
        assertEquals("Stock Air Cooler", computer.getCoolingSystem());
        assertEquals("450W Bronze", computer.getPowerSupply());
    }

    @Test
    void rejectsPowerSupplyAboveOfficeBudget() {
        assertThrows(IllegalStateException.class, () ->
                new OfficePCBuilder()
                        .setCPU("Intel Core i9-14900K")
                        .setRAM("64GB DDR5")
                        .setStorage("4TB NVMe SSD")
                        .setPowerSupply("1000W Platinum")
                        .build());
    }

    @Test
    void rejectsMissingRequiredField() {
        assertThrows(IllegalStateException.class, () ->
                new OfficePCBuilder()
                        .setCPU("Intel Core i3-14100")
                        .setStorage("256GB SSD")
                        .build());
    }
}