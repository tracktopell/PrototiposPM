package com.marlen.javax;

import java.io.IOException;

import com.dropbox.core.DbxException;
import com.marlen.modelo.Autentificacion;
/**
 * 
 * @author Gerardo Gomez Rosas
 *Class that calls all methods of the class JavaDropBox
 */
public class AppDropBox {
	public static final String APP_KEY = "07a9htv9wrupcoy"; //appKey
	public static final String APP_SECRET = "zo0ob0m86b4ty5x"; //appSecret
	public static final String NAMEAPP = "AplicacionDB"; //name of Application
	public static void main (String [] args) throws IOException, DbxException{
		Autentificacion autentificacion = Autentificacion.instanciaAutentificacion();
		//autentificacion.authDropbox();
		//obj.uploadFiles();
	//	obj.downloadFiles();
	//	obj.listDropboxFolders("/");
	}
}
