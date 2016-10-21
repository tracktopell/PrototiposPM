package com.marlen.vista;

public final class MenuPrincipal extends Ventana{

	private static final MenuPrincipal menuPrincipal = new MenuPrincipal("Menu Principal", 480, 600);
	private MenuPrincipal(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public static MenuPrincipal instanciaMP(){
		return menuPrincipal;
	}
	
	

	@Override
	public void cargarControladores() {
		lblBienvenido.setBounds(30, 30, 300, 10);
		txtUsuario.setBounds(100, 30, 200,25);
		contenedor.add(lblBienvenido);
		contenedor.add(txtUsuario);
		
		
	}

}
