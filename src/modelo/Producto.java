package modelo;
public class Producto {

	private int cod_prod;
	private String nombre_prod;
	private int cod_insumo ;
private String nombre_insumo ;
private double suma;


	public double getSuma() {
	return suma;
}
public void setSuma(double suma) {
	this.suma = suma;
}
	public int getCod_prod() {
		return cod_prod;
	}
	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}
	public String getNombre_prod() {
		return nombre_prod;
	}
	public void setNombre_prod(String nombre_prod) {
		this.nombre_prod = nombre_prod;
	}
	
	public int getCod_insumo() {
		return cod_insumo;
	}
	public void setCod_insumo(int cod_insumo) {
		this.cod_insumo = cod_insumo;
	}
	public String getNombre_insumo() {
		return nombre_insumo;
	}
	public void setNombre_insumo(String nombre_insumo) {
		this.nombre_insumo = nombre_insumo;
	}
	
	@Override
	public String toString() {
		return "Producto [cod_prod=" + cod_prod + ", nombre_prod=" + nombre_prod + ", cod_insumo=" + cod_insumo
				+ ", nombre_insumo=" + nombre_insumo;
	}
	
	
}
