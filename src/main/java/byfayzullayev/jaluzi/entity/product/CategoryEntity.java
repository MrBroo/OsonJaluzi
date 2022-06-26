package byfayzullayev.jaluzi.entity.product;

import byfayzullayev.jaluzi.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CategoryEntity extends BaseEntity {

    private String name;
    private String ImageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<ProductShortEntity> productShortEntity;
}
