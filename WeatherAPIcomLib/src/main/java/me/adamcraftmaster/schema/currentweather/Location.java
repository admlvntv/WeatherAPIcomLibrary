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
  "name",
  "region",
  "country",
  "lat",
  "lon",
  "tz_id",
  "localtime_epoch",
  "localtime"
})
@Generated("jsonschema2pojo")
public class Location {

  @JsonProperty("name")
  private String name;

  @JsonProperty("region")
  private String region;

  @JsonProperty("country")
  private String country;

  @JsonProperty("lat")
  private Double lat;

  @JsonProperty("lon")
  private Double lon;

  @JsonProperty("tz_id")
  private String tzId;

  @JsonProperty("localtime_epoch")
  private int localtimeEpoch;

  @JsonProperty("localtime")
  private String localtime;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return String Location name */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /** @param name Location name */
  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param name Location name
   * @return Location
   */
  public Location withName(String name) {
    this.name = name;
    return this;
  }

  /** @return String Region or state of the location, if availa */
  @JsonProperty("region")
  public String getRegion() {
    return region;
  }

  /** @param region Region or state of the location, if availa */
  @JsonProperty("region")
  public void setRegion(String region) {
    this.region = region;
  }

  /**
   * @param region Region or state of the location, if availa
   * @return Location
   */
  public Location withRegion(String region) {
    this.region = region;
    return this;
  }

  /** @return String Location country */
  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  /** @param country Location country */
  @JsonProperty("country")
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * @param country Location country
   * @return Location
   */
  public Location withCountry(String country) {
    this.country = country;
    return this;
  }

  /** @return Double Latitude in decimal degree */
  @JsonProperty("lat")
  public Double getLat() {
    return lat;
  }

  /** @param lat Latitude in decimal degree */
  @JsonProperty("lat")
  public void setLat(Double lat) {
    this.lat = lat;
  }

  /**
   * @param lat Latitude in decimal degree
   * @return Location
   */
  public Location withLat(Double lat) {
    this.lat = lat;
    return this;
  }

  /** @return Double Longitude in decimal degree */
  @JsonProperty("lon")
  public Double getLon() {
    return lon;
  }

  /** @param lon Longitude in decimal degree */
  @JsonProperty("lon")
  public void setLon(Double lon) {
    this.lon = lon;
  }

  /**
   * @param lon Longitude in decimal degree
   * @return Location
   */
  public Location withLon(Double lon) {
    this.lon = lon;
    return this;
  }

  /** @return String Time zone name */
  @JsonProperty("tz_id")
  public String getTzId() {
    return tzId;
  }

  /** @param tzId Time zone name */
  @JsonProperty("tz_id")
  public void setTzId(String tzId) {
    this.tzId = tzId;
  }

  /**
   * @param tzId Time zone name
   * @return Location
   */
  public Location withTzId(String tzId) {
    this.tzId = tzId;
    return this;
  }

  /** @return int Local date and time in unix time */
  @JsonProperty("localtime_epoch")
  public int getLocaltimeEpoch() {
    return localtimeEpoch;
  }

  /** @param localtimeEpoch Local date and time in unix time */
  @JsonProperty("localtime_epoch")
  public void setLocaltimeEpoch(int localtimeEpoch) {
    this.localtimeEpoch = localtimeEpoch;
  }

  /**
   * @param localtimeEpoch Local date and time in unix time
   * @return Location
   */
  public Location withLocaltimeEpoch(int localtimeEpoch) {
    this.localtimeEpoch = localtimeEpoch;
    return this;
  }

  /** @return String Local date and time */
  @JsonProperty("localtime")
  public String getLocaltime() {
    return localtime;
  }

  /** @param localtime Local date and time */
  @JsonProperty("localtime")
  public void setLocaltime(String localtime) {
    this.localtime = localtime;
  }

  /**
   * @param localtime Local date and time
   * @return Location
   */
  public Location withLocaltime(String localtime) {
    this.localtime = localtime;
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
   * @return Location
   */
  public Location withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }
}
