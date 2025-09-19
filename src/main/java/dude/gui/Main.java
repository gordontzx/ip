package dude.gui;

import java.io.IOException;

import dude.Dude;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Dude using FXML.
 */
public class Main extends Application {
    private static final String FILE_PATH = "data/data.csv";
    private static final String WINDOW_TITLE = "Dude";

    private Dude dude;

    @Override
    public void start(Stage stage) {
        dude = new Dude(FILE_PATH);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDude(dude); // inject the Duke instance

            stage.setTitle(WINDOW_TITLE);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
