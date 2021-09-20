package modelo;

public class Pedido {

	private int cod__pedido;
	private String fecha_de_pedido, fecha_de_entrega;
	private int cod_prod, cod_cliente, cantidad;
	private String direccion_pedido;
	private int estado_pedido;
	private String nombre_prod;
	private String nombre_cliente;

	public int getCod__pedido() {
		return cod__pedido;
	}

	public void setCod__pedido(int cod__pedido) {
		this.cod__pedido = cod__pedido;
	}

	public String getFecha_de_pedido() {
		return fecha_de_pedido;
	}

	public void setFecha_de_pedido(String fecha_de_pedido) {
		this.fecha_de_pedido = fecha_de_pedido;
	}

	public String getFecha_de_entrega() {
		return fecha_de_entrega;
	}

	public void setFecha_de_entrega(String fecha_de_entrega) {
		this.fecha_de_entrega = fecha_de_entrega;
	}

	public int getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDireccion_pedido() {
		return direccion_pedido;
	}

	public void setDireccion_pedido(String direccion_pedido) {
		this.direccion_pedido = direccion_pedido;
	}

	public int getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(int estado_pedido) {
		this.estado_pedido = estado_pedido;
	}

	public String getNombre_prod() {
		return nombre_prod;
	}

	public void setNombre_prod(String nombre_prod) {
		this.nombre_prod = nombre_prod;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	@Override
	public String toString() {
		return "Pedido [cod__pedido=" + cod__pedido + ", fecha_de_pedido=" + fecha_de_pedido + ", fecha_de_entrega="
				+ fecha_de_entrega + ", cod_prod=" + cod_prod + ", cod_cliente=" + cod_cliente + ", cantidad="
				+ cantidad + ", direccion_pedido=" + direccion_pedido + ", estado_pedido=" + estado_pedido
				+ ", nombre_prod=" + nombre_prod + ", nombre_cliente=" + nombre_cliente + "]";
	}

}
