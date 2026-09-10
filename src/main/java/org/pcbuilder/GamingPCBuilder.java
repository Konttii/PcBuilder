package org.pcbuilder;

public class GamingPCBuilder extends ComputerBuilder {
    private static final String DEFAULT_GPU = "NVIDIA RTX 4050";
    private static final String DEFAULT_COOLING = "Liquid Cooling";
    private static final String DEFAULT_PSU = "850W Gold";
    private static final String NO_GPU = "Integrated Graphics";


    public Computer build(){
        applyDefaults();
        validateCommon();
        validateSpecific();
        return new Computer(this);
    }

    private void applyDefaults(){
        if (gpu == null || gpu.isBlank()){
            gpu = DEFAULT_GPU;
        }
        if (coolingSystem == null || coolingSystem.isBlank()){
            coolingSystem = DEFAULT_COOLING;
        }
        if (powerSupply == null || powerSupply.isBlank()){
            powerSupply = DEFAULT_PSU;
        }
    }

    @Override
    protected void validateSpecific(){
        if(NO_GPU.equalsIgnoreCase(gpu)){
            throw new IllegalStateException(
                    "A gaming PC requires a dedicates GPU, not integrated graphics");

        }
    }

}
