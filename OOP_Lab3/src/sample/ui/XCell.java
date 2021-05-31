package sample.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import sample.plugins.Transformation;
import sample.plugins.Plagin1;
import sample.transport.vehicle.Vehicle;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XCell extends ListCell<Vehicle> {
    public static Vehicle changeVehicle = null;
    HBox hbox = new HBox();
    Label type = new Label("");
    Label name = new Label("");
    Label speed = new Label("");
    Pane pane = new Pane();
    Button del = new Button("x");
    Button change = new Button("change");
    ObservableList<Vehicle> listTransport;
    public XCell(   ObservableList<Vehicle> listTransport) {
        this.listTransport = listTransport;
        hbox.getChildren().addAll(type, name, speed, pane, change, del);
        HBox.setHgrow(pane, Priority.ALWAYS);
        change.setOnAction(event -> {
            try {
                changeVehicle = getItem();
                URL url = new URL("file:D:\\OOP_Lab3\\src\\sample\\change.fxml");
                Parent root = FXMLLoader.load(url);
                Stage stage = new Stage();
                stage.setTitle("Change");
                stage.setScene(new Scene(root, 330, 145));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        del.setOnAction(event -> {getListView().getItems().remove(getItem());
           listTransport.remove(getListView().getItems());
            try {
                write();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void updateItem(Vehicle item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);

        if (item != null && !empty) {
            type.setText(item.getVehicleType() + "   ");
            name.setText(item.getVehicleModel() + "   ");
            speed.setText("speed = " + item.getSpeed());
            setGraphic(hbox);
        }
        try {
            write();
        } catch (IOException e) {
            e.printStackTrace();
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
                pw.write(xml);
                pw.close();
                ClassLoader loader = ObjectMapper.class.getClassLoader();
                Class<?> c = Class.forName("com.fasterxml.jackson.databind.ObjectMapper", true, loader);
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