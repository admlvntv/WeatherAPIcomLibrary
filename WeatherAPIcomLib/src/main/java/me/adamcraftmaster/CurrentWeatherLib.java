package me.adamcraftmaster;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.adamcraftmaster.schema.currentweather.*;
import me.adamcraftmaster.utils.JSONParserUtil;

public class CurrentWeatherLib {
    private final String apiKey;

    /**
     * Creates a new CurrentWeatherLib.
     * @param apiKey a valid API key from weatherapi.com
     */
    public CurrentWeatherLib(String apiKey) {
        this.apiKey = apiKey;
    }

    
    /** 
     * Automatically deserialize the current.json using given API key and region
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @return a deserialized JSON inside the CurrentWeather object
     * @throws JsonProcessingException
     */
    private CurrentWeather currentInfoDataSource(String region) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(JSONParserUtil.urlToJson("https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + region + "&aqi=no"), CurrentWeather.class);
    }
    
    /** 
     * Gets the weather conditions from a given region as text 
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @return weather condition, for example: Clear
     * @throws JsonProcessingException
     */
    public String getCurrentWeatherConditions(String region) throws JsonProcessingException {
        //returns the current condition as text
        return currentInfoDataSource(region).getCurrent().getCondition().getText();
    }

    
    /** 
     * Gets the current temperature from a given region as text
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @param tempScale the scale of temperature, send 'F','f','C', or 'c' defaults to celcius if invalid tempScale given
     * @return temperature in either farenheight or celcius, depending on tempScale
     * @throws JsonProcessingException
     */
    public double getCurrentTemperature(String region, char tempScale) throws JsonProcessingException {
        switch(tempScale) {
            case 'F':
                return currentInfoDataSource(region).getCurrent().getTempF();
            case 'f':
                return currentInfoDataSource(region).getCurrent().getTempF();
            case 'C':
                return currentInfoDataSource(region).getCurrent().getTempC();
            case 'c':
                return currentInfoDataSource(region).getCurrent().getTempC();
            default:
                //defaults to celcius if no valid tempScale given
                return currentInfoDataSource(region).getCurrent().getTempC();
        }
    }

    /** 
     * Gets the current feels like temperature from a given region as text
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @param tempScale the scale of temperature, send 'F','f','C', or 'c' defaults to celcius if invalid tempScale given
     * @return temperature in either farenheight or celcius, depending on tempScale
     * @throws JsonProcessingException
     */
    public double getCurrentFeelsLikeTemp(String region, char tempScale) throws JsonProcessingException {
        switch(tempScale) {
            case 'F':
                return currentInfoDataSource(region).getCurrent().getFeelslikeF();
            case 'f':
                return currentInfoDataSource(region).getCurrent().getFeelslikeF();
            case 'C':
                return currentInfoDataSource(region).getCurrent().getFeelslikeC();
            case 'c':
                return currentInfoDataSource(region).getCurrent().getFeelslikeC();
            default:
                //defaults to celcius if no valid tempScale given
                return currentInfoDataSource(region).getCurrent().getFeelslikeC();
                
        }
    }

    /** 
     * Gets the current UV index.
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @return uv index as a double
     * @throws JsonProcessingException
     */
    public double getUVIndex(String region) throws JsonProcessingException {
        return currentInfoDataSource(region).getCurrent().getUv();
    }

    /** 
     * Gets the current wind speed.
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @param unit the unit of speed, send "mph" or "kph" defaults to kilometers per hour if invalid unit given
     * @return wind speed in either miles per hour or kilometers per hour, depending on unit
     * @throws JsonProcessingException
     */
    public double getWindSpeed(String region, String unit) throws JsonProcessingException {
        switch(unit) {
            case "mph":
                return currentInfoDataSource(region).getCurrent().getWindMph();
            case "kph":
                return currentInfoDataSource(region).getCurrent().getWindKph();
            default:
                //defaults to kilometers per hour if no valid unit given
                return currentInfoDataSource(region).getCurrent().getWindKph();
        }
    }

    
    /** 
     * Checks if it is day at the given region.
     * @param region the region, can be given as US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
     * @return boolean if it is day or not
     * @throws JsonProcessingException
     */
    public boolean checkIsDay(String region) throws JsonProcessingException {
        return currentInfoDataSource(region).getCurrent().getIsDay() == 1;
    }
}
