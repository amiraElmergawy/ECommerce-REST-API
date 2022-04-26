package gov.iti.jets.presentation.controllers;

import java.util.Arrays;

import gov.iti.jets.persistence.entities.ProductEntity;
// import gov.iti.jets.persistence.daosImpl.ProductDaoImpl;
import gov.iti.jets.persistence.exceptions.ProductNotFoundException;
import gov.iti.jets.service.dtos.product.Product;
import gov.iti.jets.service.dtos.product.ProductPostRequest;
import gov.iti.jets.service.servicesImpl.ProductServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("products")
public class ProductController {
    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<Product> getAllProducts() {
    // return ProductDao.INSTANCE.getProducts();
    // }

    /// api/orders ? start=10 & page=20
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSomeProducts(@DefaultValue("0") @QueryParam("start") int from, @QueryParam("page") int page) {
        return Response.ok(ProductServiceImpl.INSTANCE.getProducts().subList(from, page)).build();
    }

    @GET
    @Path("{pid}")
    @Produces({ "application/xml; qs=0.75", "application/json; qs=1" })
    public Response getProduct(@PathParam("pid") int id, @Context UriInfo uriInfo) {

        ProductEntity product = ProductServiceImpl.INSTANCE.getProduct(id).get();
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        product.setLinks(Arrays.asList(self));
        Link anotherLink = Link.fromPath(uriInfo.getBaseUri() + "hateoas/api/products").rel("showAllProducts").build();
        product.setLinks(Arrays.asList(self, anotherLink));
        return Response.ok(product).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(ProductPostRequest product) {
        System.out.println(product);
        ProductServiceImpl.INSTANCE.createProduct(product.getName(), product.getAmount(), product.getCategory(), product.getQuantity());
    }

    @PUT
    @Path("{pid}")
    @Consumes({ "application/xml;", "application/json;" })
    public void updateProduct(@PathParam("pid") int id, ProductPostRequest product) {
        if (ProductServiceImpl.INSTANCE.updateProduct(product.getName(), product.getAmount(), product.getCategory(), product.getQuantity(), id))
            throw new ProductNotFoundException("");
    }

    @DELETE
    @Path("{pid}")
    public void deleteProduct(@PathParam("pid") int id) {
        if (ProductServiceImpl.INSTANCE.deleteProduct(id) == false)
            throw new ProductNotFoundException("");
    }

    // @DELETE
    // public void deleteAllProducts() { // not recommended
    // }

    @GET
    @Path("/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByCategory(@PathParam("category") int category) {
        return Response.ok(ProductServiceImpl.INSTANCE.getProductsByCategory(category)).build();
    }
}
