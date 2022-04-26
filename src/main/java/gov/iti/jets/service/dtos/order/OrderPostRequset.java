package gov.iti.jets.service.dtos.order;

import lombok.Data;

@Data
public class OrderPostRequset {
    private double totalPrice;
    private int customerId;
    private int[] poducts;
}
