package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    /**
     * Metode der starter åbner GUI og sætter størrelsen på vinduet.
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Portfolio 2");
        primaryStage.setScene(new Scene(root, 350, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}




