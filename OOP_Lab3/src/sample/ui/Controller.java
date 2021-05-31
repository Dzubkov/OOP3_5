package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.plugins.Plagin2;
import sample.plugins.Plagin1;
import sample.plugins.Transformation;
import sample.transport.engine.Engine;
import sample.transport.engine.HeavyEngine;
import sample.transport.engine.LightEngine;
import sample.transport.vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    ListView<Vehicle> listView;
    ObservableList<Vehicle> listTransport;

    @FXML
    ComboBox<Vehicle> cb_transport;
    ObservableList<Vehicle> transport;

    @FXML
    Button btn_add;

    @FXML
    RadioButton radio_engine1;
    Engine engine1 = LightEngine.getEngine();

    @FXML
    RadioButton radio_engine2;
    Engine engine2 = HeavyEngine.getEngine();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        read();
        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        transport = FXCollections.observableArrayList(
                new Car(), new Train(), new Boat(),
                new Ship(), new Helicopter(), new Plain());
        cb_transport.setItems(transport);
        btn_add.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (cb_transport.getValue() != null && model != null) {
                Engine engine = engine1;
                if (radio_engine2.isSelected())
                    engine = engine2;
                Vehicle newTransport = cb_transport.getValue().create(model, engine);
                listTransport.add(newTransport);
                try {
                    write();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listView.setItems(listTransport);
        listView.setCellFactory(param -> new XCell(listTransport));
    }

    public void read() throws IOException, ClassNotFoundException {
        try {
            listTransport = FXCollections.observableArrayList();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList list = (ArrayList) objectInputStream.readObject();
            for (int i = 0; i < list.size(); i++) {
                listTransport.add((Vehicle) list.get(i));
            }
            objectInputStream.close();


    }catch (Exception e){
    }
    }

   private void write() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            List<Vehicle> list = new ArrayList<>(listTransport);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            int nom = 0;
            for (int i = 0; i < listTransport.size(); i++) {
                File out = new File("XML/" + i + ".xml");
                out.createNewFile();
                PrintWriter pw = new PrintWriter(out);
                String xml = listTransport.get(i).getXML();
                Transformation trans2 = new Plagin2();
                pw.write(xml);
                pw.close();
                Transformation trans = new Plagin1();
                String res = trans.transform(xml);
                File in = new File("JSON/" + i + ".json");
                PrintWriter pw2 = new PrintWriter(in);
                pw2.write(res);
                pw2.close();
            }
            PrintWriter writer1 = new PrintWriter("file.xml");
            String xml = "";
            for (int i = 0; i < list.size(); i++) {
                xml += list.get(i).getXML();
            }
            writer1.write(xml);
            writer1.close();
            FileWriter writer = new FileWriter("text.txt");
            for (Vehicle vehicle : list) {
                writer.write(vehicle.getVehicleType());
                writer.write(" ");
                writer.write(vehicle.getVehicleModel());
                writer.write(" ");
                writer.write(vehicle.getClass().toString());
                writer.write(" ");
                writer.write(vehicle.getSpeed());
                writer.write("\n");
                writer.flush();
            }

        }catch(Exception e){

        }
    }






}
