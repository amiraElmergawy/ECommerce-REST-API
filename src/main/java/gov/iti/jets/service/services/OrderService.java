package gov.iti.jets.service.services;

import java.util.*;

import gov.iti.jets.persistence.entities.OrderEntity;

public interface OrderService {

    public boolean createOrder(int customerId, double totalPrice, int[] products);
    public boolean approveOrder(int id);
    public boolean updateOrder(int customerId, double totalPrice, int[] products, int orderId);
    public boolean deleteOrder(int id);
    public Optional<OrderEntity> gOrderById(int id);
    public List<OrderEntity> getOrders();
    public List<OrderEntity> getOrdersByCustomer(int customerId);
    public boolean cancelOrder(int id);

}
