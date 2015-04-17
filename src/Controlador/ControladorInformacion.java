/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.GuiBuscar;
import Modelo.RegistroArchivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author peque
 */
public class ControladorInformacion implements ActionListener {

    GuiBuscar buscar;
    RegistroArchivos registro;

    public ControladorInformacion( GuiBuscar buscar,RegistroArchivos registroArchivos) {
        this.buscar = buscar;
        this.registro=registroArchivos;

    }

    @Override

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(GuiBuscar.BTN_BUSCAR)) {
           
            registro.seleccion();
            buscar.setjCargarInformacion(registro.getGuardarRutas());

        }
        if (evento.getActionCommand().equalsIgnoreCase(GuiBuscar.BTN_SALIR)) {
            System.exit(0);
        }
    }

}
