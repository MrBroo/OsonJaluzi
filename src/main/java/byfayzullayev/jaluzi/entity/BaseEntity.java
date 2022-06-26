package byfayzullayev.jaluzi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;

    @JsonIgnore
    @CreatedBy
    private String username;

    @JsonIgnore
    @LastModifiedBy
    private String changerUser;


    public String createdDate(){
        SimpleDateFormat simpleDateFormat
                = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        if (this.createdDate != null)
            return simpleDateFormat.format(this.createdDate);
        return null;
    }
}
