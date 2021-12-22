module com.example.aproj {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires java.naming;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires junit;
    requires java.desktop;

    opens com.example.aproj to org.hibernate.orm.core,javafx.fxml ;

    exports com.example.aproj;
    exports com.example.aproj.Controllers;
    opens com.example.aproj.Controllers to javafx.fxml;
    exports com.example.aproj.DBHandlers;
    opens com.example.aproj.DBHandlers to javafx.fxml;
    exports com.example.aproj.Exceptions;
    opens com.example.aproj.Exceptions to javafx.fxml;
    exports com.example.aproj.Classes;
    opens com.example.aproj.Classes to javafx.fxml;
    exports com.example.aproj.TestCases;
    opens com.example.aproj.TestCases to javafx.fxml;


}