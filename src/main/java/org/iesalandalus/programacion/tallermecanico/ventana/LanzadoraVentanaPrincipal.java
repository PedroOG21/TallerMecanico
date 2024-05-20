package org.iesalandalus.programacion.tallermecanico.ventana;

import javafx.application.Application;
import javafx.stage.Stage;
import org.iesalandalus.programacion.tallermecanico.ventana.utilidades.Controlador;
import org.iesalandalus.programacion.tallermecanico.ventana.utilidades.Controladores;
import org.iesalandalus.programacion.tallermecanico.vista.grafica.VistaGrafica;
public class LanzadoraVentanaPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controlador ventanaPrincipal = Controladores.get("/vista/vistaPrincipal.fxml", "Taller Mecánico",null);
        ventanaPrincipal.addIcono("/imagenes/ies.jpg");
        VistaGrafica.getInstancia().setVentanaPrincipal(ventanaPrincipal);
        ventanaPrincipal.getEscenario().show();
    }

    public static void comenzar (){
        launch(LanzadoraVentanaPrincipal.class);
    }
}
