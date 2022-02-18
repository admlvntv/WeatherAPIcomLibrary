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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import me.adamcraftmaster.schema.currentweather.CurrentWeather;
import me.adamcraftmaster.utils.JSONParserUtil;

/**
 * A class that handles all of the location information.
 *
 * <p>this class uses the current.json from weatherapi.com.
 *
 * @since 0.1.0
 */
public class LocationInfoLib {
  private final String apiKey;
  private final String localJson;

  /**
   * Creates a new LocationInfoLib.
   *
   * @param apiKey a valid API key from weatherapi.com
   */
  public LocationInfoLib(String apiKey) {
    this.apiKey = apiKey;
    this.localJson = "null";
  }

  /**
   * Creates a new LocationInfoLib with an existing JSON file for information.
   *
   * <p>This constructor is primarily used for testing, as it takes advantage of local given, and
   * potentially outdated data.
   *
   * @param apiKey a valid API key from weatherapi.com
   * @param localJson a json as a String containing the current weather data from a current.json
   *     from weatherapi.com
   */
  public LocationInfoLib(String apiKey, String localJson) {
    this.apiKey = apiKey;
    this.localJson = localJson;
  }

  /**
   * Automatically deserialize the current.json using given API key and region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return a deserialized JSON inside the CurrentWeather object
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  private CurrentWeather locationInfoDataSource(String region) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    if (localJson.equals("null")) {
      return objectMapper.readValue(
          JSONParserUtil.urlToJson(
              "https://api.weatherapi.com/v1/current.json?key="
                  + apiKey
                  + "&q="
                  + region
                  + "&aqi=no"),
          CurrentWeather.class);
    } else {
      return objectMapper.readValue(localJson, CurrentWeather.class);
    }
  }

  /**
   * Gets the name of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return The name of the location
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getLocationName(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getName();
  }

  /**
   * Gets the detailed region name of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getRegion(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getRegion();
  }

  /**
   * Gets the country of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getCountry(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getName();
  }

  /**
   * Gets the latitude and longitude of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getCoordinates(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getLat()
        + ", "
        + locationInfoDataSource(region).getLocation().getLon();
  }

  /**
   * Gets the timezone of a location from the current region based on the tz database.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getTzDatabaseId(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getTzId();
  }

  /**
   * Gets the local time of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws IOException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getLocalTime(String region) throws IOException {
    return locationInfoDataSource(region).getLocation().getLocaltime();
  }
}
