package gov.iti.jets.persistence.exceptions;

import gov.iti.jets.service.dtos.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProductNotFoundExceptionMapper implements ExceptionMapper<ProductNotFoundException> {
    @Override
    public Response toResponse(ProductNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "product not found exception");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
