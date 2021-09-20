package mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaz.Interfaz;
import modelo.Cliente;
import modelo.Insumo;
import modelo.Pedido;
import modelo.Producto;
import utilitarios.MySQLConexion;

public class Gestion implements Interfaz {


	@Override
	public int registrarInsumo(Insumo i) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			// insert into insumo values(null,1,'Carne molida 100 g',4.80);

			String sql = "insert into insumo values(null,?,?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, i.getCod_prod());
			pst.setString(2, i.getNombre_insumo());
			pst.setDouble(3, i.getPrecio_insumo());
			
			rs = pst.executeUpdate();
			
			System.out.println(i);
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Registrar insumo) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Registrar de insumo) ==> " + e.getMessage());
			}
		}
		return rs;
	}




	@Override
	public int registrarProducto(Producto p) {
			int rs = 0;
			Connection con = null;
			PreparedStatement pst = null;
			try {
				con = MySQLConexion.getConexion();
				
				String sql = "insert into producto values(null,?)";
				pst = con.prepareStatement(sql);
				
				pst.setString(1, p.getNombre_prod());
				rs = pst.executeUpdate();
				System.out.println(p);
			} catch (Exception e) {
				System.out.println("Error en la sentencia(Registrar producto) ==> " + e.getMessage());
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar la BD(Registrar de producto) ==> " + e.getMessage());
				}
			}
			return rs;
		}



	@Override
	public int registrarPedido(Pedido pe) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			// insert into pedido values(null,curdate(),'2021-01-20',1,1,4,'Jr.Roosevel 840 Surco',1);

			String sql = "insert into pedido values(null,curdate(),?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, pe.getFecha_de_entrega());
			pst.setInt(2, pe.getCod_prod());
			pst.setInt(3, pe.getCod_cliente());
			pst.setDouble(4, pe.getCantidad());
			pst.setString(5, pe.getDireccion_pedido());
			pst.setInt(6, pe.getEstado_pedido());
			
			rs = pst.executeUpdate();
			System.out.println(pe);
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Registrar pedido) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Registrar pedido) ==> " + e.getMessage());
			}
		}
		return rs;
	}





	@Override
	public int registrarCliente(Cliente c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into cliente values(null,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1,c.getNombre_cliente());
			
			rs = pst.executeUpdate();
			System.out.println(c);
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Registrar cliente) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Registrar de cliente) ==> " + e.getMessage());
			}
		}
		return rs;
	}




	@Override
	public int actualizarInsumo(Insumo i) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

