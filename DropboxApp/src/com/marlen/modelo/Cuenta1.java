package com.marlen.modelo;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.marlen.vista.Menu;

public final class Cuenta1 extends Thread{
	private DbxClient dbxClient;
	String APP_KEY = "07a9htv9wrupcoy"; //appKey
	 String APP_SECRET = "zo0ob0m86b4ty5x"; //appSecret
	 String NAMEAPP = "AplicacionDB"; //name of Application
		String TOKEN = "DQahuebkuecAAAAAAAACipYqQxdHymvy0eJHpCUDdLWV6WNwtaW2OQ4SvicPrYYY";
		ModeloDropBox autentificacion = ModeloDropBox.instanciaAutentificacion();
	private static Cuenta1 cuenta = new Cuenta1();
	private Cuenta1() {
		// TODO Auto-generated constructor stub
	}
	public static Cuenta1 instanciaCuenta1(){
		return cuenta;
	}
	
		public void run(){
		
			try {
				dbxClient = autentificacion.authDropbox(APP_KEY, APP_SECRET, NAMEAPP, TOKEN);
				String nombreUsuario	=	dbxClient.getAccountInfo().displayName;
				JOptionPane.showMessageDialog(null, nombreUsuario);
				Menu.txtUsuario.setText(nombreUsuario);
				Menu.txtUsuario.disable();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DbxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
