/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.GuiPrincipal;
import Vista.GuiBuscar;
import Vista.GuiCopiar;
import Modelo.RegistroArchivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author peque
 */
public class ControladorArchivos implements ActionListener{
    GuiPrincipal principal;
    GuiBuscar buscar; 
    GuiCopiar copiar;
    RegistroArchivos registro;

    public ControladorArchivos(GuiPrincipal principal) {
        this.principal = principal;
        this.registro = new RegistroArchivos();
 }
    
    

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equalsIgnoreCase(GuiPrincipal.BTN_BUSCAR)){
            buscar = new GuiBuscar(registro);
            buscar.setVisible(true);
        }
        if(evento.getActionCommand().equalsIgnoreCase(GuiPrincipal.BTN_COPIAR)){
            copiar=new GuiCopiar(registro);
            copiar.setVisible(true);
        }
        if(evento.getActionCommand().equalsIgnoreCase(GuiPrincipal.BTN_SALIR)){
        System.exit(0);
        }
   }
    
    
    
}
