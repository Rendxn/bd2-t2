package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class Controller {
    @FXML
    private void switchQuery(ActionEvent event) throws IOException {
        Main.setRoot("query");
    }
    @FXML
    private void switchRegistrySeller(ActionEvent event) throws IOException {
        Main.setRoot("registrySeller");
    }
    @FXML
    private void switchRegistryProfit(ActionEvent event) throws IOException {
        Main.setRoot("registryProfit");
    }
}
