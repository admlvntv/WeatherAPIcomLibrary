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

package me.adamcraftmaster.schema.currentweather;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "last_updated_epoch",
  "last_updated",
  "temp_c",
  "temp_f",
  "is_day",
  "condition",
  "wind_mph",
  "wind_kph",
  "wind_degree",
  "wind_dir",
  "pressure_mb",
  "pressure_in",
  "precip_mm",
  "precip_in",
  "humidity",
  "cloud",
  "feelslike_c",
  "feelslike_f",
  "vis_km",
  "vis_miles",
  "uv",
  "gust_mph",
  "gust_kph"
})
@Generated("jsonschema2pojo")
public class Current {

  @JsonProperty("last_updated_epoch")
  private int lastUpdatedEpoch;

  @JsonProperty("last_updated")
  private String lastUpdated;

  @JsonProperty("temp_c")
  private Double tempC;

  @JsonProperty("temp_f")
  private Double tempF;

  @JsonProperty("is_day")
  private int isDay;

  @JsonProperty("condition")
  private Condition condition;

  @JsonProperty("wind_mph")
  private Double windMph;

  @JsonProperty("wind_kph")
  private Double windKph;

  @JsonProperty("wind_degree")
  private int windDegree;

  @JsonProperty("wind_dir")
  private String windDir;

  @JsonProperty("pressure_mb")
  private Double pressureMb;

  @JsonProperty("pressure_in")
  private Double pressureIn;

  @JsonProperty("precip_mm")
  private Double precipMm;

  @JsonProperty("precip_in")
  private Double precipIn;

  @JsonProperty("humidity")
  private int humidity;

  @JsonProperty("cloud")
  private int cloud;

  @JsonProperty("feelslike_c")
  private Double feelslikeC;

  @JsonProperty("feelslike_f")
  private Double feelslikeF;

  @JsonProperty("vis_km")
  private Double visKm;

  @JsonProperty("vis_miles")
  private Double visMiles;

  @JsonProperty("uv")
  private Double uv;

  @JsonProperty("gust_mph")
  private Double gustMph;

  @JsonProperty("gust_kph")
  private Double gustKph;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return int Local time when the real time data was updated in unix time */
  @JsonProperty("last_updated_epoch")
  public int getLastUpdatedEpoch() {
    return lastUpdatedEpoch;
  }

  /** @param lastUpdatedEpoch Local time when the real time data was updated in unix time */
  @JsonProperty("last_updated_epoch")
  public void setLastUpdatedEpoch(int lastUpdatedEpoch) {
    this.lastUpdatedEpoch = lastUpdatedEpoch;
  }

  /**
   * @param lastUpdatedEpoch Local time when the real time data was updated in unix time
   * @return Current
   */
  public Current withLastUpdatedEpoch(int lastUpdatedEpoch) {
    this.lastUpdatedEpoch = lastUpdatedEpoch;
    return this;
  }

  /** @return String Local time when the real time data was updated */
  @JsonProperty("last_updated")
  public String getLastUpdated() {
    return lastUpdated;
  }

  /** @param lastUpdated Local time when the real time data was updated */
  @JsonProperty("last_updated")
  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  /**
   * @param lastUpdated Local time when the real time data was updated
   * @return Current
   */
  public Current withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /** @return Double Temperature in celsius */
  @JsonProperty("temp_c")
  public Double getTempC() {
    return tempC;
  }

  /** @param tempC Temperature in celsius */
  @JsonProperty("temp_c")
  public void setTempC(Double tempC) {
    this.tempC = tempC;
  }

  /**
   * @param tempC Temperature in celsius
   * @return Current
   */
  public Current withTempC(Double tempC) {
    this.tempC = tempC;
    return this;
  }

  /** @return Double Temperature in fahrenheit */
  @JsonProperty("temp_f")
  public Double getTempF() {
    return tempF;
  }

  /** @param tempF Temperature in fahrenheit */
  @JsonProperty("temp_f")
  public void setTempF(Double tempF) {
    this.tempF = tempF;
  }

  /**
   * @param tempF Temperature in fahrenheit
   * @return Current 1 = Yes 0 = No
   */
  public Current withTempF(Double tempF) {
    this.tempF = tempF;
    return this;
  }

  /**
   * Whether to show day condition icon or night icon
   *
   * @return int 1 = Yes 0 = No
   */
  @JsonProperty("is_day")
  public int getIsDay() {
    return isDay;
  }

  /**
   * Whether to show day condition icon or night icon
   *
   * @param isDay 1 = Yes 0 = No
   */
  @JsonProperty("is_day")
  public void setIsDay(int isDay) {
    this.isDay = isDay;
  }

