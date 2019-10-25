package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {

    Model m = Model.getInstance();
    Connection conn;


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


    public Controller() throws SQLException {
    }

    /*Controller() {

        for (String s : TrainModel.getInstance().getStations()) {

            stat3.getItems().add(s);

        }
    }*/

    public void routeHandler(ActionEvent e) throws SQLException {
        String url = "jdbc:sqlite:/Users/williamkilschowpetersen/Documents/5. Semester RUC/Software Development/databaser/TravelersFriend1.db";
        conn = m.retriever.connect(url);                                                        //Connection objektet, retriever, skaber adgang til databasen
        System.out.println("you have reached connection");
        PreparedStatement Feedback = m.retriever.selectpreparedstatement(conn);
        Feedback.setString(1, stat1.getText());
        Feedback.setString(2, stat2.getText());
        ResultSet pres = Feedback.executeQuery();                                               //Resultatet er vores preparedstatement som henter vores eksekverede query
        m.retriever.PresentRoute(pres);                                                         //Vores JDBC objekt præsenterer den indsamlede data
        ResultSet result = m.retriever.plainstatement(stat1.getText(), conn);
        res.setText(m.retriever.PresentRoute(result));
        System.out.println(m.retriever.PresentRoute(pres));
    }


}


