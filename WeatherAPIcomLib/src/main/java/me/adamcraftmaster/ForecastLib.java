package me.adamcraftmaster;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import me.adamcraftmaster.enums.TempScaleEnum;
import me.adamcraftmaster.exceptions.JSONGetException;
import me.adamcraftmaster.mapper.currentforecast.CurrentForecast;
import me.adamcraftmaster.utils.JSONParserUtil;

/**
 * A class that handles all the current weather information.
 *
 * <p>this class uses the current.json from weatherapi.com.
 */
public class ForecastLib {

  private final String apiKey;
  private final int daysInFuture;
  private final String localJson;

  /**
   * Creates a new ForecastLib.
   *
   * @param apiKey a valid API key from weatherapi.com
   * @param daysInFuture how many days in the future to check, between 1 and 10 days.
   */
  public ForecastLib(String apiKey, int daysInFuture) throws IOException {
    this.apiKey = apiKey;
    if (daysInFuture > 10 || daysInFuture < 1) {
      throw new IOException("daysInFuture range is invalid");
    }
    this.daysInFuture = daysInFuture;
    this.localJson = "null";
  }

  /**
   * Creates a new ForecastLib with an existing JSON file for information.
   *
   * <p>This constructor is primarily used for testing, as it takes advantage of local given, and
   * potentially outdated data.
   *
   * @param apiKey a valid API key from weatherapi.com
   * @param localJson a json as a String containing the current weather data from a forecast.json
   *     from weatherapi.com
   */
  public ForecastLib(String apiKey, int daysInFuture, String localJson) {
    this.apiKey = apiKey;
    this.daysInFuture = daysInFuture;
    this.localJson = localJson;
  }

  /**
   * Automatically convert to object the forecast.json using given API key and region
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @return a deserialized JSON inside the CurrentWeather object
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   */
  private CurrentForecast forecastInfoDataSource(String region)
      throws JsonProcessingException, JSONGetException {
    ObjectMapper objectMapper = new ObjectMapper();
    if (localJson.equals("null")) {
      return objectMapper.readValue(
          JSONParserUtil.urlToJson(
              "https://api.weatherapi.com/v1/forecast.json?key="
                  + apiKey
                  + "&q="
                  + region
                  + "&days="
                  + daysInFuture
                  + "&aqi=no"
                  + "&alerts=no"),
          CurrentForecast.class);
    } else {
      return objectMapper.readValue(localJson, CurrentForecast.class);
    }
  }

  /**
   * Gets the current predicted average current weather conditions for that day
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param day which day in the future to check, where 0 is today, 1 is tomorrow, and so on.
   * @return the weather condition as a String.
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   */
  public final String getWeatherConditions(String region, int day)
      throws JSONGetException, JsonProcessingException {
    return forecastInfoDataSource(region)
        .getForecast()
        .getForecastday()
        .get(day)
        .getDay()
        .getCondition()
        .getText();
  }

  /**
   * Gets the current predicted average weather conditions for that day, and that hour.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param day which day in the future to check, where 0 is today, 1 is tomorrow, and so on.
   * @param hour which hour in the future to check, from 0 to 23.
   * @return the weather condition as a String.
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   */
  public final String getWeatherConditions(String region, int day, int hour)
      throws JSONGetException, JsonProcessingException {
    return forecastInfoDataSource(region)
        .getForecast()
        .getForecastday()
        .get(day)
        .getHour()
        .get(hour)
        .getCondition()
        .getText();
  }

  /**
   * Gets the current predicted average temperature for that day.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param day which day in the future to check, where 0 is today, 1 is tomorrow, and so on.
   * @param tempScale the scale of temperature, use the TempScaleEnum enum for temperature scale,
   *     defaults to Celsius if invalid tempScale given
   * @return the average temperature of that day as a double in either Fahrenheit or Celsius, based
   *     on the tempScale
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   */
  public final double getAverageTemperature(String region, int day, TempScaleEnum tempScale)
      throws JSONGetException, JsonProcessingException {
    switch (tempScale) {
      case FARENHEIGHT:
        return forecastInfoDataSource(region)
            .getForecast()
            .getForecastday()
            .get(day)
            .getDay()
            .getAvgtempF();
      case CELCIUS:
      default:
        // defaults to Celsius if no valid tempScale given
        return forecastInfoDataSource(region)
            .getForecast()
            .getForecastday()
            .get(day)
            .getDay()
            .getAvgtempC();
    }
  }

  /**
   * Gets the current predicted temperature for that hour, of that day.
   *
   * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP
   *     address, Latitude/Longitude (decimal degree) or city name
   * @param day which day in the future to check, where 0 is today, 1 is tomorrow, and so on.
   * @param hour which hour in the future to check, from 0 to 23.
   * @param tempScale the scale of temperature, use the TempScaleEnum enum for temperature scale,
   *     defaults to Celsius if invalid tempScale given
   * @return the temperature of that hour as a double in either Fahrenheit or Celsius, based on the
   *     tempScale
   * @throws JSONGetException something went wrong with getting the JSON from weatherapi.com
   * @throws JsonProcessingException something went wrong with mapping the JSON from weatherapi.com
   */
  public final double getTemperature(String region, int day, int hour, TempScaleEnum tempScale)
      throws JSONGetException, JsonProcessingException {
    switch (tempScale) {
      case FARENHEIGHT:
        return forecastInfoDataSource(region)
            .getForecast()
            .getForecastday()
            .get(day)
            .getHour()
            .get(hour)
            .getTempF();
      case CELCIUS:
      default:
        return forecastInfoDataSource(region)
            .getForecast()
            .getForecastday()
            .get(day)
            .getHour()
            .get(hour)
            .getTempC();
    }
  }
}
