package com.marlen.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.marlen.vista.VentanaSubida;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class ModeloImagenes {
private VentanaSubida vista;
private static ModeloImagenes modelImagens = new ModeloImagenes();

private ModeloImagenes() {
	// TODO Auto-generated constructor stub
}

public static ModeloImagenes instanceImagens(){
	return modelImagens;
}

	public String  subirArchivos() throws IOException{
		String msg = null;
		//Creamos el objeto JFileChooser
		JFileChooser fc=new JFileChooser();
		//Indicamos que podemos seleccionar varios ficheros
		fc.setMultiSelectionEnabled(true);
		//Indicamos lo que podemos seleccionar
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
		int seleccion=fc.showOpenDialog(vista);
		//Si el usuario, pincha en aceptar
		if(seleccion==JFileChooser.APPROVE_OPTION){
			//Seleccionamos el fichero
			File[] ficheros=fc.getSelectedFiles();
			
			
			
					for(File file: ficheros){
						String name = file.getName();
						File	 files = new File("uploads/" +name);
						
						 System.out.println(files.getPath());
						InputStream in = new FileInputStream(file);
						  OutputStream out = new FileOutputStream(files);
								System.out.println(file.getName());		
								msg = file.getName() + "\n";
						  byte[] buf = new byte[1024];
						  int len;

						  while ((len = in.read(buf)) > 0) {
						    out.write(buf, 0, len);
						  }
								
						  in.close();
						  out.close();	 
						 
						
					}
				//
			}
		
		
		return msg;
}
	
}
