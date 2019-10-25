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
                                                                                                //Skaber et object af JDBC connection
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


    public void routeHandler(ActionEvent e) throws SQLException {
        String url = "jdbc:sqlite:/Users/williamkilschowpetersen/Documents/5. Semester RUC/Software Development/databaser/TravelersFriend1.db";
        conn = m.retriever.connect(url);                                                        //Connection objektet, retriever, skaber adgang til databasen
        System.out.println("you have reached connection");                                      //Fortæller os at forbindelsen er opnået
        PreparedStatement Feedback = m.retriever.selectpreparedstatement(conn);                 //Kører vores selectpreparedstatement fra JDBCConnection
        Feedback.setString(1, stat1.getText());                                  //Sørger for at den indtastede station i GUI får den rigtige placering i vores query
        Feedback.setString(2, stat2.getText());
        ResultSet pres = Feedback.executeQuery();                                               //Resultatet er vores preparedstatement som henter vores eksekverede query
        m.retriever.PresentRoute(pres);                                                         //Vores JDBC objekt præsenterer den indsamlede data
        ResultSet result = m.retriever.plainstatement(stat1.getText(), conn);
        res.setText(m.retriever.PresentRoute(result));                                          //Viser den fundne data i tekstfeltet i vores GUI
        System.out.println(m.retriever.PresentRoute(pres));                                     //Printer den fundne data ud i konsollen.
    }


}


