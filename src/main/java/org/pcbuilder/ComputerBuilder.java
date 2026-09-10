package org.pcbuilder;

public abstract class ComputerBuilder {

    protected  String cpu;
    protected  String ram;
    protected  String storage;
    protected  String gpu;
    protected  String powerSupply;
    protected  String coolingSystem;

    public ComputerBuilder setCPU(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder setRAM(String ram){
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(String storage){
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGPU(String gpu){
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder setPowerSupply(String powerSupply){
        this.powerSupply = powerSupply;
        return this;
    }

    public ComputerBuilder setCoolingSystem(String coolingSystem){
        this.coolingSystem = coolingSystem;
        return this;
    }

    protected final void validateCommon(){
        requireNonBlank(cpu, "SPU");
        requireNonBlank(ram, "RAM");
        requireNonBlank(storage, "Storage");
        requireNonBlank(powerSupply, "Power supply");
        requireNonBlank(coolingSystem, "Cooling system");

    }

    protected final void requireNonBlank(String value, String fieldName){
        if (value == null || value.isBlank()){
            throw new IllegalStateException(fieldName + " must be set before calling build()");        }
    }

    protected abstract void validateSpecific();

    public abstract Computer build();

}
