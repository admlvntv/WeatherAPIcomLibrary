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

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A class that parses URLs
 *
 * @since 0.1.0
 */
public final class JSONParserUtil {

  private static final OkHttpClient client = new OkHttpClient.Builder()
//      .readTimeout(100, TimeUnit.MILLISECONDS)
//      .writeTimeout(100, TimeUnit.MILLISECONDS)
      .retryOnConnectionFailure(false)
      .build();

  /** This is a utility class, it should not be instantiated. */
  private JSONParserUtil() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * A function that reads a JSON object from a URL as a String.
   *
   * @param urlString a URL that contains a JSON object
   * @return String a JSON as a string from the URL
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public static String urlToJson(String urlString) throws IOException {
    Request request = new Request.Builder()
        .url(urlString)
        .build();
    Call call = client.newCall(request);
    try {
      Response response = call.execute();
      if (response.code() != 200) {
        throw new IOException("Failed request! Response code " + response.code());
      }
      return response.body().string();
    } catch (NullPointerException e) {
      throw new IOException("Response was null.");
    } catch (IOException e) {
      String exceptionMessage = e.getMessage();
      if (exceptionMessage.contains("400")) {
        throw new IOException(exceptionMessage + ": Invalid API request.");
      } else if (exceptionMessage.contains("401")) {
        throw new IOException(exceptionMessage + ": Invalid API key.");
      } else if (exceptionMessage.contains("403")) {
        throw new IOException(exceptionMessage + ": Disabled API key.");
      } else {
        throw new IOException(exceptionMessage);
      }
    }
  }

}
