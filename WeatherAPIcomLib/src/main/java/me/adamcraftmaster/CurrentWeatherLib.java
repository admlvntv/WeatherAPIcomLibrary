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
import me.adamcraftmaster.enums.SpeedScaleEnum;
import me.adamcraftmaster.enums.TempScaleEnum;
import me.adamcraftmaster.exceptions.JSONGetException;
import me.adamcraftmaster.schema.currentweather.CurrentWeather;
import me.adamcraftmaster.utils.JSONParserUtil;

/**
 * A class that handles all the current weather information.
 *
 * <p>this class uses the current.json from weatherapi.com.
 *
 * @since 0.1.0
 */
public class CurrentWeatherLib {

  private final String apiKey;
  private final String localJson;

  /**
   * Creates a new CurrentWeatherLib.
   *
   * @param apiKey a valid API key from weatherapi.com
   */
  public CurrentWeatherLib(String apiKey) {
    this.apiKey = apiKey;
    this.localJson = "null";
  }

  /**
   * Creates a new CurrentWeatherLib with an existing JSON file for information.
   *
   * <p>This constructor is primarily used for testing, as it takes advantage of local given, and
   * potentially outdated data.
   *
   * @param apiKey a valid API key from weatherapi.com
   * @param localJson a json as a String containing the current weather data from a current.json
   *     from weatherapi.com
   */
  public CurrentWeatherLib(String apiKey, String localJson) {
    this.apiKey = apiKey;
    this.localJson = localJson;
  }

  /**
   * Automatically deserialize the current.json using given API key and region
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return a deserialized JSON inside the CurrentWeather object
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  private CurrentWeather currentInfoDataSource(String region)
      throws JsonProcessingException, JSONGetException {
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
   * Gets the weather conditions from a given region as text
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return weather condition, for example: Clear
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final String getCurrentWeatherConditions(String region)
      throws JsonProcessingException, JSONGetException {
    // returns the current condition as text
    return currentInfoDataSource(region).getCurrent().getCondition().getText();
  }

  /**
   * Gets the current temperature from a given region as text
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param tempScale the scale of temperature, use the TempScaleEnum enum for temperature scale,
   *     defaults to celcius if invalid tempScale given
   * @return temperature in either farenheight or celcius, depending on tempScale
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final double getCurrentTemperature(String region, TempScaleEnum tempScale)
      throws JsonProcessingException, JSONGetException {
    switch (tempScale) {
      case FARENHEIGHT:
        return currentInfoDataSource(region).getCurrent().getTempF();
      case CELCIUS:
      default:
        // defaults to celcius if no valid tempScale given
        return currentInfoDataSource(region).getCurrent().getTempC();
    }
  }

  /**
   * Gets the current feels like temperature from a given region as text
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param tempScale the scale of temperature, use the TempScaleEnum enum for temperature scale,
   *     defaults to celcius if invalid tempScale given
   * @return temperature in either farenheight or celcius, depending on tempScale
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final double getCurrentFeelsLikeTemp(String region, TempScaleEnum tempScale)
      throws JsonProcessingException, JSONGetException {
    switch (tempScale) {
      case FARENHEIGHT:
        return currentInfoDataSource(region).getCurrent().getFeelslikeF();
      case CELCIUS:
      default:
        // defaults to celcius if no valid tempScale given
        return currentInfoDataSource(region).getCurrent().getFeelslikeC();
    }
  }

  /**
   * Gets the current UV index.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return uv index as a double
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final double getUVIndex(String region) throws JsonProcessingException, JSONGetException {
    return currentInfoDataSource(region).getCurrent().getUv();
  }

  /**
   * Gets the current wind speed.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param unit the unit of speed, use the SpeedScaleEnum for unit, defaults to kilometers per hour
   *     if invalid unit given
   * @return wind speed in either miles per hour or kilometers per hour, depending on unit
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public double getWindSpeed(String region, SpeedScaleEnum unit)
      throws JsonProcessingException, JSONGetException {
    switch (unit) {
      case MILES_PER_HOUR:
        return currentInfoDataSource(region).getCurrent().getWindMph();
      case KILOMETERS_PER_HOUR:
      default:
        // defaults to kilometers per hour if no valid unit given
        return currentInfoDataSource(region).getCurrent().getWindKph();
    }
  }

  /**
   * Checks if it is day at the given region.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return boolean, if it is day or not
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final boolean checkIsDay(String region) throws JsonProcessingException, JSONGetException {
    return currentInfoDataSource(region).getCurrent().getIsDay() == 1;
  }

  /**
   * Gets the current wind direction in degrees.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return the degree the wind is blowing in as an integer
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public int getWindDegree(String region) throws JsonProcessingException, JSONGetException {
    return currentInfoDataSource(region).getCurrent().getWindDegree();
  }

  /**
   * Gets the precipitation amount in inches.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return precipitation amount in inches
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final double getPrecipitation(String region)
      throws JsonProcessingException, JSONGetException {
    return currentInfoDataSource(region).getCurrent().getPrecipIn();
  }

  /**
   * Gets the current humidity as a percentage.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return current humidity as a percentage
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @since 0.1.0
   */
  public final int getHumidity(String region) throws JsonProcessingException, JSONGetException {
    return currentInfoDataSource(region).getCurrent().getHumidity();
  }
}
