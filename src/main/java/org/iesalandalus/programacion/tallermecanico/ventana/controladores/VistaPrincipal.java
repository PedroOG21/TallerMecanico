package org.iesalandalus.programacion.tallermecanico.ventana.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.iesalandalus.programacion.tallermecanico.ventana.utilidades.Controlador;
import org.iesalandalus.programacion.tallermecanico.ventana.utilidades.Controladores;

public class VistaPrincipal extends Controlador{

    @FXML
    void btBorrarCliente(ActionEvent event) {

    }

    @FXML
    void btBorrarTrabajo(ActionEvent event) {

    }

    @FXML
    void btBorrarVehiculo(ActionEvent event) {

    }

    @FXML
    void btBuscarCliente(ActionEvent event) {

    }

    @FXML
    void btBuscarTrabajo(ActionEvent event) {

    }

    @FXML
    void btBuscarVehiculo(ActionEvent event) {

    }

    @FXML
    void btInsertarCliente(ActionEvent event) {
        Controlador ventanaPrincipal = Controladores.get("/vista/ventanaInsertarCliente.fxml", "Taller Mecánico",null);
        ventanaPrincipal.getEscenario().show();
    }

    @FXML
    void btInsertarTrabajo(ActionEvent event) {

    }

    @FXML
    void btInsertarVehiculo(ActionEvent event) {

    }

    @FXML
    void btListarCliente(ActionEvent event) {

    }

    @FXML
    void btListarTrabajo(ActionEvent event) {

    }

    @FXML
    void btListarVehiculo(ActionEvent event) {

    }

}
