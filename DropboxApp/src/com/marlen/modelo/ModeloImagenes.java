package com.marlen.modelo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.marlen.vista.VentanaSubida;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public  class ModeloImagenes {
private VentanaSubida vista;


	public void subirArchivos(){
		
		//Creamos el objeto JFileChooser
		JFileChooser fc=new JFileChooser();

		//Indicamos que podemos seleccionar varios ficheros
		fc.setMultiSelectionEnabled(true);

		//Indicamos lo que podemos seleccionar
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		//Creamos el filtro
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");

		//Le indicamos el filtro
		fc.setFileFilter(filtro);

		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
		int seleccion=fc.showOpenDialog(vista);

		//Si el usuario, pincha en aceptar
		if(seleccion==JFileChooser.APPROVE_OPTION){

			//Seleccionamos el fichero
			File[] ficheros=fc.getSelectedFiles();

			for(int i=0;i<ficheros.length;i++){
				try(FileReader fr=new FileReader(ficheros[i])){
					String cadena="";
					int valor=fr.read();
					while(valor!=-1){
						cadena=cadena+(char)valor;
						valor=fr.read();
					}
					
					vista.textArea.append(cadena+"\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
}
}