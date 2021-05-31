package sample.transport.vehicle;

import sample.transport.Composite.Order;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Plain")
public final class Plain extends AirVehicle implements Order {
    private final static String TYPE = "Plain";

    public Plain(){
        super(TYPE, null, null);
    }

    public Plain(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Plain(vehicleModel, engine);
    }



    @Override
    public void fly() {
        System.out.println("fly plain");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
