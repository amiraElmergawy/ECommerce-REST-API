package gov.iti.jets;

import org.junit.jupiter.api.Test;

import gov.iti.jets.service.dtos.product.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {
    String url = "http://localhost:9090/test-rest/api/products";

    @Test
    public void TestGetAllProducts() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void TestGetSomeProducts() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url.concat("?page="))
                .path("{page1}")
                .resolveTemplate("page1", 4)
                .request()
                .get();
        // System.out.println();
        assertEquals(204, response.getStatus());
    }

    @Test
    public void TestGetProductById() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .path("{id}")
                .resolveTemplate("id", 1)
                .request(MediaType.APPLICATION_XML)
                .get();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void TestInsertProduct() {
        Client client = ClientBuilder.newClient();
        Product product = new Product(10, "product added by testing");
        Response response = client.target(url)
                .request()
                .post(Entity.entity(product, MediaType.APPLICATION_JSON));
        assertEquals(204, response.getStatus());
    }


}
