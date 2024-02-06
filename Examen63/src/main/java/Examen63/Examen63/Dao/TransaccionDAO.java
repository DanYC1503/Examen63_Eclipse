package Examen63.Examen63.Dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Examen63.Examen63.Model.Recarga;
import Examen63.Examen63.Model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TransaccionDAO {

    @PersistenceContext
    private EntityManager em;

    @Inject
	private RecargaDAO daoRec;
    
    public int realizarTransaccion(Transaccion transac) {
    	SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        
        if (transac.getMonto() < 0) {
            return 0;
        } else if (transac.getNumTelefono1().length() > 10) {
            return 2;
        } else {
            String cuenta1 = "SELECT c.saldo FROM Cuenta c WHERE c.numTelefono = :numTelefono1";
            Query q1 = em.createQuery(cuenta1);
            System.out.println(transac.getNumTelefono1());
            q1.setParameter("numTelefono1", transac.getNumTelefono1());
            List<Double> cue1 = q1.getResultList();
	            if (cue1.isEmpty()) {
	                return 5; // No hay cuenta existente
	            }
            Double mont1 = cue1.get(0);
            
            String cuenta = "SELECT c.operadora FROM Cuenta c WHERE c.numTelefono = :numTelefono1";
            Query q2 = em.createQuery(cuenta);
            q2.setParameter("numTelefono1", transac.getNumTelefono1());
            List<String> cue_1 = q2.getResultList();
            String operadora = cue_1.get(0);
            
            System.out.println(operadora);
            System.out.println(transac.getOperadora());
            if (operadora.equalsIgnoreCase(transac.getOperadora())) {
                System.out.println("Cuenta 1 : " + mont1);
                
                double monto = transac.getMonto();

                // Update the balances
                mont1 = mont1 + monto;

                System.out.println("Cuenta 1 : " + mont1);
                   
                // Update the first account
                String updateQuery1 = "UPDATE Cuenta c SET c.saldo = :monto1 WHERE c.numTelefono = :numTelefono";
                Query updateQ1 = em.createQuery(updateQuery1);
                updateQ1.setParameter("monto1", mont1);
                updateQ1.setParameter("numTelefono", transac.getNumTelefono1());
                updateQ1.executeUpdate();
                
                // Transaction successful
                Recarga rec = new Recarga();
		        // Establecer el monto de la recarga
		        rec.setMonto(monto);
		        rec.setFechaRecarga(dateFormat1.format(new Date()));
		        rec.setNumTelefono(transac.getNumTelefono1());
		        rec.setOperador(operadora);
                daoRec.insert(rec);
                return 1;
            } else {
                return 3; // Operadora mismatch
            }
            
        } 
    }
}
