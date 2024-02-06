package Examen63.Examen63.Dao;

import java.util.ArrayList;
import java.util.List;

import Examen63.Examen63.Model.Cuenta;
import Examen63.Examen63.Model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cuenta cuenta) {
		em.merge(cuenta);
	}
	
	public void update(Cuenta cuenta) {
		em.merge(cuenta);
	}
	
	public void remove(int codigo) {
		Cuenta cuenta = em.find(Cuenta.class, codigo);
		em.remove(cuenta);
	}
	
	public Cuenta read(int codigo) {
		Cuenta cuenta = em.find(Cuenta.class, codigo);
		return cuenta;
	}
	
	public List<Cuenta> getAll(){
		String jpql = "SELECT c FROM Cuenta c";
		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
	
	public Cuenta getNumCuenta(String numCuenta){

		String jpql = "SELECT c FROM Cuenta c WHERE c.numCuenta = :numCuenta";
		Query q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("numCuenta", numCuenta);
		List<Cuenta> cuentas = q.getResultList();
		if(cuentas.size()>0)
			return cuentas.get(0);
		return null;
	}
	
	
}
