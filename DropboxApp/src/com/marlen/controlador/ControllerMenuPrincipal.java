package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloImagenes;
import com.marlen.modelo.ModeloVentana;
import com.marlen.modelo.Utils;
import com.marlen.vista.MenuPrincipal;
import com.marlen.vista.VentanaDescarga;
import com.marlen.vista.VentanaSubida;

public class ControllerMenuPrincipal implements ActionListener{
private MenuPrincipal vista;
private ModeloVentana modelo;
public ControllerMenuPrincipal(MenuPrincipal vista, ModeloVentana modelo) {
	this.vista = vista;
	this.modelo = modelo;
	vista.listenerAutenficacion(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	Object button = e.getSource();
	VentanaSubida ventanaUpload = new VentanaSubida(Utils.SELECCIONAR_ARCHIVOS, 480, 600);
	VentanaDescarga ventanaDownload = VentanaDescarga.instanciaVentanaDownload();
	ModeloDropBox model = ModeloDropBox.instanciaAutentificacion();
	ModeloImagenes modelImage = ModeloImagenes.instanceImagens();
	
	if (button==vista.getBtnSubirArchivo()) {
		ventanaUpload.setVisible(true);
		@SuppressWarnings("unused")
		ControllerUploadFiles controller = new ControllerUploadFiles(ventanaUpload, modelo);
		modelImage.archivosExistentes();
	}else if(button==vista.getBtnBajarArchivos()){
		modelo.abrirVentana(ventanaDownload);
		@SuppressWarnings("unused")
		ControllerDownloandsFiles controller = new ControllerDownloandsFiles(ventanaDownload, modelo);
		model.listFiles();
		

	}
}




}
