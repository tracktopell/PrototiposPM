package com.marlen.modelo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.Format;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
import com.marlen.vista.VentanaDescarga;


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
	
	
	public DbxClient authDropbox(String APP_KEY,String APP_SECRET, String APP_NAME, String TOKEN) throws IOException, DbxException

	{
	   DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
	   DbxRequestConfig config = new DbxRequestConfig(APP_NAME, Locale.getDefault().toString());
	   
	   DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
	   
	   
	dbxClient = new DbxClient(config, TOKEN);
	System.out.println("Dropbox Account Name: "
		+ dbxClient.getAccountInfo().displayName);

	return dbxClient; // return the dbxClient


	}
	
	public String  uploadFiles(){
		String console = "";
		try{
			
			// Aquí la carpeta donde queremos buscar
	        String path = "uploads"; 

	        String files;
	        File archivo;
	        File folder = new File(path);
	        File[] listOfFiles = folder.listFiles(); 

	        for (int i = 0; i < listOfFiles.length; i++)         {

	            if (listOfFiles[i].isFile())             {
	                files = listOfFiles[i].getPath();
	                System.out.println(files);
	                archivo = new File(files);
	        		FileInputStream fileInputStream = new FileInputStream(archivo);
	        		String nameFile = archivo.getName();
	        		dbxClient.uploadFile("/Carpeta/"+nameFile, DbxWriteMode.add(), archivo.length(), fileInputStream);
	        		console = "Upload Files";
	        
	        		fileInputStream.close();
	            }
	        }
		
		} catch (Exception ex){
			console = String.format("Error: %s", ex);
			ex.printStackTrace();
		}
		return console;
	}

	/**
	* Method that allows us to get all the files
	*/
	public String downloadFiles(){
		String message = "";
		try{
			
			DbxEntry.WithChildren listing = dbxClient
					.getMetadataWithChildren("/Carpeta");
			
			for(DbxEntry child: listing.children){
				String nameFile = child.name;
		File file = new File("downloads/"+ nameFile);
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		String file1 = child.path;
		dbxClient.getFile("/" + file1, null, fileOutputStream);
		message = "Download File";
		
		
		}
	} catch (Exception e) {
		message = String.format("Error: %s", e);
		
	}
		return message;
	
}	
	public String listFiles(){
		String message = null;
		try {
			DbxEntry.WithChildren listing = dbxClient.getMetadataWithChildren("/Carpeta");
			for(DbxEntry child: listing.children){
				message=child.name;
				VentanaDescarga.textArea.append(message + "\n");
			}
		} catch (DbxException e) {
			message = String.format("Error: %s", e);
			e.printStackTrace();
		}
		
		return message;
	}
	
}
