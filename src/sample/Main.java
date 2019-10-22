package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Scanner;




public class Main extends Application  {
    public  JDBCConnection retriever;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GUI Lecture");
        primaryStage.setScene(new Scene(root, 350, 500));
        primaryStage.show();

         retriever = new JDBCConnection();
        //Connection er en del af SQLlib
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:/Users/williamkilschowpetersen/Documents/5. Semester RUC/Software Development/databaser/TravelersFriend1.db";
            //Connection objektet, retriever, skaber adgang til databasen
            conn = retriever.connect(url);
            System.out.println("you have reached connection");



            System.out.println("At which station do you wish to depart?");
            Scanner scanner = new Scanner(System.in);
            String station1 = scanner.nextLine();
            System.out.println("Choose destination: ");
            String station2 = scanner.nextLine();
            //Vi laver et preparedstatement kaldet feedback, som kører vores selectpreparedstatement på vores JDBC objekt.
            PreparedStatement Feedback = retriever.selectpreparedstatement(conn);
            Feedback.setString(1, station1);
            Feedback.setString(2, station2);
            //Resultatet er vores preparedstatement som henter vores eksekverede query
            ResultSet pres = Feedback.executeQuery();
            //Vores JDBC objekt præsenterer den indsamlede data
            retriever.PresentRoute(pres);
            ResultSet res = retriever.plainstatement(station1, conn);
            retriever.PresentRoute(res);

        /*Hvis der opstår en fejl med forbindelsen til
         databasen bliver stacktrace printet, så fejlen kan findes*/
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Lukker vores connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {


        launch(args);

    }

}




