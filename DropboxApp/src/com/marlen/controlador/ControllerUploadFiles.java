package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloImagenes;
import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.VentanaSubida;

public class ControllerUploadFiles implements ActionListener{

	private VentanaSubida vista;
	private ModeloVentana modelo;
	
	
	public ControllerUploadFiles(VentanaSubida vista, ModeloVentana modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.listenerUpload(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		ModeloDropBox model = ModeloDropBox.instanciaAutentificacion();
		ModeloImagenes modelImage = new ModeloImagenes();
		if (button==vista.getBtnSubir()) {
			model.uploadFiles();
		} 
		else if(button==vista.getBtnSeleccionar()){
			modelImage.subirArchivos();
		}
		
	}

}