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

public  class VentanaSubida extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnSubir = new JButton(Utils.SUBIR);
	protected JLabel lblSeleccionarArchivos = new JLabel(Utils.SELECCIONAR_ARCHIVOS);
	public JTextField urlArchivo = new JTextField();
	protected JButton btnSeleccionar = new JButton(Utils.SELECCIONAR);
	public static JTextArea txtAUpload = new JTextArea();
	protected JScrollPane scroll1=new JScrollPane(txtAUpload, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	Container contenedor = getContentPane();
	public VentanaSubida(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setDefaultCloseOperation(HIDE_ON_CLOSE);
		super.setResizable(true);
		contenedor.setLayout(null);
		cargarControladores();
		
	}
	@SuppressWarnings("deprecation")
	public void cargarControladores(){
		lblSeleccionarArchivos.setBounds(120, 30, 300, 10);
		
		urlArchivo.setBounds(52, 26, 209, 20);
		btnSeleccionar.setBounds(288, 25, 109, 23);
		txtAUpload.setLineWrap(true);
		txtAUpload.setWrapStyleWord(true);
		txtAUpload.setBounds(52, 76, 250, 200);
		txtAUpload.disable();
		scroll1.setBounds(52, 76, 250, 200);
		btnSubir.setBounds(10, 290, 120, 60);
		//contenedor.add(urlArchivo);
		//contenedor.add(lblSeleccionarArchivos);
		//contenedor.add(txtAUpload);
		contenedor.add(scroll1);
		contenedor.add(btnSubir);
		contenedor.add(btnSeleccionar);
	}
	public void listenerUpload(ActionListener listener){
		btnSubir.addActionListener(listener);
		btnSeleccionar.addActionListener(listener);
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
	public static JTextArea getTxtAUpload() {
		return txtAUpload;
	}
	public static void setTxtAUpload(JTextArea txtAUpload) {
		VentanaSubida.txtAUpload = txtAUpload;
	}
	public JScrollPane getScroll1() {
		return scroll1;
	}
	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}
	
}
