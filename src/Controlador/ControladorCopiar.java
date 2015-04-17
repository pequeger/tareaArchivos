/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.GuiCopiar;
import Modelo.RegistroArchivos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peque
 */
public class ControladorCopiar implements ActionListener{
    GuiCopiar copiar;
    RegistroArchivos registro;

    public ControladorCopiar(GuiCopiar copiar,RegistroArchivos registro) {
        this.copiar=copiar;
        this.registro=registro;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent evento) {
    if(evento.getActionCommand().equalsIgnoreCase(GuiCopiar.BTN_COPIAR)){
        try {
            registro.seleccionRuta();
        } catch (Exception ex) {
            Logger.getLogger(ControladorCopiar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    if(evento.getActionCommand().equalsIgnoreCase(GuiCopiar.BTN_SALIR)){
    System.exit(0);
    }
    }
    
    
}
