package es.juliogtrenard.listadopaises.controller;

import es.juliogtrenard.listadopaises.PaisesApplication;
import es.juliogtrenard.listadopaises.dao.DaoPais;
import es.juliogtrenard.listadopaises.db.DBConnect;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Clase que controla los eventos de la ventana principal
 */
public class PaisesController implements Initializable {
    /**
     * Se ejecuta cuando se inicia la ventana
     *
     * @param url la url
     * @param resourceBundle los recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lanzarInforme(null);
    }

    /**
     * Carga y lanza el informe de JasperReport
     *
     * @param event el evento
     */
    @FXML
    void lanzarInforme(ActionEvent event) {
        DBConnect connection;

        try {
            connection = new DBConnect();

            // Carga los paises
            HashMap<String, Object> parameters = DaoPais.findAll();

            // Busca el informe
            JasperReport report = (JasperReport) JRLoader.loadObject(PaisesApplication.class.getResource("report/ListadoPaises.jasper"));

            // Carga el informe
            JasperPrint jprint = JasperFillManager.fillReport(report, parameters, connection.getConnection());

            // Instancia la vista del informe para mostrar el informe
            JasperViewer viewer = new JasperViewer(jprint, false);

            // Muestra el informe
            viewer.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar el informe");
            Platform.exit();
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar los paises");
            Platform.exit();
        }
    }

    /**
     * Muestra un mensaje de alerta al usuario
     *
     * @param mensaje de error a mostrar
     */
    public void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}