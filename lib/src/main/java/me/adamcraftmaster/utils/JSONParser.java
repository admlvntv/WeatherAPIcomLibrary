package me.adamcraftmaster.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.json.JSONObject;

/**
 * A class that parses URLs
 */
public class JSONParser {

    
    /** 
     * A function that reads a JSON object from a URL.
     * @author Deepak
     * @param urlString a URL as 
     * @return JSONObject from the URL
     */

    public static JSONObject urlToJson(String urlString) {
        StringBuilder sb = null;
        URL url;
        URLConnection urlCon;
        try {
            url = new URL(urlString);
            urlCon = url.openConnection();
            BufferedReader in = null;
            if (urlCon.getHeaderField("Content-Encoding") != null
                    && urlCon.getHeaderField("Content-Encoding").equals("gzip")) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            } else {
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            }
            String inputLine;
            sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Exception while reading JSON from URL - {}" + e);
        }
        if (sb != null) {
            return new JSONObject(sb.toString());
        } else {
            System.out.println("No JSON Found in given URL");
            return new JSONObject("");
        }
    }
}