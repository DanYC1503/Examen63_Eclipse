package Examen63.Examen63.Business;

import java.util.List;

import Examen63.Examen63.Dao.CuentaDAO;
import Examen63.Examen63.Dao.TransaccionDAO;
import Examen63.Examen63.Model.Transaccion;
import Examen63.Examen63.Model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuentas {
	
	@Inject
	private CuentaDAO daoCuenta;
	
	@Inject
	private TransaccionDAO daoTran;

	public void guardarCuentas(Cuenta cuenta) {
		Cuenta cue = daoCuenta.read(cuenta.getCodigo());
		if (cue != null){
			daoCuenta.update(cuenta);
		}else {
			daoCuenta.insert(cuenta);
		}
	}
	
	public void actualizarCuenta(Cuenta cuenta) throws Exception {
		Cuenta cue = daoCuenta.read(cuenta.getCodigo());
		if (cue != null){
			daoCuenta.update(cuenta);
		}else {
			throw new Exception("Cuenta no existe");
		}
	}
	
	public Cuenta getNumCuenta(String numCuenta) throws Exception{
		
		if(numCuenta.length()!=20)
			throw new Exception("Numero de cuenta incorrecta");
			
		return daoCuenta.getNumCuenta(numCuenta);
	}
	
	public void borrarCuenta(int codigo){
		
		daoCuenta.remove(codigo);
	}
	
	public List<Cuenta> getCuentas(){
		return daoCuenta.getAll();
	}
	
	public int realizarTransaccion(Transaccion transac) {
		return daoTran.realizarTransaccion(transac);
	}
	
}