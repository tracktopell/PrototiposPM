package java;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;



import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class DropBoxAppp {
    private static final String ACCESS_TOKEN = "<ACCESS TOKEN>";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
        DbxClient client = new DbxClient(config, ACCESS_TOKEN);

        

        // Upload "test.txt" to Dropbox
        
        }
    
}