package Examen63.Examen63.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Recarga {

	@Id
	@GeneratedValue
	private int codigo;
	private String numTelefono;
	private double monto;
	private String operador;
	private String fechaRecarga;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getFechaRecarga() {
		return fechaRecarga;
	}
	public void setFechaRecarga(String fechaRecarga) {
		this.fechaRecarga = fechaRecarga;
	}
	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", numTelefono=" + numTelefono + ", monto=" + monto + ", operador="
				+ operador + ", fechaRecarga=" + fechaRecarga + "]";
	}
	
	
}
