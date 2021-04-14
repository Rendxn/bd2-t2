package app.controllers;

import app.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.google.gson.internal.LinkedTreeMap;
import javafx.scene.control.cell.PropertyValueFactory;
import multichain.object.*;
import multichain.command.*;

import app.models.Seller;

public class ShowSellerController implements Initializable {

    public ArrayList<Seller> sellers;
    public HashMap<String, Double> profits;

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
        Main.setRoot("views/home");
    }

    @FXML
    public TableView<Seller> table;

    @FXML
    public TableColumn id;

    @FXML
    public TableColumn profit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<StreamKeyItem> sellerRaw;
        ArrayList<StreamKeyItem> profitRaw;
        sellers = new ArrayList<>();
        profits = new HashMap<>();

        try {
            sellerRaw = (ArrayList<StreamKeyItem>) Main.commandManager.invoke(CommandElt.LISTSTREAMITEMS, "vendedores");
            profitRaw = (ArrayList<StreamKeyItem>) Main.commandManager.invoke(CommandElt.LISTSTREAMITEMS, "ganancias");

            profitRaw.forEach(streamKeyItem -> {
                // LinkedTreeMap returned by the getData method
                LinkedTreeMap data = (LinkedTreeMap) streamKeyItem.getData();
                LinkedTreeMap json = (LinkedTreeMap) data.get("json");
                Double profit = (Double) json.get("valor");

                // Key (id)
                ArrayList<String> keys = (ArrayList<String>) streamKeyItem.getKeys();
                String id = keys.get(0);

                profits.computeIfPresent(id, (key, val) -> val + profit);
                profits.putIfAbsent(id, profit);
            });

            sellerRaw.forEach(streamKeyItem -> {
                // LinkedTreeMap returned by the getData method
                LinkedTreeMap data = (LinkedTreeMap) streamKeyItem.getData();
                LinkedTreeMap json = (LinkedTreeMap) data.get("json");
                String name = json.get("nombre").toString();
                String phone = json.get("telefono").toString();

                // Key (id)
                ArrayList<String> keys = (ArrayList<String>) streamKeyItem.getKeys();
                String id = keys.get(0);

                sellers.add(new Seller(id, name, phone, profits.getOrDefault(id, 0.0)));

            });

            // Create the ObservableList that is bound to the table
            // And set the CellValueFactory
            ObservableList<Seller> $sellers = FXCollections.observableList(sellers);
            table.setItems($sellers);
            if (!sellers.isEmpty()) {
                id.setCellValueFactory(new PropertyValueFactory<>(sellers.get(0).idProperty().getName()));
                profit.setCellValueFactory(new PropertyValueFactory<>(sellers.get(0).profitProperty().getName()));
            }

        } catch (MultichainException e) {
            e.printStackTrace();
            return;
        }

    }

}
