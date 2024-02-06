package Examen63.Examen63.Business;

import java.util.Date;
import java.util.List;

import Examen63.Examen63.Model.Cuenta;
import Examen63.Examen63.Model.Recarga;
import Examen63.Examen63.Model.Transaccion;
import Examen63.Examen63.Dao.CuentaDAO;
import Examen63.Examen63.Dao.RecargaDAO;
import Examen63.Examen63.Dao.TransaccionDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import java.text.SimpleDateFormat;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private TransaccionDAO daoTran;
	
	@Inject
	private RecargaDAO daoRec;
	
	@Inject
	private CuentaDAO daoCuenta;
	
	
	@PostConstruct
	public void init() {
		
		System.out.println("iniciando");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		
		//--------------Creacion de las cuentas--------------------
		Cuenta cuenta = new Cuenta();
		cuenta.setNombreCuenta("Daniel Yanza");
		cuenta.setNumTelefono("0979251007");;
		cuenta.setFechaCreacion(dateFormat1.format(new Date()));
		cuenta.setSaldo(1.25);
		cuenta.setOperadora("Movistar");
		
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setNombreCuenta("Wilson Yanza");
		cuenta1.setNumTelefono("0984687303");;
		cuenta1.setFechaCreacion(dateFormat1.format(new Date()));
		cuenta1.setSaldo(1.25);
		cuenta1.setOperadora("Movistar");
		
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setNombreCuenta("Mercedes Caceres");
		cuenta2.setNumTelefono("0984378627");;
		cuenta2.setFechaCreacion(dateFormat1.format(new Date()));
		cuenta2.setSaldo(1.05);
		cuenta2.setOperadora("Tuenti");
		
		Cuenta cuenta3 = new Cuenta();
		cuenta3.setNombreCuenta("Nelioska Granda");
		cuenta3.setNumTelefono("0979278886");;
		cuenta3.setFechaCreacion(dateFormat1.format(new Date()));
		cuenta3.setSaldo(0.20);
		cuenta3.setOperadora("Claro");
		
		//--------------Insertamos las cuentas---------------------
		daoCuenta.insert(cuenta);
		daoCuenta.insert(cuenta1);
		daoCuenta.insert(cuenta2);
		daoCuenta.insert(cuenta3);
		

		

		/*System.out.println("\n------------- Cuentas");
		List<Cuenta> list = daoCuenta.getAll();
		for (Cuenta cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Cuentas----------------------");
		
		List<Cuenta> list = daoCuenta.getAll();
		for(Cuenta accounts : list) {
			System.out.println(accounts);
		}
		
		System.out.println("\n------------- Recarga----------------------");
		
		Transaccion tra1 = new Transaccion("0979251007", 2.00, "Movistar");
		Transaccion tra2 = tra1;
		int result = daoTran.realizarTransaccion(tra1);
		// Realizar la transacción utilizando el DAO correspondiente
		switch (result) {
		    case 1:
		        // Si la transacción fue exitosa, proceder con la inserción de la recarga
		        
		        System.out.println("Exito en la transaccion"); // Éxito en la transacción
		        break;
		    case 0:
		        // Si el resultado indica un error debido a un monto menor a cero
		        System.out.println("Error de Recarga, Monto menor a CERO no aceptado");
		        break;
		    case 2:
		        // Si el resultado indica un error debido a un número telefónico de longitud irregular
		        System.out.println("Error de Recarga, Numero telefonico de longitud irregular");
		        break;
		    case 3:
		        // Si el resultado indica un error debido a una operadora incorrecta asociada al número telefónico
		        System.out.println("Error de Recarga, Operadora Incorrecta del numero telefonico");
		        break;
		    case 5:
		        // Si el resultado indica un error debido a una operadora incorrecta asociada al número telefónico
		        System.out.println("No existe Numero telefonico registrado");
		        break;
		    default:
		        break;
		}

				
		List<Recarga> list1 = daoRec.getAll();
		for(Recarga recargas : list1) {
			System.out.println(recargas);
		}

	}
}