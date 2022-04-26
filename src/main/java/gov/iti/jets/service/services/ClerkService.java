package gov.iti.jets.service.services;

import java.util.*;

import gov.iti.jets.persistence.entities.ClerkEntity;

public interface ClerkService {

    public boolean createClerk(String username, String password, String email, String phone);
    public boolean updateClerk(String username, String password, String email, String phone, int id);
    public boolean deleteClerk(int id);
    public Optional<ClerkEntity> getClerkById(int id);
    public List<ClerkEntity> getClerks();

}
