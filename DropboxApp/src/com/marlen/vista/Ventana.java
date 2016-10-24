package com.marlen.vista;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.marlen.modelo.Utils;

public abstract class Ventana extends JFrame{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected JLabel lblToken = new JLabel(Utils.ingresarToken);
protected JTextField txtToken = new JTextField();
protected JButton btnIngresar = new JButton(Utils.ingresar);
protected JButton btnCuenta1 = new JButton(Utils.cuenta_1);
protected JButton btnCuenta2 = new JButton(Utils.CUENTA_2);
protected JButton btnSubirArchivo = new JButton(Utils.SUBIR_ARCHIVOS);
protected JButton btnBajarArchivos = new JButton(Utils.BAJAR_ARCHIVOS);
protected JLabel lblBienvenido = new JLabel(Utils.BIENVENIDO);

public static JTextField txtUsuario = new JTextField();

public static JTextArea textArea = new JTextArea();
protected JScrollPane scroll=new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

protected JLabel lblArchivoExistentes = new JLabel(Utils.ARCHIVOS_EXISTENTES);
protected JButton btnBajar = new JButton(Utils.BAJAR);

Container contenedor = getContentPane();
public Ventana(String title, int width, int height) {
	setTitle(title);
	setSize(width, height);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	super.setDefaultCloseOperation(HIDE_ON_CLOSE);
	super.setResizable(true);
	contenedor.setLayout(null);
	cargarControladores();
	
}
public abstract void cargarControladores();

public void listenerAutenficacion(ActionListener listener){
	btnSubirArchivo.addActionListener(listener);
	btnBajarArchivos.addActionListener(listener);
}

public void listenerMenu(ActionListener listener){
	btnCuenta1.addActionListener(listener);
	btnCuenta2.addActionListener(listener);
}


public void listenerUpload(ActionListener listener){
	btnBajar.addActionListener(listener);
}


public JLabel getLblToken() {
	return lblToken;
}
public void setLblToken(JLabel lblToken) {
	this.lblToken = lblToken;
}
public JTextField getTxtToken() {
	return txtToken;
}
public void setTxtToken(JTextField txtToken) {
	this.txtToken = txtToken;
}
public JButton getBtnIngresar() {
	return btnIngresar;
}
public void setBtnIngresar(JButton btnIngresar) {
	this.btnIngresar = btnIngresar;
}
public JButton getBtnCuenta1() {
	return btnCuenta1;
}
public void setBtnCuenta1(JButton btnCuenta1) {
	this.btnCuenta1 = btnCuenta1;
}

public String setUsuario(){
	return String.valueOf(txtUsuario);
}
public static JTextField getTxtUsuario() {
	return txtUsuario;
}
public static void setTxtUsuario(JTextField txtUsuario) {
	Ventana.txtUsuario = txtUsuario;
}
public JButton getBtnSubirArchivo() {
	return btnSubirArchivo;
}
public void setBtnSubirArchivo(JButton btnSubirArchivo) {
	this.btnSubirArchivo = btnSubirArchivo;
}
public JButton getBtnBajarArchivos() {
	return btnBajarArchivos;
}
public void setBtnBajarArchivos(JButton btnBajarArchivos) {
	this.btnBajarArchivos = btnBajarArchivos;
}

public JTextArea getTextArea() {
	return textArea;
}
public void setTextArea(JTextArea textArea) {
	this.textArea = textArea;
}
public JButton getBtnCuenta2() {
	return btnCuenta2;
}
public void setBtnCuenta2(JButton btnCuenta2) {
	this.btnCuenta2 = btnCuenta2;
}
public JButton getBtnBajar() {
	return btnBajar;
}
public void setBtnBajar(JButton btnBajar) {
	this.btnBajar = btnBajar;
}





}
