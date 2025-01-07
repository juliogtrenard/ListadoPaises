module es.juliogtrenard.listadopaises {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens es.juliogtrenard.listadopaises to javafx.fxml;
    exports es.juliogtrenard.listadopaises;
    exports es.juliogtrenard.listadopaises.controller;
    opens es.juliogtrenard.listadopaises.controller to javafx.fxml;
    exports es.juliogtrenard.listadopaises.db;
    exports es.juliogtrenard.listadopaises.dao;
    exports es.juliogtrenard.listadopaises.model;
}