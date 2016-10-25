package com.marlen.app;

import com.marlen.controlador.ControllerMenu;
import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.Menu;

public class AppDB {

	public static void main(String[] args) {
		Menu vista = Menu.instanciaMenu();
		ModeloVentana modelo = new ModeloVentana();
		@SuppressWarnings("unused")
		ControllerMenu controller = new ControllerMenu(vista, modelo);
		vista.setVisible(true);
	}

}
