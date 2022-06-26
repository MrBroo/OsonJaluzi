package byfayzullayev.jaluzi.entity.product;
import byfayzullayev.jaluzi.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity {
    private String name;
    private String imageUrl;
    private Integer price;
    private String category;
    private String color;
    private String sunProtection;
    @Column(columnDefinition="text")
    private String about;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ProductShortEntity productShortEntity;

}
