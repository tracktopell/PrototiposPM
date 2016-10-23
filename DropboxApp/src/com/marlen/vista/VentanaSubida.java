package com.marlen.vista;

import com.marlen.modelo.Utils;

public final class VentanaSubida extends Ventana{
private VentanaSubida(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

private static final VentanaSubida ventanaUpload = new VentanaSubida(Utils.SUBIR_ARCHIVOS, 480, 600);

public static VentanaSubida instanciaVentanaUpload(){
	return ventanaUpload;
}

@Override
public void cargarControladores() {
	lblSeleccionarArchivos.setBounds(120, 30, 300, 10);
	urlArchivo.setToolTipText("Inserta la ruta del fichero");
	urlArchivo.setBounds(52, 26, 209, 20);
	btnSeleccionar.setBounds(288, 25, 109, 23);
	textArea.setLineWrap(true);
	textArea.setWrapStyleWord(true);
	textArea.setBounds(52, 76, 360, 156);
	scroll.setBounds(52, 76, 360, 156);
	btnSubir.setBounds(10, 250, 120, 60);
	contenedor.add(urlArchivo);
	//contenedor.add(lblSeleccionarArchivos);
	contenedor.add(btnSubir);
	contenedor.add(btnSeleccionar);
	contenedor.add(scroll);
	
}
}
