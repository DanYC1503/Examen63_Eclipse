package Examen63.Examen63.Model;

public class Transaccion {

	private String numTelefono1;
	private double monto;
	private String operadora;
	
	
	public Transaccion(String numTelefono1, double monto, String operadora ) {
		this.numTelefono1 = numTelefono1;
		this.monto = monto;
		this.operadora = operadora;
	}
	public Transaccion() {
        // Default constructor
    }

	public String getNumTelefono1() {
		return numTelefono1;
	}

	public void setNumTelefono1(String numTelefono1) {
		this.numTelefono1 = numTelefono1;
	}


	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	@Override
	public String toString() {
		return "Transaccion [numTelefono1=" + numTelefono1 + ", monto=" + monto + ", operadora=" + operadora + "]";
	}

	
	
	
	
	
	
	
}
