package org.pcbuilder;

public class Main {

    public static void main(String[] args) {
        PCDirector director = new PCDirector();

        Computer budgetGaming = director.buildBudgetGamingPC(new GamingPCBuilder());
        System.out.println("Budget gaming PC: " + budgetGaming);

        Computer highEndGaming = director.buildHighEndGamingPC(new GamingPCBuilder());
        System.out.println("High-end gaming PC: " + highEndGaming);

        Computer office = director.buildStandardOfficePC(new OfficePCBuilder());
        System.out.println("Standard office PC: " + office);

        Computer customOffice = new OfficePCBuilder()
                .setCPU("Intel Core i5-14400")
                .setRAM("16GB DDR4")
                .setStorage("512GB SSD")
                .setPowerSupply("400W Bronze")
                .build();
        System.out.println("Custom office PC: " + customOffice);

        demonstrateValidationFailure();
    }

    private static void demonstrateValidationFailure() {
        try {
            new OfficePCBuilder()
                    .setCPU("Intel Core i9-14900K")
                    .setRAM("64GB DDR5")
                    .setStorage("4TB NVMe SSD")
                    .setPowerSupply("1000W Platinum")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation correctly rejected an over-budget office PC: " + e.getMessage());
        }
    }
}

