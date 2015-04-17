/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JFileChooser;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author peque
 */
public class RegistroArchivos {

    String auxRuta = "";
    String datosInformacion;
    File file, origen, destino;
    int cont = 0;

    public void seleccion() {
        try{
        JFileChooser selector = new JFileChooser();//ventana que se muestra
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//para abrir archivos y carpetas
        selector.showOpenDialog(null);
        file = selector.getSelectedFile();//le asignamos lo que seleciono el JFilechooser()
        buscarInformacion(file);
        } catch (Exception e) {
            throw e;
        } // end try
    }

    public void buscarInformacion(File file) {
        File[] array = file.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                auxRuta += "\n" + array[i].getAbsolutePath();
                setGuardarRutas(auxRuta);
            } else if (array[i].isDirectory()) {
                auxRuta += "\n" + array[i].getAbsolutePath();

                File lista = array[i].getAbsoluteFile();
                setGuardarRutas(auxRuta);
                buscarInformacion(lista);

            }
        }

    }

    public void setGuardarRutas(String ruta) {
        datosInformacion += ruta + "\n";
         

    }

    public String getGuardarRutas() {
       
        return datosInformacion;

    }

    public void seleccionRuta() throws IOException, Exception {
        try{
        JFileChooser selector = new JFileChooser();//ventana que se muestra
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//para abrir archivos y carpetas
        selector.showOpenDialog(null);
        origen = selector.getSelectedFile();//le asignamos lo que seleciono el JFilechooser()
        // permite saber la ruta de origen
        selector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//para abrir archivos y carpetas
        selector.showSaveDialog(null);
        destino = selector.getSelectedFile();//le asignamos lo que seleciono el JFilechooser()
        //permite saber la ruta de destino
        rutaArchivo(origen, destino);
        //envia datos por parametros al metodo recursivo
        } catch (Exception e) {
            throw e;
        } // end try
    }

    public  void rutaArchivo(File origen, File destino) throws Exception {
       // metodo recursivo para verificar archivo
        try {
            if (origen.isDirectory()) {
                // verifica si el archivo es directorio o file
                if (!destino.exists()) {
                    //verifica si el directorio existe
                    destino.mkdir();
                    //crea el directorio en el destino en caso de no exitir
                }
                String[] array = origen.list();
                // realiza arreglo dnd se guarda la lista de archivos de origen
                for (String rutas : array) {
                    rutaArchivo(new File(origen, rutas), new File(destino, rutas));
                } // end for
            } else {
                copiarInformacion(origen, destino);
            } // end if
        } catch (Exception e) {
            throw e;
        } // end try
    } // end CopiarDirectorio

    public static void copiarInformacion(File origen, File destino) throws Exception {

        InputStream ingreso = new FileInputStream(origen);
        OutputStream salida = new FileOutputStream(destino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = ingreso.read(buffer)) > 0) {
                salida.write(buffer, 0, len);
            } // end while
            salida.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            ingreso.close();
            salida.close();
        } // end ty
    } // end Copiar

    public static void Copiar(String origen, String destino) throws Exception {
        InputStream ingreso = new FileInputStream(origen);
        OutputStream salida = new FileOutputStream(destino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = ingreso.read(buffer)) > 0) {
                salida.write(buffer, 0, len);
            } // end while
            salida.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            ingreso.close();
            salida.close();
        } // end ty
    } // end Copiar

 

    /*public void copiarArchivos(String origen, String destino) throws IOException {
     Path FROM = Paths.get(origen);
     Path TO = Paths.get(destino);
     //sobreescribir el fichero de destino, si existe, y copiar
     // los atributos, incluyendo los permisos rwx
     CopyOption[] options = new CopyOption[]{
     StandardCopyOption.COPY_ATTRIBUTES,
     StandardCopyOption.valueOf(destino)}; 
     Files.copy(FROM, TO, options);
     }*/
}
