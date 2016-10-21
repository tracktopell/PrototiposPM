package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.jws.Oneway;
import javax.swing.JOptionPane;

import com.dropbox.core.DbxException;
import com.marlen.modelo.Autentificacion;
import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.MenuPrincipal;

public class ControllerMenuPrincipal implements ActionListener{
private MenuPrincipal vista;
private Autentificacion modelo;
public ControllerMenuPrincipal(MenuPrincipal vista, Autentificacion modelo) {
	this.vista = vista;
	this.modelo = modelo;
	vista.listenerAutenficacion(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	
}




}
