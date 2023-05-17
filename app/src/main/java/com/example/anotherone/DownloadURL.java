package com.example.anotherone;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadURL {
    public String retrieveURL(String url) throws IOException {
        String urlData = "";
        HttpsURLConnection httpsURLConnection = null;
        InputStream inputStream = null;

        try {
            URL getUrl = new URL(url);
            httpsURLConnection = (HttpsURLConnection) getUrl.openConnection();
            httpsURLConnection.connect();

            inputStream = httpsURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }
            urlData = sb.toString();
            bufferedReader.close();
        }catch (Exception e){
            Log.d("Exception", e.toString());
        } finally {
            assert inputStream != null;
            inputStream.close();
            httpsURLConnection.disconnect();
        }
        return urlData;
    }
}
