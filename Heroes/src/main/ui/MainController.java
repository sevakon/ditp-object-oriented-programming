package main.ui;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    private void startGameButtonPressed() {
        System.out.println("Start Game Button pressed");
    }

    @FXML
    private void optionsButtonPressed() {
        System.out.println("Options Button pressed");
    }

    @FXML
    private void quitButtonPressed() {
        System.out.println("Quit Button pressed");
    }
}
