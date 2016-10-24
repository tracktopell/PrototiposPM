package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.marlen.modelo.Cuenta1;
import com.marlen.modelo.Cuenta2;
import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloVentana;
import com.marlen.modelo.Utils;
import com.marlen.vista.MenuPrincipal;
import com.marlen.vista.Menu;
import com.marlen.vista.Ventana;

public class ControllerMenu implements ActionListener{
private Menu vista;
private ModeloVentana modelo;
private DbxClient dbxClient;



	public ControllerMenu(Menu vista, ModeloVentana modelo) {
	this.vista = vista;
	this.modelo = modelo;
	vista.listenerMenu(this);
}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		String url = "";
		
		MenuPrincipal MP = MenuPrincipal.instanciaMP();
		Cuenta1 cuenta1 = Cuenta1.instanciaCuenta1();
		Cuenta2 cuenta2 = Cuenta2.instanciaCuenta2();
		if(button==vista.getBtnCuenta1()){
			modelo.abrirVentana(MP);
			ControllerMenuPrincipal login = new ControllerMenuPrincipal(MP, modelo);
		cuenta1.start();
		;
			
		} else if(button==vista.getBtnCuenta2()){
			modelo.abrirVentana(MP);
			ControllerMenuPrincipal login = new ControllerMenuPrincipal(MP, modelo);
			cuenta2.start();
	}
	}

}
