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

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.adamcraftmaster.enums.TempScaleEnum;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private String apiKey = System.getenv("API_KEY");

  private String currentJSON =
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
    } catch (JsonProcessingException e) {
      fail("JsonProcessingException thrown");
    }
  }

  @Test
  void getCurrentTemperature() {
    CurrentWeatherLib classUnderTest = new CurrentWeatherLib(apiKey, currentJSON);
    try {
      double temperature = classUnderTest.getCurrentTemperature("London", TempScaleEnum.CELCIUS);
      assertEquals(
          8.0, temperature, "expected temperature is 8.0 degrees celcius, received " + temperature);
    } catch (JsonProcessingException e) {
      fail("JsonProcessingException thrown");
    }
  }
}
