package byfayzullayev.jaluzi.model.receive.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.List;

@Data
public class ProductReceiveModel {
    private String name;
    private String base64;
    private Integer price;
    private String sunProtection;
    private String about;
    private String category;
    private String color;
    private String contentType;
    @JsonProperty("productShort_id")
    private long productShortId;



}
