package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import mantenimiento.Gestion;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class ingresarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtcantidad;
	private JTextField txtdireccion;
	private JComboBox<String> cboproducto;
	private JComboBox<String> cbocliente;
	private JDateChooser txtfecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresarPedido frame = new ingresarPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ingresarPedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ingresarPedido.class.getResource("/img/icono.png")));
		setTitle("Registrar pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro de pedido");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(115, 0, 173, 48);
		contentPane.add(lblNewLabel);

		txtfecha = new JDateChooser();
		txtfecha.setBounds(157, 70, 159, 20);
		contentPane.add(txtfecha);
		txtfecha.setFont(new Font("Agency FB", Font.BOLD, 16));

		JLabel lblfecha = new JLabel("Ingresar Fecha de pedido:");
		lblfecha.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblfecha.setBounds(10, 70, 141, 20);
		contentPane.add(lblfecha);

		JLabel lblproducto = new JLabel("Nombre de producto:");
		lblproducto.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblproducto.setBounds(10, 97, 129, 14);
		contentPane.add(lblproducto);

		JLabel lblcliente = new JLabel("Nombre del cliente");
		lblcliente.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblcliente.setBounds(10, 127, 129, 14);
		contentPane.add(lblcliente);

		JLabel lblcantidad = new JLabel("Cantidad");
		lblcantidad.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblcantidad.setBounds(10, 157, 129, 14);
		contentPane.add(lblcantidad);

		JLabel lbldireccion = new JLabel("Direccion:");
		lbldireccion.setFont(new Font("Agency FB", Font.BOLD, 16));
		lbldireccion.setBounds(10, 187, 129, 14);
		contentPane.add(lbldireccion);

		cboproducto = new JComboBox<String>();
		cboproducto.setBackground(Color.WHITE);
		cboproducto.setFont(new Font("Agency FB", Font.BOLD, 16));
		cboproducto.setBounds(157, 95, 159, 22);
		contentPane.add(cboproducto);

		cbocliente = new JComboBox<String>();
		cbocliente.setBackground(Color.WHITE);
		cbocliente.setFont(new Font("Agency FB", Font.BOLD, 16));
		cbocliente.setBounds(157, 125, 159, 22);
		contentPane.add(cbocliente);

		txtcantidad = new JTextField();
		txtcantidad.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtcantidad.setBounds(157, 156, 159, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);

		txtdireccion = new JTextField();
		txtdireccion.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtdireccion.setBounds(157, 186, 159, 20);
		contentPane.add(txtdireccion);
		txtdireccion.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				registrarpedido();
			}

		});
		btnRegistrar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnRegistrar.setBounds(357, 173, 129, 41);
		contentPane.add(btnRegistrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ingresarPedido.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, -24, 629, 391);
		contentPane.add(lblNewLabel_1);

		comboproducto();
		combocliente();
	}

	void comboproducto() {
		ArrayList<Producto> lista = new Gestion().listaProductos();
		cboproducto.addItem("Seleccionar producto");
		for (Producto p : lista) {
			cboproducto.addItem(p.getNombre_prod());
		}
	}

	void combocliente() {
		ArrayList<Cliente> lista = new Gestion().listaCliente();
		cbocliente.addItem("Seleccionar cliente");
		for (Cliente c : lista) {
			cbocliente.addItem(c.getNombre_cliente());
		}
	}

	void registrarpedido() {

	////Leer la fecha
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String fecha_pedi= sdf.format(txtfecha.getDate());

		
		int cod_prod,cod_cliente,cantidad;
String direccion;

cod_prod=cod_prod();
cod_cliente=cod_cliente();
cantidad=cantidad();
direccion=direccion();

Pedido pe=new Pedido();
pe.setFecha_de_entrega(fecha_pedi);
pe.setCod_prod(cod_prod);
pe.setCod_cliente(cod_cliente);
pe.setCantidad(cantidad);
pe.setDireccion_pedido(direccion);


Gestion g=new Gestion();
int ok=g.registrarPedido(pe);
if (ok == 0) {
	JOptionPane.showMessageDialog(null, "No se pudo registrar el insumo", "¡ADVERTENCIA!", 0);
} else {
	JOptionPane.showMessageDialog(null, "Reserva registrada correctamente", "¡ENHORABUENA!", 1);
}

	}

	
	int cod_prod() {
		return cboproducto.getSelectedIndex();
		
	}
	int cod_cliente() {
		return cbocliente.getSelectedIndex();
	}
	
	int cantidad() {
		return Integer.parseInt(txtcantidad.getText());
	}
	
	String  direccion() {
		return txtdireccion.getText();
	}
	
			
	
	
}
