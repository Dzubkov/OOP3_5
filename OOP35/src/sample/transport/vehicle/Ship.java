package sample.transport.vehicle;

import sample.transport.Composite.Order;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Ship")
public class Ship extends WaterVehicle implements Order {
    private final static String TYPE = "Ship";

    public Ship(){
        super(TYPE, null, null);
    }

    public Ship(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Ship(vehicleModel, engine);
    }



    @Override
    public void swim() {
        System.out.println("ship swim");
    }

    @Override
    public int getCount() {
        return 1;
    }
}
