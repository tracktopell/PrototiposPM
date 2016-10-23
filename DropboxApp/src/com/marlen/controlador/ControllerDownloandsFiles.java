package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.marlen.modelo.ModeloVentana;
import com.marlen.vista.VentanaDescarga;

public class ControllerDownloandsFiles implements ActionListener{
private VentanaDescarga vista;
private ModeloVentana modelo;
	public ControllerDownloandsFiles(VentanaDescarga vista, ModeloVentana modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		
		
	}

}
