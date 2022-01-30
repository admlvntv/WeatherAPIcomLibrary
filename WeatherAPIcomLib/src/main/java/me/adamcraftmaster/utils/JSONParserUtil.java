/*
   Copyright 2022 Adam Nativ

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package me.adamcraftmaster.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import me.adamcraftmaster.exceptions.JSONGetException;

/** A class that parses URLs */
public final class JSONParserUtil {

  /** This is a utlity class, it should not be instantiated. */
  private JSONParserUtil() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * A function that reads a JSON object from a URL as a String.
   *
   * @param urlString a URL that contains a JSON object
   * @return String a JSON as a string from the URL
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   */
  public static String urlToJson(String urlString) throws JSONGetException {
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
        in =
            new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
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
      System.out.println("Exception while reading JSON from URL - " + e.getMessage());
      sendError(e);
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

  
  /** 
   * Sends an exception based on the given IOException
   * @param exception an exception that caused the failiure of getting the JSON from the URL.
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   */
  private static void sendError(IOException exception) throws JSONGetException {
    String[] error = exception.getMessage().split(":");
    for (String t : error) {
      if (t.contains("400")) {
        throw new JSONGetException("Invalid API request.");
      } else if (t.contains("401")) {
        throw new JSONGetException("Invalid API key.");
      } else if (t.contains("403")) {
        throw new JSONGetException("Disabled API key.");
      } else {
        throw new JSONGetException(exception.getMessage());
      }
    }
  }
}
