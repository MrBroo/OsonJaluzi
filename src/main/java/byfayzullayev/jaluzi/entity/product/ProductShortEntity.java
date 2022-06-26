package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductShortEntity extends BaseEntity {
    private String name;
    private String imageUrl;
    private String price;
    private String category;
    private String color;
    private String sunProtection;


    @JsonIgnore
    @ManyToOne
    private CategoryEntity categoryEntity;

    @JsonIgnore
    @OneToOne(mappedBy = "productShortEntity", cascade = CascadeType.ALL)
    private ProductEntity productEntity;

}