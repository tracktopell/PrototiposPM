package com.marlen.modelo;

import com.marlen.vista.Ventana;

public class ModeloVentana {

public void abrirVentana(Ventana vista){
	vista.setVisible(true);
}
public void cerrarVentana(Ventana vista){
	vista.setVisible(false);
}
}
