package vn.fpt.se0866.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by DatHT on 12/6/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenObject implements Serializable {
    @JsonProperty("value")
    private String value;

    @JsonProperty("tokenType")
    private String type;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
