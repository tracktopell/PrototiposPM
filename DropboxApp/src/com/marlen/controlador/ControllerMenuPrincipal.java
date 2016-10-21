package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.jws.Oneway;
import javax.swing.JOptionPane;

import com.dropbox.core.DbxException;
import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.MenuPrincipal;
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
	VentanaSubida ventanaUpload = VentanaSubida.instanciaVentanaUpload();
	if (button==vista.getBtnSubirArchivo()) {
		modelo.abrirVentana(ventanaUpload);
		ControllerUploadFiles controller = new ControllerUploadFiles(ventanaUpload, modelo);
	}
}




}
