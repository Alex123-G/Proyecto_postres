package modelo;

public class Cliente {

private int cod_cliente;
private String nombre_cliente ;


public int getCod_cliente() {
	return cod_cliente;
}
public void setCod_cliente(int cod_cliente) {
	this.cod_cliente = cod_cliente;
}
public String getNombre_cliente() {
	return nombre_cliente;
}
public void setNombre_cliente(String nombre_cliente) {
	this.nombre_cliente = nombre_cliente;
}

@Override
public String toString() {
	return "Cliente [cod_cliente=" + cod_cliente + ", nombre_cliente=" + nombre_cliente +"]";
}



}
