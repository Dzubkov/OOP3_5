package sample.plugins;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import sample.transport.vehicle.Vehicle;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Plagin2 implements Transformation {
    @Override
    public String transform(String xml) throws IOException, JAXBException {
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ObservableList<Vehicle> listTransport = new ObservableListBase<Vehicle>() {
            @Override
            public Vehicle get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
        List<Vehicle> list = new ArrayList<>(listTransport);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
        int nom = 0;
        for (int i = 0; i < listTransport.size(); i++) {
            File out = new File("XML/" + i + ".xml");
            out.createNewFile();
            PrintWriter pw = new PrintWriter(out);
            xml = listTransport.get(i).getXML();
            pw.write(xml);
            pw.close();
            Transformation trans = new Plagin1();
            String res = trans.transform(xml);
            File in = new File("JSON/" + i + ".json");
            PrintWriter pw2 = new PrintWriter(in);
            pw2.write(res);
            pw2.close();
        }
        return xml;
    }
}
