package Examen63.Examen63.Services;

import java.util.List;

import Examen63.Examen63.Business.GestionCuentas;
import Examen63.Examen63.Model.Cuenta;
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

@Path("cuentas")

public class CuentaService {
	
	@Inject
	private GestionCuentas gCuentas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Cuenta cuenta) {
		try {
			gCuentas.guardarCuentas(cuenta);
			return Response.ok(cuenta).build();
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
			gCuentas.borrarCuenta(codigo);
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
	public Response getCuentas() {
		try {
			List<Cuenta> cuentas = gCuentas.getCuentas();
			if (cuentas.size() > 0)
				return Response.ok(cuentas).build();
			else {
				ErrorMessage error = new ErrorMessage(6, "No se registran cuentas");
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
