package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class RegistryProfit {


    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("home");
    }
}
