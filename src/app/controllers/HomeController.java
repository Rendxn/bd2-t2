package app.controllers;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class Controller {
    @FXML
    private void switchQuery(ActionEvent event) throws IOException {
        Main.setRoot("views/query");
    }
    @FXML
    private void switchRegistrySeller(ActionEvent event) throws IOException {
        Main.setRoot("views/registrySeller");
    }
    @FXML
    private void switchRegistryProfit(ActionEvent event) throws IOException {
        Main.setRoot("views/registryProfit");
    }
}
