module es.juliogtrenard.listadopaises {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.juliogtrenard.listadopaises to javafx.fxml;
    exports es.juliogtrenard.listadopaises;
}