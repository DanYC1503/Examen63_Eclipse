package Examen63.Examen63.Business;

import java.util.List;

import Examen63.Examen63.Dao.RecargaDAO;
import Examen63.Examen63.Dao.TransaccionDAO;
import Examen63.Examen63.Model.Transaccion;
import Examen63.Examen63.Model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {
	
	@Inject
	private RecargaDAO daoRecarga;
	
	@Inject
	private TransaccionDAO daoTran;

	public void guardarRecargas(Recarga recarga) {
		Recarga cue = daoRecarga.read(recarga.getCodigo());
		if (cue != null){
			daoRecarga.update(recarga);
		}else {
			daoRecarga.insert(recarga);
		}
	}
	
	public void actualizarRecarga(Recarga recarga) throws Exception {
		Recarga cue = daoRecarga.read(recarga.getCodigo());
		if (cue != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Recarga no existe");
		}
	}
	
	
	public void borrarRecarga(int codigo){
		
		daoRecarga.remove(codigo);
	}
	
	public List<Recarga> getRecargas(){
		return daoRecarga.getAll();
	}
	
	public int realizarTransaccion(Transaccion transac) {
		return daoTran.realizarTransaccion(transac);
	}
	
}