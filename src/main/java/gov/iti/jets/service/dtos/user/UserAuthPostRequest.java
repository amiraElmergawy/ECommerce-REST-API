package gov.iti.jets.service.dtos.user;

import lombok.Data;

@Data
public class UserAuthPostRequest {
    private String username;
    private String password;

}
