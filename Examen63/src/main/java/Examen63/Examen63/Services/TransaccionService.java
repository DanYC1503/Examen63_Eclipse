package Examen63.Examen63.Services;


import Examen63.Examen63.Business.GestionRecargas;
import Examen63.Examen63.Dao.TransaccionDAO;
import Examen63.Examen63.Model.Transaccion;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Path;

@Path("transaccion")

public class TransaccionService {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizar(Transaccion trans) {
	    try {
	        // Assuming gCuentas is an instance of your service class
	    	System.out.println("--------------INTENTANDO-----------------");
	        gRecargas.realizarTransaccion(trans);
	        return Response.ok(trans).build();
	    } catch (Exception e) {
	        // Log the exception for future reference
	        e.printStackTrace();
	        
	        // Create a detailed error message
	        ErrorMessage error = new ErrorMessage(99, "Error updating/transacting: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(error)
	                .build();
	    }
	}
}
