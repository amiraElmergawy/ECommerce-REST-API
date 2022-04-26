package gov.iti.jets.service.dtos.product;

import lombok.Data;
import jakarta.xml.bind.annotation.*;


@Data

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductPostRequest {

    private String name;
    private int quantity;
    private double amount;
    private int category;
}
