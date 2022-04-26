package gov.iti.jets.presentation.controllers;

import gov.iti.jets.service.dtos.order.OrderPostRequset;
import gov.iti.jets.service.servicesImpl.OrderServiceImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("orders")
public class OrderController {

    @GET
    public Response getAllOrders() {
        return Response.ok(OrderServiceImpl.INSTANCE.getOrders()).build();
    }

    @GET
    @Path("{oid}")
    public Response getOrder(@PathParam("oid") int id) {
        return Response.ok(OrderServiceImpl.INSTANCE.gOrderById(id).get()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerOrders(@QueryParam("customerId") int customerId) {
        return Response.ok(OrderServiceImpl.INSTANCE.getOrdersByCustomer(customerId)).build();
    }

    // @GET
    // @Path("{oid}/prpducts") //the order already contains its products so get by id will do same job
    // public List<Product> getOrderProducts(@PathParam("oid") int id) {
    //     return new OrderPostRequset().getProducts();
    // }


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void createOrder(OrderPostRequset order) {
        OrderServiceImpl.INSTANCE.createOrder(order.getCustomerId(),order.getTotalPrice(), order.getPoducts());
    }

    @PATCH
    @Path("{oid}/cancel")
    public Response cancelOrder(@PathParam("oid") int id) {
        return Response.ok(OrderServiceImpl.INSTANCE.cancelOrder(id)).build();
    }

    @PATCH
    @Path("{oid}/approve")
    public Response approveOrder(@PathParam("oid") int id) {
        return Response.ok(OrderServiceImpl.INSTANCE.approveOrder(id)).build();
    }

}
