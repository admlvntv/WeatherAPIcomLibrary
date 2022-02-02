
package me.adamcraftmaster.schema.currentforecast;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxtemp_c",
    "maxtemp_f",
    "mintemp_c",
    "mintemp_f",
    "avgtemp_c",
    "avgtemp_f",
    "maxwind_mph",
    "maxwind_kph",
    "totalprecip_mm",
    "totalprecip_in",
    "avgvis_km",
    "avgvis_miles",
    "avghumidity",
    "daily_will_it_rain",
    "daily_chance_of_rain",
    "daily_will_it_snow",
    "daily_chance_of_snow",
    "condition",
    "uv"
})
@Generated("jsonschema2pojo")
public class Day {

    @JsonProperty("maxtemp_c")
    private Double maxtempC;
    @JsonProperty("maxtemp_f")
    private Double maxtempF;
    @JsonProperty("mintemp_c")
    private Double mintempC;
    @JsonProperty("mintemp_f")
    private Double mintempF;
    @JsonProperty("avgtemp_c")
    private Double avgtempC;
    @JsonProperty("avgtemp_f")
    private Double avgtempF;
    @JsonProperty("maxwind_mph")
    private Double maxwindMph;
    @JsonProperty("maxwind_kph")
    private Double maxwindKph;
    @JsonProperty("totalprecip_mm")
    private Double totalprecipMm;
    @JsonProperty("totalprecip_in")
    private Double totalprecipIn;
    @JsonProperty("avgvis_km")
    private Double avgvisKm;
    @JsonProperty("avgvis_miles")
    private Double avgvisMiles;
    @JsonProperty("avghumidity")
    private Double avghumidity;
    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain;
    @JsonProperty("daily_chance_of_rain")
    private Integer dailyChanceOfRain;
    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow;
    @JsonProperty("daily_chance_of_snow")
    private Integer dailyChanceOfSnow;
    @JsonProperty("condition")
    private Condition__1 condition;
    @JsonProperty("uv")
    private Double uv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("maxtemp_c")
    public Double getMaxtempC() {
        return maxtempC;
    }

    @JsonProperty("maxtemp_c")
    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public Day withMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
        return this;
    }

    @JsonProperty("maxtemp_f")
    public Double getMaxtempF() {
        return maxtempF;
    }

    @JsonProperty("maxtemp_f")
    public void setMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
    }

    public Day withMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
        return this;
    }

    @JsonProperty("mintemp_c")
    public Double getMintempC() {
        return mintempC;
    }

    @JsonProperty("mintemp_c")
    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }

    public Day withMintempC(Double mintempC) {
        this.mintempC = mintempC;
        return this;
    }

    @JsonProperty("mintemp_f")
    public Double getMintempF() {
        return mintempF;
    }

    @JsonProperty("mintemp_f")
    public void setMintempF(Double mintempF) {
        this.mintempF = mintempF;
    }

    public Day withMintempF(Double mintempF) {
        this.mintempF = mintempF;
        return this;
    }

    @JsonProperty("avgtemp_c")
    public Double getAvgtempC() {
        return avgtempC;
    }

    @JsonProperty("avgtemp_c")
    public void setAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
    }

    public Day withAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
        return this;
    }

    @JsonProperty("avgtemp_f")
    public Double getAvgtempF() {
        return avgtempF;
    }

    @JsonProperty("avgtemp_f")
    public void setAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
    }

    public Day withAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
        return this;
    }

    @JsonProperty("maxwind_mph")
    public Double getMaxwindMph() {
        return maxwindMph;
    }

    @JsonProperty("maxwind_mph")
    public void setMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    public Day withMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
        return this;
    }

    @JsonProperty("maxwind_kph")
    public Double getMaxwindKph() {
        return maxwindKph;
    }

    @JsonProperty("maxwind_kph")
    public void setMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    public Day withMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
        return this;
    }

    @JsonProperty("totalprecip_mm")
    public Double getTotalprecipMm() {
        return totalprecipMm;
    }

    @JsonProperty("totalprecip_mm")
    public void setTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    public Day withTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
        return this;
    }

    @JsonProperty("totalprecip_in")
    public Double getTotalprecipIn() {
        return totalprecipIn;
    }

    @JsonProperty("totalprecip_in")
    public void setTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    public Day withTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
        return this;
    }

    @JsonProperty("avgvis_km")
    public Double getAvgvisKm() {
        return avgvisKm;
    }

    @JsonProperty("avgvis_km")
    public void setAvgvisKm(Double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    public Day withAvgvisKm(Double avgvisKm) {
        this.avgvisKm = avgvisKm;
        return this;
    }

    @JsonProperty("avgvis_miles")
    public Double getAvgvisMiles() {
        return avgvisMiles;
    }

    @JsonProperty("avgvis_miles")
    public void setAvgvisMiles(Double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    public Day withAvgvisMiles(Double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
        return this;
    }

    @JsonProperty("avghumidity")
    public Double getAvghumidity() {
        return avghumidity;
    }

    @JsonProperty("avghumidity")
    public void setAvghumidity(Double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Day withAvghumidity(Double avghumidity) {
        this.avghumidity = avghumidity;
        return this;
    }

    @JsonProperty("daily_will_it_rain")
    public Integer getDailyWillItRain() {
        return dailyWillItRain;
    }

    @JsonProperty("daily_will_it_rain")
    public void setDailyWillItRain(Integer dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    public Day withDailyWillItRain(Integer dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
        return this;
    }

    @JsonProperty("daily_chance_of_rain")
    public Integer getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public void setDailyChanceOfRain(Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public Day withDailyChanceOfRain(Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
        return this;
    }

    @JsonProperty("daily_will_it_snow")
    public Integer getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    @JsonProperty("daily_will_it_snow")
    public void setDailyWillItSnow(Integer dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public Day withDailyWillItSnow(Integer dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
        return this;
    }

    @JsonProperty("daily_chance_of_snow")
    public Integer getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public void setDailyChanceOfSnow(Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public Day withDailyChanceOfSnow(Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
        return this;
    }

    @JsonProperty("condition")
    public Condition__1 getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(Condition__1 condition) {
        this.condition = condition;
    }

    public Day withCondition(Condition__1 condition) {
        this.condition = condition;
        return this;
    }

    @JsonProperty("uv")
    public Double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Day withUv(Double uv) {
        this.uv = uv;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Day withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
