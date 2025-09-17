package dude.gui;

import dude.Dude;
import dude.command.Command;
import dude.command.ExitCommand;
import dude.parser.Parser;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Dude dude;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.png"));
    private Image dudeImage = new Image(this.getClass().getResourceAsStream("/images/gigachad.png"));

    /**
     * Initializes the main window.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getDudeDialog(Dude.getHelloMessage(), dudeImage)
        );
    }

    /** Injects the Dude instance */
    public void setDude(Dude d) {
        dude = d;
    }

    /**
     * Creates two dialog boxes, one for user input and the other for Dude's reply.
     * Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        Command cmd = Parser.parse(input);
        String response = dude.getResponse(cmd);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDudeDialog(response, dudeImage)
        );
        userInput.clear();

        if (cmd.isExit()) {
            assert cmd instanceof ExitCommand : "Command is instance of ExitCommand when exiting.";

            // Let user read message before closing
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
    }
}
