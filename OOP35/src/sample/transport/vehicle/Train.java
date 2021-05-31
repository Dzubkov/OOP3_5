package sample.transport.vehicle;

import sample.transport.Composite.Order;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Train")
public final class Train extends LandVehicle implements Order {
    private final static String TYPE = "Train";

    public Train(){
        super(TYPE, null, null);
    }

    public Train(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Train(vehicleModel, engine);
    }



    @Override
    public void go() {
        System.out.println("train go");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
