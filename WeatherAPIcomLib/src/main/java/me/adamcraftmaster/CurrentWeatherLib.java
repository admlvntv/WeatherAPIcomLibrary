package me.adamcraftmaster;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.adamcraftmaster.schema.currentweather.*;
import me.adamcraftmaster.utils.JSONParser;

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
        return objectMapper.readValue(JSONParser.urlToJson("https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + region + "&aqi=no"), CurrentWeather.class);
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
}
