package gov.iti.jets.service.services;

import java.util.Optional;

import gov.iti.jets.persistence.entities.UserEntity;

public interface UserService {

    public Optional<? extends UserEntity> login(String username,String password);
    public boolean register(String username, String password, String email, String phone);

}
