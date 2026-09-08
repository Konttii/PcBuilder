package org.pcbuilder;

public class OfficePCBuilder extends ComputerBuilder {

    private static final String DEFAULT_GPU = "Integrated Graphics";
    private static final String DEFAULT_COOLING = "Stock Air Cooler";
    private static final String DEFAULT_PSU = "450W Bronze";
    private static final int MAX_OFFICE_PSU_WATTS = 550;

    @Override
    public Computer build() {
        applyDefaults();
        validateCommon();
        validateSpecific();
        return new Computer(this);
    }

    private void applyDefaults() {
        if (gpu == null || gpu.isBlank()) {
            gpu = DEFAULT_GPU;
        }
        if (coolingSystem == null || coolingSystem.isBlank()) {
            coolingSystem = DEFAULT_COOLING;
        }
        if (powerSupply == null || powerSupply.isBlank()) {
            powerSupply = DEFAULT_PSU;
        }
    }

    @Override
    protected void validateSpecific() {
        int watts = extractWattage(powerSupply);
        if (watts > MAX_OFFICE_PSU_WATTS) {
            throw new IllegalStateException(
                    "Power supply exceeds office budget of " + MAX_OFFICE_PSU_WATTS + "W: " + powerSupply);
        }
    }

    private int extractWattage(String powerSupplyLabel) {
        StringBuilder digits = new StringBuilder();
        for (char c : powerSupplyLabel.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else if (!digits.isEmpty()) {
                break;
            }
        }
        if (digits.isEmpty()) {
            throw new IllegalStateException("Cannot determine wattage from: " + powerSupplyLabel);
        }
        return Integer.parseInt(digits.toString());
    }

}
