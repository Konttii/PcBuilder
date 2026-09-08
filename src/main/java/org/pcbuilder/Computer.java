package org.pcbuilder;

public final class Computer {

    private final String cpu;
    private final String  ram;
    private final String  storage;
    private final String  gpu;
    private final String  powerSupply;
    private final String  coolingSystem;


    public Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    @Override
    public String toString() {
        return "Computer{cpu='%s', ram='%s', storage='%s', gpu='%s', powerSupply='%s', coolingSystem='%s'}"
                .formatted(cpu, ram, storage, gpu, powerSupply, coolingSystem);

    }
}
