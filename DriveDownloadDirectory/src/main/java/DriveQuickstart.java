import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.http.FileContent;

import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
//import com.google.api.services.drive.model.ParentReference;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.Drive;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.OutputStream;
import java.util.List;
import java.util.LinkedHashMap;

import java.util.ArrayList;


import java.util.Scanner;

public class DriveQuickstart {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Drive API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/drive-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/drive-java-quickstart
     */
    Drive service;
    private static final List<String> SCOPES =
        Arrays.asList(DriveScopes.DRIVE_METADATA_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            DriveQuickstart.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Drive client service.
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
        DriveQuickstart obj = new DriveQuickstart();
        // Build a new authorized API client service.
        Drive service = getDriveService();
        
        // Print the names and IDs for up to 50 files.
        FileList result = service.files().list()
             .setPageSize(50)
             .setFields("nextPageToken, files(id, name, kind, parents,md5Checksum, parents)")
             .execute();
        List<File> files = result.getFiles();
		LinkedHashMap<String,File> allFiles = new LinkedHashMap<>();
        if (files == null || files.size() == 0) {
            System.out.println("No files found.");
        } else {
            System.out.println("-----------Files----------");
            for (File file : files) {
		        List parents = file.getParents();
				boolean seemsLikeFolder = file.getMd5Checksum() == null;

                System.out.println("->{"+file.getParents() +"} "+
								(seemsLikeFolder?"d":"-")+
							//	" "+(isRoot?"/":"_")+
								" ["+file.getId()+"] "+
								file.getName() +
								"\t<"+file.getMd5Checksum()+">");
				allFiles.put(file.getId(), file );
            }
        }
        
		System.out.println("-----------After sort and Build Paths----------");

		for(File f : allFiles.values()) {
			System.out.println("=>"+buildPathFor(allFiles, f.getId()) );
		}
		System.out.println("-----------------------------------------------");

 
    }



	private static String buildPathFor(LinkedHashMap<String,File> allFiles, String fileId) {
		String path = "";
		File   f = null;
		File   p = null;
		f =  allFiles.get(fileId);
		p =  allFiles.get(f.getParents().get(0));
		if(p != null) {
			return buildPathFor(allFiles, p.getId()) + "/" + f.getName() ;
		} else {
			return "/" + f.getName();
		}
	}


 
    /*
    private static InputStream downloadFile(Drive service, File file) {
    if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
      try {
        HttpResponse resp =
            service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl()))
                .execute();
        return resp.getContent();
      } catch (IOException e) {
        // An error occurred.
        e.printStackTrace();
        return null;
      }
    } else {
      // The file doesn't have any content stored on Drive.
      return null;
    }
  }
  */

}
