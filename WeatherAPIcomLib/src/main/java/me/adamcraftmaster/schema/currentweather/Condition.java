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
@JsonPropertyOrder({"text", "icon", "code"})
@Generated("jsonschema2pojo")
public class Condition {

  @JsonProperty("text")
  private String text;

  @JsonProperty("icon")
  private String icon;

  @JsonProperty("code")
  private int code;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return String Weather condition text */
  @JsonProperty("text")
  public String getText() {
    return text;
  }

  /** @param text Weather condition text */
  @JsonProperty("text")
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @param text Weather condition text
   * @return Condition
   */
  public Condition withText(String text) {
    this.text = text;
    return this;
  }

  /** @return String Weather icon url */
  @JsonProperty("icon")
  public String getIcon() {
    return icon;
  }

  /** @param icon Weather icon url */
  @JsonProperty("icon")
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * @param icon Weather icon url
   * @return Condition
   */
  public Condition withIcon(String icon) {
    this.icon = icon;
    return this;
  }

  /** @return int Weather condition unique code */
  @JsonProperty("code")
  public int getCode() {
    return code;
  }

  /** @param code Weather condition unique code */
  @JsonProperty("code")
  public void setCode(int code) {
    this.code = code;
  }

  /**
   * @param code Weather condition unique code
   * @return Condition
   */
  public Condition withCode(int code) {
    this.code = code;
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
   * @return Condition
   */
  public Condition withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }
}
