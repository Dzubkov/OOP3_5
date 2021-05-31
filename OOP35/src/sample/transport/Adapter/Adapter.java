package sample.transport.Adapter;

import sample.transport.vehicle.Car;
import sample.transport.vehicle.Ship;


    public class Adapter extends Ship {
        Car car;

        public Adapter(Car car){
            this.car = car;
        }
    }