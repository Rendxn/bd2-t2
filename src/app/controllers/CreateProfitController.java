package app.controllers;

import app.Main;
import app.models.Seller;
import com.google.gson.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.text.Text;
import multichain.object.*;
import multichain.command.*;

public class CreateProfitController implements Initializable {

    public ArrayList<String> sellersId;

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("views/home");
    }

    @FXML
    ChoiceBox<String> idChoiceBox;

    @FXML
    TextField profitTextField;

    @FXML
    Text msgBox;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ArrayList<StreamKey> sellerRaw;
        sellersId = new ArrayList<>();
        try {
            sellerRaw = (ArrayList<StreamKey>) Main.commandManager.invoke(CommandElt.LISTSTREAMKEYS, "vendedores");
            sellerRaw.forEach(streamKey -> {
                sellersId.add(streamKey.getKey());
            });
            ObservableList<String> $sellersId = FXCollections.observableList(sellersId);
            idChoiceBox.setItems($sellersId);
        } catch (MultichainException e) {
            e.printStackTrace();
            return;
        }
    }

    public void createProfit() {

        String cedula = idChoiceBox.getValue();
        String profitStr = profitTextField.getText().trim();
        double profit = Double.parseDouble(profitStr);

        JsonObject innerJson = new JsonObject();
        innerJson.addProperty("valor", profit);
        JsonObject extJson = new JsonObject();
        extJson.add("json", innerJson);

        try {
            Main.commandManager.invoke(CommandElt.PUBLISH, "ganancias", cedula, extJson);
            msgBox.setText("Se agregó con éxito la ganancia a " + cedula);
            profitTextField.clear();
        } catch (MultichainException e) {
            e.printStackTrace();
            msgBox.setText("No se pudo agregar la ganancia a " + cedula + ". " + e.getMessage());
            return;
        }
    }
}
