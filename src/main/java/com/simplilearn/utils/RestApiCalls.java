package com.simplilearn.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiCalls {

    public static String[] getRequest(String _url) throws Throwable {

        String[] returnItems = new String[2];

        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36.");
        int responseCode = connection.getResponseCode(); //getting the response code
        returnItems[0] = "" + responseCode;

        //reading response
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        returnItems[1] = bufferedReader.readLine();
        return returnItems;
    }

    public static String postRequest(String _url, String _payload) throws IOException {

        URL url = new URL(_url);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36.");

        //put payload
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(_payload.getBytes());
        outputStream.flush();

        int responseCode = connection.getResponseCode(); //getting the response code
        System.out.println(responseCode);

        //reading response
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.readLine();

    }

    public static void main(String[] args) throws Throwable {
        String name = "The Biryani Point";
        if(name.matches("\\s")){
            System.out.println("Contains space");
        }
        String name2 = name.replaceAll("\\s+","%20");
        System.out.println(name2);
    }
}