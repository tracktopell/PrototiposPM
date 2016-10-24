package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.VentanaDescarga;

public class ControllerDownloandsFiles implements ActionListener{
private VentanaDescarga vista;
private ModeloVentana modelo;
	public ControllerDownloandsFiles(VentanaDescarga vista, ModeloVentana modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.listenerUpload(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ModeloDropBox model = ModeloDropBox.instanciaAutentificacion();
		Object button = e.getSource();
		if (button==vista.getBtnBajar()) {
			VentanaDescarga.textArea.append(model.downloadFiles());
					}
		
	}

}
