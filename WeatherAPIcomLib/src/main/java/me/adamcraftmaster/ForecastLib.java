package me.adamcraftmaster;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.adamcraftmaster.exceptions.JSONGetException;
import me.adamcraftmaster.schema.currentforecast.CurrentForecast;
import me.adamcraftmaster.utils.JSONParserUtil;

/**
 * A class that handles all the current weather information.
 *
 * <p>this class uses the current.json from weatherapi.com.
 */
public class ForecastLib {
  private final String apiKey;
  private final String localJson;

  /**
   * Creates a new ForecastLib.
   *
   * @param apiKey a valid API key from weatherapi.com
   */
  public ForecastLib(String apiKey) {
    this.apiKey = apiKey;
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
  public ForecastLib(String apiKey, String localJson) {
    this.apiKey = apiKey;
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
   * @since 0.1.0
   */
  private CurrentForecast forecastInfoDataSource(String region, int days)
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
                  + days
                  + "&aqi=no"
                  + "&alerts=no"),
          CurrentForecast.class);
    } else {
      return objectMapper.readValue(localJson, CurrentForecast.class);
    }
  }
}
