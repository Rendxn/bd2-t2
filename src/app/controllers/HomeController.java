package app.controllers;

import java.io.IOException;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class HomeController {
    @FXML
    private void goToShowSellers(ActionEvent event) throws IOException {
        Main.setRoot("views/show.seller");
    }
    @FXML
    private void goToCreateSeller(ActionEvent event) throws IOException {
        Main.setRoot("views/create.seller");
    }
    @FXML
    private void goToCreateProfit(ActionEvent event) throws IOException {
        Main.setRoot("views/create.profit");
    }
}
