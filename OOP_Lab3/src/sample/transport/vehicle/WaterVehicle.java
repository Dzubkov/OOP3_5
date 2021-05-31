package sample.transport.vehicle;

import sample.transport.engine.Engine;

public abstract class WaterVehicle extends Vehicle {
    protected int displacement;

    protected WaterVehicle(String vehicleType, String vehicleModel, Engine engine) {
        super(vehicleType, vehicleModel, engine);
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public abstract void swim();
}
