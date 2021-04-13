package app.controllers;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

import multichain.object.*;
import multichain.command.*;

public class ShowVendedores {

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("views/home");
    }

    @FXML
    public void initialize(ActionEvent event) {

    }

}
