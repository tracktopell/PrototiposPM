package com.marlen.modelo;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.marlen.vista.Menu;

public final class Cuenta2  extends Thread{
	private DbxClient dbxClient;
	String APP_KEY = "nf7owatv5x1q1kt"; //appKey
	 String APP_SECRET = "mn8kdhecnnw6uir"; //appSecret
	 String NAMEAPP = "AplicacionDB1"; //name of Application
	 String TOKEN = "oyOfVGSfR2AAAAAAAAAAl1ZyybzoDQJFRfM0k9SVPCHcXFHfcCiOxf94QbUAUgsO";
	private ModeloDropBox autentificacion = ModeloDropBox.instanciaAutentificacion();
	private static Cuenta2 cuenta2 = new Cuenta2();
	private Cuenta2(){
		
	}
	public static Cuenta2 instanciaCuenta2(){
		return cuenta2;
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
