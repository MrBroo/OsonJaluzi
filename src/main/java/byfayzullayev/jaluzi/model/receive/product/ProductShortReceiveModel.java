package byfayzullayev.jaluzi.model.receive.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductShortReceiveModel {
    private String name;
    private String base64;
    private String price;
    private String category;
    private String color;
    private String sunProtection;
    private String contentType;
    @JsonProperty("category_id")
    private long categoryId;
}
