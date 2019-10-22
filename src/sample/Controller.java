package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller extends Main{

    // TrainModel m = TrainModel.getInstance();

    @FXML
    TextField stat1;
    @FXML
    TextField stat2;
    @FXML
    TextField time;
    @FXML
    Button btn;
    @FXML
    TextArea res;
    @FXML
    ComboBox stat3;

    /*Controller() {

        for (String s : TrainModel.getInstance().getStations()) {

            stat3.getItems().add(s);

        }
    }*/

    public void routeHandler(ActionEvent e) {

        System.out.println("Søg");
        res.setText(findRoute(stat1.getText(), stat2.getText(), time.getText()));

    }


    String[] getStations() {

        String[] s = new String[]{"København", "Roskilde", "Odense"};
        return s;
    }

    public String findRoute(String stat1, String stat2, String time) {

        return "Rute fra " + stat1 + "\ntil " + stat2 + " kl. " + time;
    }

}
