package gov.iti.jets.service.dtos.product;

import java.util.List;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private int id;
    private String name;
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;


    public Product() {
        super();
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }

}
