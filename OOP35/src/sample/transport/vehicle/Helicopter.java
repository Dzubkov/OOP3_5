package sample.transport.vehicle;

import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Helicopter")
public final class Helicopter extends AirVehicle {
    private final static String TYPE = "Helicopter";

    public Helicopter() {
        super(TYPE, null, null);
    }

    public Helicopter(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Helicopter(vehicleModel, engine);
    }



    @Override
    public void fly() {
        System.out.println("helicopter fly");
    }
}
