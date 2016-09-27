package com.marlen.javax;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Scanner;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
/**
  *
  * @author Gerardo Gomez Rosas
  * A class that contains methods for permit applications to upload and download files from dropbox
  *
  */

public class JavaDropbox {
static DbxClient dbxClient;	
/**
*
* @param DropBoxAppKey in String format
* @param String dropBoxAppSecret in format
* @param NameApp in format String
* @return DbxClient
* @throws IOException IOException return
* @throws DbxException return an exception DbxEception
*
*
* This method will allow us to leave, and it will open a url in the browser,
* Where we send to a page where we request our dropbox credentials to give permission to the application
*/
	public DbxClient authDropbox(String dropBoxAppKey, String dropBoxAppSecret, String nameApp) throws IOException, DbxException

{
   DbxAppInfo appInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
   DbxRequestConfig config = new DbxRequestConfig(nameApp, Locale.getDefault().toString());
   
   DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
   
   try {
	Desktop.getDesktop().browse(new URI(webAuth.start())); //open the browser
} catch (URISyntaxException e) {
	
	e.printStackTrace();
}
   
   System.out
	.println("1. Auth Code: Copy authorization code and input here ");
String dropboxAuthCode = new BufferedReader(new InputStreamReader(
	System.in)).readLine().trim();
DbxAuthFinish authFinish = webAuth.finish(dropboxAuthCode);
String authAccessToken = authFinish.accessToken;
dbxClient = new DbxClient(config, authAccessToken);
System.out.println("Dropbox Account Name: "
	+ dbxClient.getAccountInfo().displayName);

return dbxClient; // return the dbxClient


}
	/**
	  * A method that allows us to upload files
	  *
	  */
	public void uploadFiles(){
		try{

		File file = new File("uploads/Example.txt");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		dbxClient.uploadFile("/Example.txt", DbxWriteMode.add(), file.length(), fileInputStream);
		
System.out.println("Upload File");
		fileInputStream.close();
		
		} catch (Exception ex){
			ex.printStackTrace();
		}
	}
	/**
	* Method that allows us to get all the files
	*/
	public void downloadFiles(){
		try{
		File file = new File("downloads/Example2.txt");
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		dbxClient.getFile("/Example.txt", null, fileOutputStream);
		
		System.out.println("Download File");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	/**
	 * 
	 * @param folderPath in format String  
	 * @throws DbxException
	 * 
	 * This method allows us to list all the folders and / or files
	 */
	public void listDropboxFolders(String folderPath) throws DbxException {
		DbxEntry.WithChildren listing = dbxClient
				.getMetadataWithChildren(folderPath);
		System.out.println("Files List:");
		for (DbxEntry child : listing.children) {
			System.out.println("	" + child.name + ": " + child.toString());
		}
	}
}