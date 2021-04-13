package app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class CreateSeller {

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("views/home");
    }
    
}
