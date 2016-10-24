package com.marlen.vista;

import com.marlen.modelo.Utils;

public final class VentanaDescarga extends Ventana {
private static VentanaDescarga ventanaDownload = new VentanaDescarga(Utils.BAJAR_ARCHIVOS, 320, 480);

	public VentanaDescarga(String title, int width, int height) {
		super(title, width, height);
	}
	public static VentanaDescarga instanciaVentanaDownload(){
		return ventanaDownload;
	}

	@Override
	public void cargarControladores() {
		lblArchivoExistentes.setBounds(70, 30, 300, 10);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(52, 76, 250, 200);
		textArea.disable();
		scroll.setBounds(52, 76, 250, 200);
		btnBajar.setBounds(90, 370, 120, 60);
		contenedor.add(lblArchivoExistentes);
		//contenedor.add(textArea);
		contenedor.add(scroll);
		contenedor.add(btnBajar);
		
	}

}
