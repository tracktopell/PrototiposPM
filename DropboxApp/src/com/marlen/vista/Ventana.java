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
protected JButton btnSubirArchivo = new JButton(Utils.SUBIR_ARCHIVOS);
protected JButton btnBajarArchivos = new JButton(Utils.BAJAR_ARCHIVOS);
protected JLabel lblBienvenido = new JLabel(Utils.BIENVENIDO);
protected JButton btnSubir = new JButton(Utils.SUBIR);
public static JTextField txtUsuario = new JTextField();
protected JLabel lblSeleccionarArchivos = new JLabel(Utils.SELECCIONAR_ARCHIVOS);
public JTextField urlArchivo = new JTextField();
protected JButton btnSeleccionar = new JButton(Utils.SELECCIONAR);
public JTextArea textArea = new JTextArea();
protected JScrollPane scroll=new JScrollPane(textArea);

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
}

public void listenerUpload(ActionListener listener){
	btnSubir.addActionListener(listener);
	btnSeleccionar.addActionListener(listener);
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
public JButton getBtnSubir() {
	return btnSubir;
}
public void setBtnSubir(JButton btnSubir) {
	this.btnSubir = btnSubir;
}
public JTextField getUrlArchivo() {
	return urlArchivo;
}
public void setUrlArchivo(JTextField urlArchivo) {
	this.urlArchivo = urlArchivo;
}
public JButton getBtnSeleccionar() {
	return btnSeleccionar;
}
public void setBtnSeleccionar(JButton btnSeleccionar) {
	this.btnSeleccionar = btnSeleccionar;
}
public JTextArea getTextArea() {
	return textArea;
}
public void setTextArea(JTextArea textArea) {
	this.textArea = textArea;
}




}
