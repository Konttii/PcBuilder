package org.pcbuilder;

public class PCDirector {

    public Computer buildBudgetGamingPC(ComputerBuilder builder) {
        return builder
                .setCPU("AMD Ryzen 5 5600")
                .setRAM("16GB DDR4")
                .setStorage("512GB NVMe SSD")
                .build();
    }

    public Computer buildHighEndGamingPC(ComputerBuilder builder) {
        return builder
                .setCPU("Intel Core i9-14900K")
                .setRAM("32GB DDR5")
                .setStorage("2TB NVMe SSD")
                .setGPU("NVIDIA RTX 4090")
                .setPowerSupply("1000W Platinum")
                .build();
    }

    public Computer buildStandardOfficePC(ComputerBuilder builder) {
        return builder
                .setCPU("Intel Core i3-14100")
                .setRAM("8GB DDR4")
                .setStorage("256GB SSD")
                .build();
    }
}


