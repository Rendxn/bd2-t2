package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import multichain.command.*;
import multichain.object.*;


public class Main extends Application {
    private static Scene scene;
    // So that everyone can access it
    public static CommandManager commandManager;

    @Override
    public void start(Stage stage) throws IOException {
        // Blockchain
        commandManager = new CommandManager(
                System.getProperty("MULTICHAIN_HOST", "localhost"),
                System.getProperty("MULTICHAIN_PORT", "2896"),
                System.getProperty("MULTICHAIN_RPCUSER", "multichainrpc"),
                System.getProperty("MULTICHAIN_RPCPASSWORD", "")
        );
        try {
            commandManager.invoke(CommandElt.SUBSCRIBE, "vendedores");
            commandManager.invoke(CommandElt.SUBSCRIBE, "ganancias");
        } catch (MultichainException e) {
            e.printStackTrace();
            return;
        }

        // UI
        scene = new Scene(loadFXML("views/home"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