// update insumo set  cod_prod=2,nombre_insumo='Harina en polvo',precio_insumo=10.0 where cod_insumo=1;

			String sql = "update insumo set precio_insumo=? where cod_insumo= ?";
			pst = con.prepareStatement(sql);
			
			pst.setInt(2, i.getCod_insumo());
			pst.setDouble(1, i.getPrecio_insumo());
			System.out.println(i);
			rs = pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Registrar insumo) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Registrar de insumo) ==> " + e.getMessage());
			}
		}
		return rs;
	}






	@Override
	public int actualizarPedido(Pedido pe) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();


			String sql = "update pedido set estado_pedido=? where cod__pedido=?";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, pe.getEstado_pedido());
			pst.setInt(2, pe.getCod__pedido());
			System.out.println(pe);
			rs = pst.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Actualizar pedido) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Actualizar pedido) ==> " + e.getMessage());
			}
		}
		return rs;
	}




	@Override
	public ArrayList<Insumo> listadoDeInsumos() {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select cod_insumo,nombre_insumo  from insumo ";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Insumo i=new Insumo();
				i.setCod_insumo(rs.getInt(1));
				i.setNombre_insumo(rs.getString(2));
				
				lista.add(i);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar insumos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar insumos) ==> " + e.getMessage());
			}
		}
		return lista;
	}




	@Override
	public ArrayList<Producto> listaProductos() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select cod_prod,nombre_prod from producto";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Producto p=new Producto();
				
				
				p.setCod_prod(rs.getInt(1));
				p.setNombre_prod(rs.getString(2));
				
				lista.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar productos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar productos) ==> " + e.getMessage());
			}
		}
		return lista;
	}







	@Override
	public ArrayList<Cliente> listaCliente() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select cod_cliente,nombre_cliente from cliente";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Cliente c=new Cliente();

				c.setCod_cliente(rs.getInt(1));
				c.setNombre_cliente(rs.getString(2));
				
				lista.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar cliente ) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar cliente) ==> " + e.getMessage());
			}
		}
		return lista;
	}





	@Override
	public ArrayList<Producto> listaProductosSuma() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			/*select p.nombre_prod,sum(precio_insumo) as 'suma' from insumo as i inner join producto as p
on i.cod_prod=p.cod_prod   group by(i.cod_prod);*/
			String sql = "call lista_precios_productos()";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				
				Producto p=new Producto();
				
				p.setNombre_prod(rs.getString(1));
				p.setSuma(rs.getDouble(2));
				lista.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar precios de productos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar precio de productos) ==> " + e.getMessage());
			}
		}
		return lista;
	}
		




	@Override
	public ArrayList<Insumo> listadeinsumosxprod(int cod_prod) {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{Call lista_de_insumos(?)}";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, cod_prod);
			
			rs = pst.executeQuery();
			while(rs.next()){
			Insumo i=new Insumo();
			
			i.setNombre_insumo(rs.getString(1));
			i.setPrecio_insumo(rs.getDouble(2));
				lista.add(i);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar insumos por producto) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar insumos por producto) ==> " + e.getMessage());
			}
		}
		return lista;
	}



	@Override
	public Insumo obtenercod_insumo(int cod_insumo) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Pedido obtenercod__pedido(int cod__pedido) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ArrayList<Pedido> listaPedidoxestado() {
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select cod__pedido,fecha_de_entrega from pedido where estado_pedido= 0 ";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Pedido pe=new Pedido();
				pe.setCod__pedido(rs.getInt(1));
				pe.setFecha_de_entrega(rs.getString(2));

//FALTA AGREGAR LO QUE SE VA A LISTAR EJEMPLO NOMPROD,FECPEDIDO

				//FALTA AGREGAR LO QUE SE VA A LISTAR EJEMPLO NOMPROD,FECPEDIDO

				lista.add(pe);
				System.out.println(pe);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar pedidos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar pedidos) ==> " + e.getMessage());
			}
		}
		return lista;
	}




	@Override
	public int actualizarProducto(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update producto  set nombre_prod=? where cod_prod=?";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, p.getNombre_prod());
			pst.setInt(2, p.getCod_prod());
			rs = pst.executeUpdate();
			System.out.println(p);
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Actualizar producto) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Actualizar producto) ==> " + e.getMessage());
			}
		}
		return rs;
	}




	@Override
	public ArrayList<Pedido> lsitaPedidoxestadocancelado() {
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select cod__pedido,fecha_de_entrega from pedido where estado_pedido= 1 ";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Pedido pe=new Pedido();
				pe.setCod__pedido(rs.getInt(1));
				pe.setFecha_de_entrega(rs.getString(2));

//FALTA AGREGAR LO QUE SE VA A LISTAR EJEMPLO NOMPROD,FECPEDIDO

				//FALTA AGREGAR LO QUE SE VA A LISTAR EJEMPLO NOMPROD,FECPEDIDO

				lista.add(pe);
				System.out.println(pe);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar pedidos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar pedidos) ==> " + e.getMessage());
			}
		}
		return lista;
	}




	@Override
	public ArrayList<Pedido> listapedido() {
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "call listapedido()";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				
				Pedido pe=new Pedido();
				pe.setCod__pedido(rs.getInt(1));
				pe.setFecha_de_pedido(rs.getString(2));
				pe.setFecha_de_entrega(rs.getString(3));
				pe.setNombre_cliente(rs.getString(4));
				pe.setNombre_prod(rs.getString(5));
				pe.setCantidad(rs.getInt(6));
				
				lista.add(pe);
				System.out.println(pe);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia(Listar pedidos) ==> " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la BD(Listar pedidos) ==> " + e.getMessage());
			}
		}
		return lista;
	}
}
