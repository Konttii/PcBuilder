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

    public ComputerBuilder setStorage(String storag){
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
        requireNonBLank(cpu, "SPU");
        requireNonBLank(ram, "RAM");
        requireNonBLank(storage, "Storage");
        requireNonBLank(powerSupply, "Power supply");
        requireNonBLank(coolingSystem, "Cooling system");

    }

    protected final void requireNonBLank(String value, String fieldName){
        if (value == null || value.isBlank()){
            throw new IllegalArgumentException(fieldName + " must be set before calling build()");
        }
    }

    protected abstract void validateSpecific();

    public abstract Computer biuld();

}
