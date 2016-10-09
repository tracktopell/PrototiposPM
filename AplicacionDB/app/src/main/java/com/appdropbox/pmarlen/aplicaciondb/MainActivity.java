package com.appdropbox.pmarlen.aplicaciondb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.logging.Logger;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.TokenPair;

/**
 * @autor Gerardo Gomez Rosas
 */
public class MainActivity extends ActionBarActivity implements OnClickListener {

    private LinearLayout container;
    private DropboxAPI dropboxApi;
    private boolean isUserLoggedIn;
    private Button loginButton;
    private Button uploadFileBtn;
    private Button listFileBtn;

    private final static String DROPBOX_FILE_DIR = "/DropboxDemo/"; //Write the name of the folder
    private final static String DROPBOX_NAME = "dropbox_prefs";// Write the name de dropboxName
    private final static String ACCESS_KEY = "07a9htv9wrupcoy";//access-key
    private final static String ACCESS_SECRET = "zo0ob0m86b4ty5x";//access-secret
    private final static AccessType ACCESS_TYPE = AccessType.DROPBOX;//type of access

    /**
     * @param savedInstanceState
     *
     *Method for authentication and permit application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(this);
        uploadFileBtn = (Button) findViewById(R.id.uploadFileBtn);
        uploadFileBtn.setOnClickListener(this);
        listFileBtn = (Button) findViewById(R.id.listFilesBtn);
        listFileBtn.setOnClickListener(this);
        container = (LinearLayout) findViewById(R.id.container_files);

        loggedIn(false);

        AppKeyPair appKeyPair = new AppKeyPair(ACCESS_KEY, ACCESS_SECRET);
        AndroidAuthSession session;

        SharedPreferences prefs = getSharedPreferences(DROPBOX_NAME, 0);
        String key = prefs.getString(ACCESS_KEY, null);
        String secret = prefs.getString(ACCESS_SECRET, null);

        if (key != null && secret != null) {
            AccessTokenPair token = new AccessTokenPair(key, secret);
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE, token);
        } else {
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE);
        }

        dropboxApi = new DropboxAPI(session);
    }

    /**
     *
     */
    @Override
    protected void onResume() {
        super.onResume();

        AndroidAuthSession session = (AndroidAuthSession) dropboxApi.getSession();
        if (session.authenticationSuccessful()) {
            try {
                session.finishAuthentication();

                TokenPair tokens = session.getAccessTokenPair();
                SharedPreferences prefs = getSharedPreferences(DROPBOX_NAME, 0);
                Editor editor = prefs.edit();
                editor.putString(ACCESS_KEY, tokens.key);
                editor.putString(ACCESS_SECRET, tokens.secret);
                editor.commit();

                loggedIn(true);
            } catch (IllegalStateException e) {
                Toast.makeText(this, "Error during Dropbox auth", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     *
     */
    private final Handler handler = new Handler() {
        public void handleMessage(Message message) {
            ArrayList<String> result = message.getData().getStringArrayList("data");

            for (String fileName : result) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(fileName);
                container.addView(textView);
            }
        }
    };

    /**
     *
     * @param v
     * method onclick which allows each button action
     *
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                if (isUserLoggedIn) {
                    dropboxApi.getSession().unlink();
                    loggedIn(false);
                } else {
                    ((AndroidAuthSession) dropboxApi.getSession())
                            .startAuthentication(MainActivity.this);
                }
                break;
            case R.id.uploadFileBtn:

                UploadFiles uploadF = new UploadFiles(this, dropboxApi, DROPBOX_FILE_DIR);
                uploadF.execute();
                break;

            case R.id.listFilesBtn:

                FolderFile listFiles = new FolderFile(dropboxApi, DROPBOX_FILE_DIR, handler);
                listFiles.execute();
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param userLoggedIn
     *
     *When the user gives permission to the application returns again to the application, enabling buttons and changing the color
     */
    public void loggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
        uploadFileBtn.setEnabled(userLoggedIn);
        uploadFileBtn.setBackgroundColor(userLoggedIn ? Color.BLUE : Color.GRAY);
        listFileBtn.setEnabled(userLoggedIn);
        listFileBtn.setBackgroundColor(userLoggedIn ? Color.BLUE : Color.GRAY);
        loginButton.setText(userLoggedIn ? "Logout" : "Log in");
    }
}
