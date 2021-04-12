package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class Query {


    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("home");
    }
}
