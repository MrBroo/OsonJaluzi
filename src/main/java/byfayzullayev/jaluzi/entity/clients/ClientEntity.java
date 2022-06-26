package byfayzullayev.jaluzi.entity.clients;

import byfayzullayev.jaluzi.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClientEntity extends BaseEntity {

    private String name;
    private String phoneNumber;
    private String variant;

}
