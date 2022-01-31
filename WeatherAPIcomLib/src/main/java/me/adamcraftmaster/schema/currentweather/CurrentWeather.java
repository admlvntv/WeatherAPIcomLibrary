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
@JsonPropertyOrder({"location", "current"})
@Generated("jsonschema2pojo")
public class CurrentWeather {

  @JsonProperty("location")
  private Location location;

  @JsonProperty("current")
  private Current current;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return Location */
  @JsonProperty("location")
  public Location getLocation() {
    return location;
  }

  /** @param location */
  @JsonProperty("location")
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @param location
   * @return CurrentWeather
   */
  public CurrentWeather withLocation(Location location) {
    this.location = location;
    return this;
  }

  /** @return Current */
  @JsonProperty("current")
  public Current getCurrent() {
    return current;
  }

  /** @param current */
  @JsonProperty("current")
  public void setCurrent(Current current) {
    this.current = current;
  }

  /**
   * @param current
   * @return CurrentWeather
   */
  public CurrentWeather withCurrent(Current current) {
    this.current = current;
    return this;
  }

  /** @return Map<String, Object> */
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
   * @return CurrentWeather
   */
  public CurrentWeather withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }
}
