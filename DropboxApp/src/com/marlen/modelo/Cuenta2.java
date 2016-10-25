package com.marlen.modelo;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.marlen.vista.Menu;

public final class Cuenta2{
private	String APP_KEY = ""; //appKey
private	 String APP_SECRET = ""; //appSecret
private	 String NAMEAPP = ""; //name of Application
private		String TOKEN = "";
	private DbxClient dbxClient;
	private ModeloDropBox autentificacion = ModeloDropBox.instanciaAutentificacion();
	private static Cuenta2 cuenta2 = new Cuenta2();
	private Cuenta2(){
		
	}
	public static Cuenta2 instanciaCuenta2(){
		return cuenta2;
	}
	
	
	
	
	public void autentificacionCuenta2(){
		JSONParser parser = new JSONParser();
		 
        try {
 
        	 Object obj = parser.parse(new FileReader(
                     "Cuenta/CuentasDropbox.txt"));
 
            JSONObject jsonObject = (JSONObject) obj;
       
            JSONArray tags = (JSONArray) jsonObject.get("Cuenta_2");
        Object A_KEY =    tags.get(0);
        Object A_SECRET = tags.get(1);
        Object A_NAME = tags.get(2);
        Object A_TOKEN = tags.get(3);
           
            APP_KEY = A_KEY.toString();
            APP_SECRET = A_SECRET.toString();
            NAMEAPP = A_NAME.toString();
             TOKEN = A_TOKEN.toString();
             
            dbxClient = autentificacion.authDropbox(APP_KEY, APP_SECRET, NAMEAPP, TOKEN);
			String nombreUsuario	=	dbxClient.getAccountInfo().displayName;
			Menu.txtUsuario.setText(nombreUsuario);
			Menu.txtUsuario.disable();
           
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}	
}
