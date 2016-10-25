package com.marlen.vista;

public final class MenuPrincipal extends Ventana{

	private static final MenuPrincipal menuPrincipal = new MenuPrincipal("Menu Principal", 480, 600);
	private MenuPrincipal(String title, int width, int height) {
		super(title, width, height);
		
	}
	
	public static MenuPrincipal instanciaMP(){
		return menuPrincipal;
	}
	
	@Override
	public void cargarControladores() {
		lblBienvenido.setBounds(30, 30, 300, 10);
		txtUsuario.setBounds(100, 30, 200,25);
		btnSubirArchivo.setBounds(160, 100, 120, 60);
		btnBajarArchivos.setBounds(160, 200, 120, 60);
		contenedor.add(lblBienvenido);
		contenedor.add(txtUsuario);
		contenedor.add(btnSubirArchivo);
		contenedor.add(btnBajarArchivos);
		
		
	}

}
