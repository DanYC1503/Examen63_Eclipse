package Examen63.Examen63.Dao;

import java.util.ArrayList;
import java.util.List;

import Examen63.Examen63.Model.Recarga;
import Examen63.Examen63.Model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void update(Recarga recarga) {
		em.merge(recarga);
	}
	
	public void remove(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		em.remove(recarga);
	}
	
	public Recarga read(int codigo) {
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
	}
	
	public List<Recarga> getAll(){
		String jpql = "SELECT c FROM Recarga c";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
}
