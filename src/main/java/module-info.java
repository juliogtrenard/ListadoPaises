module es.juliogtrenard.listadopaises {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens es.juliogtrenard.listadopaises to javafx.fxml;
    exports es.juliogtrenard.listadopaises;
}