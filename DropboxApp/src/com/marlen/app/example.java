package com.marlen.app;


	import com.dropbox.core.*;

	import java.awt.Desktop;
	import java.io.*;
	import java.util.Locale;

	public class example {
	public static void main(String[] args) throws IOException, DbxException {
	    // Get your app key and secret from the Dropbox developers website.
	    final String APP_KEY = "07a9htv9wrupcoy";
	    final String APP_SECRET = "zo0ob0m86b4ty5x";

	    DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

	    DbxRequestConfig config = new DbxRequestConfig("AplicacionDB",
	        Locale.getDefault().toString());
	    DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

	    // Have the user sign in and authorize your app.
	    String authorizeUrl = webAuth.start();
	    System.out.println("1. Go to: " + authorizeUrl);
	    System.out.println("2. Click \"Allow\" (you might have to log in first)");
	    System.out.println("3. Copy the authorization code.");
	    Desktop.getDesktop().browse(java.net.URI.create(authorizeUrl));
	    String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

	    // This will fail if the user enters an invalid authorization code.
	    DbxAuthFinish authFinish = webAuth.finish(code);

	    DbxClient client = new DbxClient(config, authFinish.accessToken);

	    System.out.println("Linked account: " + client.getAccountInfo().displayName);

	    File inputFile = new File("OpenCv_Video_display_link.txt");
	    FileInputStream inputStream = new FileInputStream(inputFile);
	    try {
	        DbxEntry.File uploadedFile = client.uploadFile("/OpenCv_Video_display_link.txt",
	            DbxWriteMode.add(), inputFile.length(), inputStream);
	        System.out.println("Uploaded: " + uploadedFile.toString());
	    } finally {
	        inputStream.close();
	    }

	    DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
	    System.out.println("Files in the root path:");
	    for (DbxEntry child : listing.children) {
	        System.out.println("    " + child.name + ": " + child.toString());
	    }

	    FileOutputStream outputStream = new FileOutputStream("121verbs.pdf");
	    try {
	        DbxEntry.File downloadedFile = client.getFile("/121verbs.pdf", null,
	            outputStream);
	        System.out.println("Metadata: " + downloadedFile.toString());
	    } finally {
	        outputStream.close();
	    }
	}
	}


