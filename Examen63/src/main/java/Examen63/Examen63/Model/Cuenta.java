package Examen63.Examen63.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombreCuenta;
	private String numTelefono;
	private double saldo;
	private String fechaCreacion;
	private String operadora;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaRecarga) {
		this.fechaCreacion = fechaRecarga;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", nombreCuenta=" + nombreCuenta + ", numTelefono=" + numTelefono
				+ ", saldo=" + saldo + ", fechaCreacion=" + fechaCreacion + ", operadora=" + operadora + "]";
	}
	
	
	
	
}
