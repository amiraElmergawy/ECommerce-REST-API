package gov.iti.jets.service.servicesImpl;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.persistence.daosImpl.ClerkDaoImpl;
import gov.iti.jets.persistence.entities.ClerkEntity;
import gov.iti.jets.service.services.ClerkService;

public enum ClerkServiceImpl implements ClerkService{
    INSTANCE;
    // private final ClerkDao clerkDao = new ClerkDaoImpl();

    @Override
    public boolean createClerk(String username, String password, String email, String phone) {
        ClerkEntity clerk = new ClerkEntity();
        clerk.setEmail(email);
        clerk.setPassword(password);
        clerk.setUsername(username);
        clerk.setPhone(phone);
        return ClerkDaoImpl.INSTANCE.createClerk(clerk);
    }

    @Override
    public boolean updateClerk(String username, String password, String email, String phone, int id) {
        ClerkEntity clerk = new ClerkEntity();
        clerk.setEmail(email);
        clerk.setPassword(password);
        clerk.setUsername(username);
        clerk.setPhone(phone);
        clerk.setId(id);
        return ClerkDaoImpl.INSTANCE.updateClerk(clerk);
    }

    @Override
    public boolean deleteClerk(int id) {
        return ClerkDaoImpl.INSTANCE.deleteClerk(id);
    }

    @Override
    public Optional<ClerkEntity> getClerkById(int id) {
        return ClerkDaoImpl.INSTANCE.getClerkById(id);
    }

    @Override
    public List<ClerkEntity> getClerks() {
        return ClerkDaoImpl.INSTANCE.getClerks();
    }

}
