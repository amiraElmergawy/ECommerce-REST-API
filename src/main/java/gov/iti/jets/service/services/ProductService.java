package gov.iti.jets.service.services;

import java.util.List;
import java.util.Optional;

import gov.iti.jets.persistence.entities.Category;
import gov.iti.jets.persistence.entities.ProductEntity;

public interface ProductService {

    public Optional<ProductEntity> getProduct(int id);
    public List<ProductEntity> getProducts();
    public boolean updateProduct(String name, double amount, int categoryId, int quantity, int productId);
    public boolean createProduct(String name, double amount, int categoryId, int quantity);
    public List<ProductEntity> search(String key);
    public boolean deleteProduct(int id);
    public List<ProductEntity> getProductsByCategory(int categoryId);
}