  /**
   * Whether to show day condition icon or night icon
   *
   * @param isDay 1 = Yes 0 = No
   * @return Current
   */
  public Current withIsDay(int isDay) {
    this.isDay = isDay;
    return this;
  }

  /** @return Condition */
  @JsonProperty("condition")
  public Condition getCondition() {
    return condition;
  }

  /** @param condition */
  @JsonProperty("condition")
  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  /**
   * @param condition
   * @return Current
   */
  public Current withCondition(Condition condition) {
    this.condition = condition;
    return this;
  }

  /** @return Double Wind speed in miles per hour */
  @JsonProperty("wind_mph")
  public Double getWindMph() {
    return windMph;
  }

  /** @param windMph Wind speed in miles per hour */
  @JsonProperty("wind_mph")
  public void setWindMph(Double windMph) {
    this.windMph = windMph;
  }

  /**
   * @param windMph Wind speed in miles per hour
   * @return Current
   */
  public Current withWindMph(Double windMph) {
    this.windMph = windMph;
    return this;
  }

  /** @return Double Wind speed in kilometer per hour */
  @JsonProperty("wind_kph")
  public Double getWindKph() {
    return windKph;
  }

  /** @param windKph Wind speed in kilometer per hour */
  @JsonProperty("wind_kph")
  public void setWindKph(Double windKph) {
    this.windKph = windKph;
  }

  /**
   * @param windKph Wind speed in kilometer per hour
   * @return Current
   */
  public Current withWindKph(Double windKph) {
    this.windKph = windKph;
    return this;
  }

  /** @return int Wind direction in degrees */
  @JsonProperty("wind_degree")
  public int getWindDegree() {
    return windDegree;
  }

  /** @param windDegree Wind direction in degrees */
  @JsonProperty("wind_degree")
  public void setWindDegree(int windDegree) {
    this.windDegree = windDegree;
  }

  /**
   * @param windDegree Wind direction in degrees
   * @return Current
   */
  public Current withWindDegree(int windDegree) {
    this.windDegree = windDegree;
    return this;
  }

  /** @return String Wind direction as 16 point compass. e.g.: NSW */
  @JsonProperty("wind_dir")
  public String getWindDir() {
    return windDir;
  }

  /** @param windDir Wind direction as 16 point compass. e.g.: NSW */
  @JsonProperty("wind_dir")
  public void setWindDir(String windDir) {
    this.windDir = windDir;
  }

  /**
   * @param windDir Wind direction as 16 point compass. e.g.: NSW
   * @return Current
   */
  public Current withWindDir(String windDir) {
    this.windDir = windDir;
    return this;
  }

  /** @return Double Pressure in millibars */
  @JsonProperty("pressure_mb")
  public Double getPressureMb() {
    return pressureMb;
  }

  /** @param pressureMb Pressure in millibars */
  @JsonProperty("pressure_mb")
  public void setPressureMb(Double pressureMb) {
    this.pressureMb = pressureMb;
  }

  /**
   * @param pressureMb Pressure in millibars
   * @return Current
   */
  public Current withPressureMb(Double pressureMb) {
    this.pressureMb = pressureMb;
    return this;
  }

  /** @return Double Pressure in inches */
  @JsonProperty("pressure_in")
  public Double getPressureIn() {
    return pressureIn;
  }

  /** @param pressureIn Pressure in inches */
  @JsonProperty("pressure_in")
  public void setPressureIn(Double pressureIn) {
    this.pressureIn = pressureIn;
  }

  /**
   * @param pressureIn Pressure in inches
   * @return Current
   */
  public Current withPressureIn(Double pressureIn) {
    this.pressureIn = pressureIn;
    return this;
  }

  /** @return Double Precipitation amount in millimeters */
  @JsonProperty("precip_mm")
  public Double getPrecipMm() {
    return precipMm;
  }

  /** @param precipMm Precipitation amount in millimeters */
  @JsonProperty("precip_mm")
  public void setPrecipMm(Double precipMm) {
    this.precipMm = precipMm;
  }

  /**
   * @param precipMm Precipitation amount in millimeters
   * @return Current
   */
  public Current withPrecipMm(Double precipMm) {
    this.precipMm = precipMm;
    return this;
  }

  /** @return Double Precipitation amount in inches */
  @JsonProperty("precip_in")
  public Double getPrecipIn() {
    return precipIn;
  }

  /** @param precipIn Precipitation amount in inches */
  @JsonProperty("precip_in")
  public void setPrecipIn(Double precipIn) {
    this.precipIn = precipIn;
  }

  /**
   * @param precipIn Precipitation amount in inches
   * @return Current
   */
  public Current withPrecipIn(Double precipIn) {
    this.precipIn = precipIn;
    return this;
  }

