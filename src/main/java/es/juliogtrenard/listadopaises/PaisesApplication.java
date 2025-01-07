package es.juliogtrenard.listadopaises;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase para ejecutar la aplicacion principal sobre un informe de paises
 */
public class PaisesApplication extends Application {
    /**
     * Muestra la ventana de la aplicacion
     *
     * @param stage la ventana de la aplicacion
     *
     * @throws IOException Se lanza en caso de errores de IO
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaisesApplication.class.getResource("/es/juliogtrenard/listadopaises/fxml/paises.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PAISES");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * El punto de entrada de la aplicacion
     *
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {
        launch();
    }
}