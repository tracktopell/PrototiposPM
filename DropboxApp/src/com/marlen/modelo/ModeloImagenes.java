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
						File files = new File("uploads/" +name);
						
						InputStream in = new FileInputStream(file);
						  OutputStream out = new FileOutputStream(files);	
						  msg = file.getName();
						  System.out.println(msg);
							VentanaSubida.txtAUpload.append(msg + "\n");
								
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
	
	public void archivosExistentes(){
		// Aquí la carpeta donde queremos buscar
        String path = "uploads"; 

        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 

        for (int i = 0; i < listOfFiles.length; i++)         {

            if (listOfFiles[i].isFile())             {
                files = listOfFiles[i].getName();
                System.out.println(files);
               VentanaSubida.txtAUpload.append(files + "\n");
            }
        }
    }
	
	
}
