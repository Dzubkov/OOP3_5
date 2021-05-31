package sample.transport.Adapter;

import sample.transport.vehicle.Car;
import sample.transport.vehicle.Ship;


public class CarAdapter extends Ship {
    Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void swim() {
        System.out.println("car swim");
    }
}