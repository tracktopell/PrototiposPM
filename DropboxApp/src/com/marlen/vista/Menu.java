package com.marlen.vista;

import com.marlen.modelo.Utils;

public final class Menu extends Ventana{

private static Menu menu = new Menu("Menu", 320,430);
public  Menu(String title, int width, int height){
	super(title, width, height);
}

public static  Menu instanciaMenu() {
	return menu;
}

	@Override
	public void cargarControladores() {
		btnCuenta1.setBounds(10, 30, 100, 50);
		contenedor.add(btnCuenta1);
		
	}
	
	

}
