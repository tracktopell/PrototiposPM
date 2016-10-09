package com.appdropbox.pmarlen.aplicaciondb;

import java.util.ArrayList;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * @autor Gerardo Gomez Rosas
 *
 */
public class FolderFile extends AsyncTask<Void, Void, ArrayList>{

    private DropboxAPI dropboxApi;
    private String path;
    private Handler handler;

    /**
     *
     * @param dropboxApi
     * @param path
     * @param handler
     */
    public FolderFile(DropboxAPI dropboxApi, String path, Handler handler) {
        super();
        this.dropboxApi = dropboxApi;
        this.path = path;
        this.handler = handler;
    }

    /**
     *
     * @param params
     * @return
     * Method with arraylist, finds all files in our dropbox and keeps within the arraylist
     */
    @Override
    protected ArrayList doInBackground(Void... params) {

        ArrayList files = new ArrayList();

        try {
            Entry directory = dropboxApi.metadata(path, 1000, null, true, null);
            for(Entry entry : directory.contents) {
                files.add(entry.fileName());
            }
        } catch (DropboxException e) {
        }

        return files;
    }

    /**
     *
     * @param result
     * print a message with all the files
     */
    @Override
    protected void onPostExecute(ArrayList result) {
        Message message = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("data", result);
        message.setData(bundle);
        handler.sendMessage(message);
    }
}