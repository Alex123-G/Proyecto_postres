package interfaz;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Insumo;
import modelo.Pedido;
import modelo.Producto;

public interface Interfaz {
	
	public int registrarInsumo(Insumo i);
	public int registrarProducto(Producto p);
	public int registrarPedido(Pedido pe);
	public int registrarCliente (Cliente c);
	public int actualizarInsumo(Insumo i);
	public int actualizarPedido(Pedido pe);
	public int actualizarProducto(Producto p);
	
	public ArrayList<Insumo> listadoDeInsumos();
	public ArrayList<Producto> listaProductos();
	public ArrayList<Cliente> listaCliente();

	
	//Lista los productos y la sumna del precio de los insumos
	public ArrayList<Producto> listaProductosSuma();
	
	// Lista de los insumos por el codigo del producto
	public ArrayList<Insumo> listadeinsumosxprod(int cod_prod);
	
	//Metodo para obtener los datos del insumo segun el codigo
	public Insumo  obtenercod_insumo(int cod_insumo);
	
	//Metodo para obtener los datos del pedido para actualizar el estado del pedido
	public Pedido obtenercod__pedido(int cod__pedido);
	
	//Metodo  para la lsita de los pedidos que no estan activos esdecir que estado sea 2
	public ArrayList<Pedido> listaPedidoxestado();
	
	public ArrayList<Pedido> lsitaPedidoxestadocancelado();
public ArrayList<Pedido> listapedido();
	
}
