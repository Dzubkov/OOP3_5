package sample.transport.vehicle;

import sample.transport.engine.Engine;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.*;

@XmlSeeAlso({Boat.class, Car.class, Helicopter.class, Plain.class, Ship.class, Train.class})
public abstract class Vehicle implements Serializable {
    protected String vehicleType;
    protected String vehicleModel;
    protected Engine engine;

    protected Vehicle(String vehicleType, String vehicleModel, Engine engine) {
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.engine = engine;
    }

    public String getXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Vehicle.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }


    public abstract Vehicle create(String vehicleModel, Engine engine);

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getSpeed() {
        if (engine != null)
            return engine.getSpeed();
        return "10";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
