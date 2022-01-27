package me.adamcraftmaster.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/**
 * A class that parses URLs
 */
public final class JSONParserUtil {

     /**
      * This is a utlity class, it should not be instantiated.
      */
    private JSONParserUtil() {
        throw new IllegalStateException("Utility class");
    }

    /** 
     * A function that reads a JSON object from a URL as a String.
     * @param urlString a URL that contains a JSON object
     * @return String a JSON as a string from the URL
     */
    public static String urlToJson(String urlString) {
        StringBuilder sb = null;
        URL url;
        URLConnection urlCon;
        try {
            url = new URL(urlString);
            urlCon = url.openConnection();
            BufferedReader in = null;
            // if using gzip, use GZIPInputStream
            if (urlCon.getHeaderField("Content-Encoding") != null
                    && urlCon.getHeaderField("Content-Encoding").equals("gzip")) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            } else {
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            }
            String inputLine;
            sb = new StringBuilder();

            // add every new line to the string until the end of the input 
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            // not needed anymore
            in.close();
        } catch (IOException e) {
            System.out.println("Exception while reading JSON from URL - {}" + e);
        }
        if (sb != null) {
            // JSON was found, return it as a string
            return sb.toString();
        } else {
            // no JSON was found, return an empty string
            System.out.println("No JSON Found in given URL");
            return "";
        }
    }
}
