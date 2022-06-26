package byfayzullayev.jaluzi.model.receive.user;


import byfayzullayev.jaluzi.entity.role.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignUpReceiveModel {

    @JsonProperty("username")
    @NotEmpty(message = "username bo`sh bo`lishi kerakemas")
    private String username;

    @NotEmpty(message = "password bo`sh bo`lishi kerakemas")
    private String password;

    @JsonProperty("phone_number")
    @NotNull(message = "telefon raqam bo`sh bo`lishi kerakemas")
    private Long phoneNumber;

    @JsonProperty("user_role")
    private RoleEnum roleEnum;

}
