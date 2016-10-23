package com.marlen.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.marlen.modelo.ModeloDropBox;
import com.marlen.modelo.ModeloVentana;
import com.marlen.modelo.Utils;
import com.marlen.vista.MenuPrincipal;
import com.marlen.vista.Menu;
import com.marlen.vista.Ventana;

public class ControllerMenu implements ActionListener{
private Menu vista;
private ModeloVentana modelo;
private DbxClient dbxClient;



	public ControllerMenu(Menu vista, ModeloVentana modelo) {
	this.vista = vista;
	this.modelo = modelo;
	vista.listenerMenu(this);
}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		String url = "";
		
		MenuPrincipal MP = MenuPrincipal.instanciaMP();
		ModeloDropBox autentificacion = ModeloDropBox.instanciaAutentificacion();
		if(button==vista.getBtnCuenta1()){
			modelo.abrirVentana(MP);
			ControllerMenuPrincipal login = new ControllerMenuPrincipal(MP, modelo);
		
			try {
				 String APP_KEY = "07a9htv9wrupcoy"; //appKey
				 String APP_SECRET = "zo0ob0m86b4ty5x"; //appSecret
				 String NAMEAPP = "AplicacionDB"; //name of Application
				 String TOKEN = "DQahuebkuecAAAAAAAACipYqQxdHymvy0eJHpCUDdLWV6WNwtaW2OQ4SvicPrYYY";
				dbxClient = autentificacion.authDropbox(APP_KEY, APP_SECRET, NAMEAPP, TOKEN);
		String nombreUsuario	=	dbxClient.getAccountInfo().displayName;
		JOptionPane.showMessageDialog(null, nombreUsuario);
		vista.txtUsuario.setText(nombreUsuario);
		vista.txtUsuario.disable();
				
				
			} catch (IOException | DbxException e1) {
				e1.printStackTrace();
			}
		} else if(button==vista.getBtnCuenta2()){
			modelo.abrirVentana(MP);
			ControllerMenuPrincipal login = new ControllerMenuPrincipal(MP, modelo);
			try{
			 String APP_KEY = "nf7owatv5x1q1kt"; //appKey
			 String APP_SECRET = "mn8kdhecnnw6uir"; //appSecret
			 String NAMEAPP = "AplicacionDB1"; //name of Application
			 String TOKEN = "oyOfVGSfR2AAAAAAAAAAl1ZyybzoDQJFRfM0k9SVPCHcXFHfcCiOxf94QbUAUgsO";
			dbxClient = autentificacion.authDropbox(APP_KEY, APP_SECRET, NAMEAPP, TOKEN);
	String nombreUsuario	=	dbxClient.getAccountInfo().displayName;
	JOptionPane.showMessageDialog(null, nombreUsuario);
	vista.txtUsuario.setText(nombreUsuario);
	vista.txtUsuario.disable();
			} catch (IOException | DbxException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
