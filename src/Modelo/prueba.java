/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
 import java.io.*;
/**
 *
 * @author peque
 */
public class prueba {
   
 
public void puebaczdc(File dirOrigen, File dirDestino) throws Exception { 
	try {
		if (dirOrigen.isDirectory()) { 
			if (!dirDestino.exists())
				dirDestino.mkdir(); 
 
			String[] hijos = dirOrigen.list(); 
			for (int i=0; i < hijos.length; i++) { 
				puebaczdc(new File(dirOrigen, hijos[i]), 
					new File(dirDestino, hijos[i])); 
			} // end for
		} else { 
			Copiar(dirOrigen, dirDestino); 
		} // end if
	} catch (Exception e) {
		throw e;
	} // end try
} // end CopiarDirectorio

 
public  void Copiar(File dirOrigen, File dirDestino) throws Exception { 
 
	InputStream in = new FileInputStream(dirOrigen); 
	OutputStream out = new FileOutputStream(dirDestino); 
 
	byte[] buffer = new byte[1024];
	int len;
 
	try {
		// recorrer el array de bytes y recomponerlo
		while ((len = in.read(buffer)) > 0) { 
			out.write(buffer, 0, len); 
		} // end while
		out.flush();
	} catch (Exception e) {
		throw e;
	} finally {
		in.close(); 
		out.close(); 
	} // end ty
} // end Copiar
 
/*public  void Copiar(String dirOrigen, String dirDestino) throws Exception { 
	InputStream in = new FileInputStream(dirOrigen); 
	OutputStream out = new FileOutputStream(dirDestino); 
 
	byte[] buffer = new byte[1024];
	int len;
 
	try {
		// recorrer el array de bytes y recomponerlo
		while ((len = in.read(buffer)) > 0) { 
			out.write(buffer, 0, len); 
		} // end while
		out.flush();
	} catch (Exception e) {
		throw e;
	} finally {
		in.close(); 
		out.close(); 
	} // end ty
} // end Copiar*/
public static void main(String[] args) throws Exception {

prueba provar=new prueba();
provar.puebaczdc(null, null);
}
    }


