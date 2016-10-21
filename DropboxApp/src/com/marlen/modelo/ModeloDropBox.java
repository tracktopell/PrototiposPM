package com.marlen.modelo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

public final class ModeloDropBox {
	private static String url = null;
	private static ModeloDropBox autentificacion = new ModeloDropBox();
private ModeloDropBox() {
	// TODO Auto-generated constructor stub
}	
	
	public static ModeloDropBox instanciaAutentificacion(){
		return autentificacion;
	}
	static DbxClient dbxClient;
	final String APP_KEY = "07a9htv9wrupcoy"; //appKey
	final String APP_SECRET = "zo0ob0m86b4ty5x"; //appSecret
	final String NAMEAPP = "AplicacionDB"; //name of Application
	
	public DbxClient authDropbox() throws IOException, DbxException

	{
	   DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
	   DbxRequestConfig config = new DbxRequestConfig(NAMEAPP, Locale.getDefault().toString());
	   
	   DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
	   
	   try {
		Desktop.getDesktop().browse(new URI(webAuth.start())); //open the browser
	} catch (URISyntaxException e) {
		
		e.printStackTrace();
	}
	 
	   
	String urls =JOptionPane.showInputDialog("Ingrese el codigo");
	DbxAuthFinish authFinish = webAuth.finish(urls);
	String authAccessToken = authFinish.accessToken;
	dbxClient = new DbxClient(config, authAccessToken);
	System.out.println("Dropbox Account Name: "
		+ dbxClient.getAccountInfo().displayName);

	return dbxClient; // return the dbxClient


	}
	
	public void uploadFiles(){
		
		try{
			
			 

		File file = new File("imagens/Koala.jpg");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		dbxClient.uploadFile("/Carpeta/Example.jpg", DbxWriteMode.add(), file.length(), fileInputStream);
		
System.out.println("Upload File");
		fileInputStream.close();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}

	
}