  /** @return int Humidity as percentage */
  @JsonProperty("humidity")
  public int getHumidity() {
    return humidity;
  }

  /** @param humidity Humidity as percentage */
  @JsonProperty("humidity")
  public void setHumidity(int humidity) {
    this.humidity = humidity;
  }

  /**
   * @param humidity Humidity as percentage
   * @return Current
   */
  public Current withHumidity(int humidity) {
    this.humidity = humidity;
    return this;
  }

  /** @return int Cloud cover as percentage */
  @JsonProperty("cloud")
  public int getCloud() {
    return cloud;
  }

  /** @param cloud Cloud cover as percentage */
  @JsonProperty("cloud")
  public void setCloud(int cloud) {
    this.cloud = cloud;
  }

  /**
   * @param cloud Cloud cover as percentage
   * @return Current
   */
  public Current withCloud(int cloud) {
    this.cloud = cloud;
    return this;
  }

  /** @return Double Feels like temperature in celsius */
  @JsonProperty("feelslike_c")
  public Double getFeelslikeC() {
    return feelslikeC;
  }

  /** @param feelslikeC Feels like temperature in celsius */
  @JsonProperty("feelslike_c")
  public void setFeelslikeC(Double feelslikeC) {
    this.feelslikeC = feelslikeC;
  }

  /**
   * @param feelslikeC Feels like temperature in celsius
   * @return Current
   */
  public Current withFeelslikeC(Double feelslikeC) {
    this.feelslikeC = feelslikeC;
    return this;
  }

  /** @return Double Feels like temperature in fahrenheit */
  @JsonProperty("feelslike_f")
  public Double getFeelslikeF() {
    return feelslikeF;
  }

  /** @param feelslikeF Feels like temperature in fahrenheit */
  @JsonProperty("feelslike_f")
  public void setFeelslikeF(Double feelslikeF) {
    this.feelslikeF = feelslikeF;
  }

  /**
   * @param feelslikeF Feels like temperature in fahrenheit
   * @return Current
   */
  public Current withFeelslikeF(Double feelslikeF) {
    this.feelslikeF = feelslikeF;
    return this;
  }

  /** @return Double */
  @JsonProperty("vis_km")
  public Double getVisKm() {
    return visKm;
  }

  /** @param visKm */
  @JsonProperty("vis_km")
  public void setVisKm(Double visKm) {
    this.visKm = visKm;
  }

  /**
   * @param visKm
   * @return Current
   */
  public Current withVisKm(Double visKm) {
    this.visKm = visKm;
    return this;
  }

  /** @return Double */
  @JsonProperty("vis_miles")
  public Double getVisMiles() {
    return visMiles;
  }

  /** @param visMiles */
  @JsonProperty("vis_miles")
  public void setVisMiles(Double visMiles) {
    this.visMiles = visMiles;
  }

  /**
   * @param visMiles
   * @return Current
   */
  public Current withVisMiles(Double visMiles) {
    this.visMiles = visMiles;
    return this;
  }

  /** @return Double UV Index */
  @JsonProperty("uv")
  public Double getUv() {
    return uv;
  }

  /** @param uv UV Index */
  @JsonProperty("uv")
  public void setUv(Double uv) {
    this.uv = uv;
  }

  /**
   * @param uv UV Index
   * @return Current
   */
  public Current withUv(Double uv) {
    this.uv = uv;
    return this;
  }

  /** @return Double Wind gust in miles per hour */
  @JsonProperty("gust_mph")
  public Double getGustMph() {
    return gustMph;
  }

  /** @param gustMph Wind gust in miles per hour */
  @JsonProperty("gust_mph")
  public void setGustMph(Double gustMph) {
    this.gustMph = gustMph;
  }

  /**
   * @param gustMph Wind gust in miles per hour
   * @return Current
   */
  public Current withGustMph(Double gustMph) {
    this.gustMph = gustMph;
    return this;
  }

  /** @return Double Wind gust in kilometer per hour */
  @JsonProperty("gust_kph")
  public Double getGustKph() {
    return gustKph;
  }

  /** @param gustKph Wind gust in kilometer per hour */
  @JsonProperty("gust_kph")
  public void setGustKph(Double gustKph) {
    this.gustKph = gustKph;
  }

  /**
   * @param gustKph Wind gust in kilometer per hour
   * @return Current
   */
  public Current withGustKph(Double gustKph) {
    this.gustKph = gustKph;
    return this;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  /**
   * @param name
   * @param value
   */
  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  /**
   * @param name
   * @param value
   * @return Current
   */
  public Current withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }
}
