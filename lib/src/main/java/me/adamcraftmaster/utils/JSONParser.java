package me.adamcraftmaster.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

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
    
     //private static final Logger LOGGER = LoggerFactory.getLogger(JsonFetcher.class);

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
                //LOGGER.info("reading data from URL as GZIP Stream");
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            } else {
                //LOGGER.info("reading data from URL as InputStream");
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            }
            String inputLine;
            sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            //LOGGER.info("Exception while reading JSON from URL - {}", e);
        }
        if (sb != null) {
            return new JSONObject(sb.toString());
        } else {
            //LOGGER.warn("No JSON Found in given URL");
            return new JSONObject("");
        }
    }
}