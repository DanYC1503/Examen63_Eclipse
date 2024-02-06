package Examen63.Examen63.Services;

import java.util.List;

import Examen63.Examen63.Business.GestionRecargas;
import Examen63.Examen63.Model.Recarga;
import Examen63.Examen63.Model.Transaccion;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("recargas")

public class RecargaService {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			gRecargas.guardarRecargas(recarga);
			return Response.ok(recarga).build();
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try {
			gRecargas.borrarRecarga(codigo);
			return Response.ok("OK").build();
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas() {
		try {
			List<Recarga> recargas = gRecargas.getRecargas();
			if (recargas.size() > 0)
				return Response.ok(recargas).build();
			else {
				ErrorMessage error = new ErrorMessage(6, "No se registran recargas");
				return Response.status(Response.Status.NOT_FOUND)
						.entity(error)
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	

	
	
}
