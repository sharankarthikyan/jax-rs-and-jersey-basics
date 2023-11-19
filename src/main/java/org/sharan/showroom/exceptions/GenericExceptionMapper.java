package org.sharan.showroom.exceptions;

import org.sharan.showroom.model.ErrorPayload;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.*;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorPayload error = new ErrorPayload(500, "The value of custom header not found");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}
}
