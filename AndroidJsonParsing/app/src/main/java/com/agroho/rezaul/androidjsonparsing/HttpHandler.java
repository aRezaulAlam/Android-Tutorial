package com.agroho.rezaul.androidjsonparsing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ASUS on 7/10/2015.
 */
public class HttpHandler {

    private String rawUrlData;
    public String getServiceData(String urlLink){

        StringBuffer BufferData = new StringBuffer("");

        try {
            URL url = new URL(urlLink);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null){
                BufferData.append(line);
            }

            rawUrlData = BufferData.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return  rawUrlData;
    }
}
