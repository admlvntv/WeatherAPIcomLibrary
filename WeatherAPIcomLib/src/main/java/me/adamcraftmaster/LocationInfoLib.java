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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.adamcraftmaster.schema.currentweather.CurrentWeather;
import me.adamcraftmaster.utils.JSONParserUtil;

public class LocationInfoLib {
  private final String apiKey;
  /**
   * Creates a new LocationInfoLib.
   *
   * @param apiKey a valid API key from weatherapi.com
   */
  public LocationInfoLib(String apiKey) {
    this.apiKey = apiKey;
  }

  /**
   * Automatically deserialize the current.json using given API key and region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return a deserialized JSON inside the CurrentWeather object
   * @throws JsonProcessingException
   */
  private final CurrentWeather locationInfoDataSource(String region)
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(
        JSONParserUtil.urlToJson(
            "https://api.weatherapi.com/v1/current.json?key="
                + apiKey
                + "&q="
                + region
                + "&aqi=no"),
        CurrentWeather.class);
  }

  /**
   * Gets the name of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return The name of the location
   * @throws JsonProcessingException
   */
  public final String getLocationName(String region) throws JsonProcessingException {
    return locationInfoDataSource(region).getLocation().getName();
  }

  /**
   * Gets the detailed region name of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws JsonProcessingException
   */
  public final String getRegion(String region) throws JsonProcessingException {
    return locationInfoDataSource(region).getLocation().getRegion();
  }

  /**
   * Gets the country of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws JsonProcessingException
   */
  public final String getCountry(String region) throws JsonProcessingException {
    return locationInfoDataSource(region).getLocation().getName();
  }

  /**
   * Gets the latitude and longitude of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws JsonProcessingException
   */
  public final String getCoordinates(String region) throws JsonProcessingException {
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
   * @throws JsonProcessingException
   */
  public final String getTzDatabaseId(String region) throws JsonProcessingException {
    return locationInfoDataSource(region).getLocation().getTzId();
  }

  /**
   * Gets the local time of a location from the current region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return String
   * @throws JsonProcessingException
   */
  public final String getLocalTime(String region) throws JsonProcessingException {
    return locationInfoDataSource(region).getLocation().getLocaltime();
  }
}
