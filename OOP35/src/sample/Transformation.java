package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import sample.transport.vehicle.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Transformation {
    public  String transform(String xml) throws IOException, JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Vehicle.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Vehicle current = (Vehicle) un.unmarshal(reader);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(current);
            jsonString = jsonString.substring(0, jsonString.indexOf("\"xml\"") - 1) + "}";

        return jsonString;
    }
}
