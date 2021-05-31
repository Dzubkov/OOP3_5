package sample.transport.vehicle;

import sample.transport.Composite.Order;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car")
public final class Car extends LandVehicle implements Order {
    private final static String TYPE = "Car";

    public Car(){
        super(TYPE, null, null);
    }

    public Car(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Car(vehicleModel, engine);
    }



    @Override
    public void go() {
        System.out.println("Car go");

    }

    @Override
    public int getCount() {
        return 1;
    }
}
