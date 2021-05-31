package sample.transport.vehicle;

import sample.transport.engine.Engine;

public abstract class AirVehicle extends Vehicle {
    protected int flightAltitude;

    protected AirVehicle(String vehicleType, String vehicleModel, Engine engine) {
        super(vehicleType, vehicleModel, engine);
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public abstract void fly();
}
