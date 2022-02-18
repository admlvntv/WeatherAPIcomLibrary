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

package me.adamcraftmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import me.adamcraftmaster.enums.TempScaleEnum;
import me.adamcraftmaster.utils.JSONParserUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private final String apiKey = System.getenv("API_KEY");

  private final String currentJSON =
      "{\"location\":{\"name\":\"London\",\"region\":\"CityofLondon,GreaterLondon\",\"country\":\"UnitedKingdom\",\"lat\":51.52,\"lon\":-0.11,\"tz_id\":\"Europe/London\",\"localtime_epoch\":1643552127,\"localtime\":\"2022-01-3014:15\"},\"current\":{\"last_updated_epoch\":1643547600,\"last_updated\":\"2022-01-3013:00\",\"temp_c\":8.0,\"temp_f\":46.4,\"is_day\":1,\"condition\":{\"text\":\"Sunny\",\"icon\":\"//cdn.weatherapi.com/weather/64x64/day/113.png\",\"code\":1000},\"wind_mph\":9.4,\"wind_kph\":15.1,\"wind_degree\":210,\"wind_dir\":\"SSW\",\"pressure_mb\":1031.0,\"pressure_in\":30.45,\"precip_mm\":0.0,\"precip_in\":0.0,\"humidity\":61,\"cloud\":0,\"feelslike_c\":6.8,\"feelslike_f\":44.2,\"vis_km\":10.0,\"vis_miles\":6.0,\"uv\":3.0,\"gust_mph\":5.4,\"gust_kph\":8.6}}";

  // The following tests are for testing CurrentWeatherLib
  @Test
  void getCurrentWeatherConditions() {
    CurrentWeatherLib classUnderTest = new CurrentWeatherLib(apiKey, currentJSON);
    try {
      String weatherConditions = classUnderTest.getCurrentWeatherConditions("London");
      assertEquals(
          "Sunny",
          weatherConditions,
          "expected conditions is Sunny, received " + weatherConditions);
    } catch (IOException e) {
      fail("IOException thrown, cause: " + e.getMessage());
    }
  }

  @Test
  void getCurrentTemperature() {
    CurrentWeatherLib classUnderTest = new CurrentWeatherLib(apiKey, currentJSON);
    try {
      double temperature = classUnderTest.getCurrentTemperature("London", TempScaleEnum.CELCIUS);
      assertEquals(
          8.0, temperature, "expected temperature is 8.0 degrees celcius, received " + temperature);
    } catch (IOException e) {
      fail("IOException thrown, cause: " + e.getMessage());
    }
  }

  // The following tests are for JSONParserUtil
  public MockWebServer server = new MockWebServer();
  public OkHttpClient client = new OkHttpClient.Builder()
      .readTimeout(100, TimeUnit.MILLISECONDS)
      .writeTimeout(100, TimeUnit.MILLISECONDS)
      .build();

  @Test
  void testGetJsonFromUrl() throws Exception {
    // configure a MockResponse for the request
    server.enqueue(new MockResponse()
        .setBody("Test")
        .setHeader("Content-Type", "application/json")
        .setResponseCode(200)
    );

    // start MockWebServer
    server.start();

    // create request targeting the MockWebServer
    Request request = new Request.Builder()
        .url(server.url("/"))
        .header("User-Agent", "MockWebServerTest")
        .build();

    // make the request with OkHttp
    Call call = client.newCall(request);
    Response response = call.execute();

    // verify response
    assertEquals(200, response.code());
    assertTrue(response.isSuccessful());
    assertEquals("application/json", response.header("Content-Type"));
    System.out.println(server.url("/"));
    String json = JSONParserUtil.urlToJson(server.url("/").toString());
    assertEquals(currentJSON, json, "expected JSON is " + currentJSON + ", received " + json);

    // verify incoming request on server-side
    System.out.println("making recordedrequest");
    RecordedRequest recordedRequest = recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals("MockWebServerTest", recordedRequest.getHeader("User-Agent"));
    assertEquals(server.url("/"), recordedRequest.getRequestUrl());
    System.out.println("done with recordedrequest");
  }

  @Test
  void delMe() throws IOException {}
}
