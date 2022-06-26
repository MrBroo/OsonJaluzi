package byfayzullayev.jaluzi.entity.portfolio;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PortfolioEntity extends BaseEntity {
    private String name;
    private String imageUrl;

}
