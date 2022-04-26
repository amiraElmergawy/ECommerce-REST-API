package gov.iti.jets.service.servicesImpl;

import java.util.Optional;

import gov.iti.jets.persistence.daosImpl.UserDaoImpl;
import gov.iti.jets.persistence.entities.CustomerEntity;
import gov.iti.jets.persistence.entities.UserEntity;
import gov.iti.jets.service.services.UserService;

public enum UserServiceImpl implements UserService{

    INSTANCE;

    @Override
    public Optional<? extends UserEntity> login(String username, String password) {
        return UserDaoImpl.INSTANCE.login(username, password);
    }

    @Override
    public boolean register(String username, String password, String email, String phone) {
        CustomerEntity customer = new CustomerEntity();
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setUsername(username);
        customer.setPhone(phone);
        return UserDaoImpl.INSTANCE.createUser(customer);
    }

}
