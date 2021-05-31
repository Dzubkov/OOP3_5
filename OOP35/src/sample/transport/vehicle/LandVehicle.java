package sample.transport.vehicle;

import sample.transport.engine.Engine;

public abstract class LandVehicle extends Vehicle {
    enum DRIVE_UNIT{FRONT_WHEEL, REAR_WHEEL}
    protected DRIVE_UNIT driveUnit;

    protected LandVehicle(String vehicleType, String vehicleModel, Engine engine) {
        super(vehicleType, vehicleModel, engine);
    }

    public DRIVE_UNIT getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(DRIVE_UNIT driveUnit) {
        this.driveUnit = driveUnit;
    }

    public abstract void go();
}
