package byfayzullayev.jaluzi.model.receive.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryReceiveModel {
    @JsonProperty("name")
    private String name;
    private String contentType;
    private String base64;
}
