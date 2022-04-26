package gov.iti.jets.service.dtos.user;

import lombok.Data;

@Data
public class UserPostRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
}
