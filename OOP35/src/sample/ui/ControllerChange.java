package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.transport.engine.Engine;
import sample.transport.engine.LightEngine;
import sample.transport.vehicle.*;

public class ControllerChange {
    @FXML
    Text t_info;

    @FXML
    Button btn_change;

    @FXML
    RadioButton radio_engine1;
    Engine engine1 = LightEngine.getEngine();

    @FXML
    RadioButton radio_engine2;
    Engine engine2 = LightEngine.getEngine();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() {
        Vehicle current = XCell.changeVehicle;

        t_info.setText(current.getVehicleType() + "   " + current.getVehicleModel()
                + "   " + "speed = " + current.getSpeed());

        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        if (current.getSpeed().equals("10"))
            radio_engine1.setSelected(true);
        else
            radio_engine2.setSelected(true);

        tf_model.setText(current.getVehicleModel());

        btn_change.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (model != null) {
                Engine engine = engine1;
                if (radio_engine2.isSelected())
                    engine = engine2;
                current.setVehicleModel(model);
                current.setEngine(engine);
                XCell.changeVehicle = null;

                Stage stage = (Stage) btn_change.getScene().getWindow();
                stage.close();

            }
        });
    }
}
