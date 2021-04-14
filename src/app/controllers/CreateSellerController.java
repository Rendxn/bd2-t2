package app.controllers;

import app.Main;
import com.google.gson.JsonObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

import javafx.scene.text.Text;
import multichain.object.*;
import multichain.command.*;

public class CreateSellerController {

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("views/home");
    }

    @FXML
    TextField id;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    Text msgBox;

    public void createSeller() {

        String cedula = id.getText().trim();
        String nombre = name.getText().trim();
        String telefono = phone.getText().trim();

        JsonObject innerJson = new JsonObject();
        innerJson.addProperty("nombre", nombre);
        innerJson.addProperty("telefono", telefono);
        JsonObject extJson = new JsonObject();
        extJson.add("json", innerJson);

        try {
            Main.commandManager.invoke(CommandElt.PUBLISH, "vendedores", cedula, extJson);
            msgBox.setText("Se agregó con éxito.");
            id.clear();
            name.clear();
            phone.clear();
        } catch (MultichainException e) {
            e.printStackTrace();
            msgBox.setText("No se pudo agregar el vendedor. " + e.getMessage());
            return;
        }
    }
    
}
