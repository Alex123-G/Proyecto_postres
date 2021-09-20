package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Insumo;
import modelo.Producto;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ingresarInsumo extends JFrame {
	private static final long serialVersionUID = -8958440970887629009L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnReservar;
	private JComboBox<Object> cbocodprod;
	private JLabel lblnomprod;
	private JLabel lblPrecioDeInsumo;
	private JTextField txtPrecio;

	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresarInsumo frame = new ingresarInsumo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ingresarInsumo() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ingresarInsumo.class.getResource("/img/icono.png")));
		setTitle("Registrar Insumo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre de insumo:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNombre.setBounds(28, 91, 111, 21);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(157, 93, 167, 19);
		contentPane.add(txtNombre);

		JLabel lblNewLabel = new JLabel("Registrar insumo");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(98, 12, 182, 36);
		contentPane.add(lblNewLabel);

		btnReservar = new JButton("Agregar");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(Color.WHITE);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserva();
			}
		});
		btnReservar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnReservar.setBounds(114, 155, 119, 36);
		contentPane.add(btnReservar);

		cbocodprod = new JComboBox<Object>();
		cbocodprod.setBounds(157, 58, 167, 22);
		getContentPane().add(cbocodprod);

		lblnomprod = new JLabel("Nombre de producto");
		lblnomprod.setForeground(Color.BLACK);
		lblnomprod.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblnomprod.setBounds(28, 62, 111, 14);
		contentPane.add(lblnomprod);

		lblPrecioDeInsumo = new JLabel("Precio de insumo:");
		lblPrecioDeInsumo.setForeground(Color.BLACK);
		lblPrecioDeInsumo.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblPrecioDeInsumo.setBackground(Color.WHITE);
		lblPrecioDeInsumo.setBounds(28, 123, 111, 21);
		contentPane.add(lblPrecioDeInsumo);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(157, 123, 167, 19);
		contentPane.add(txtPrecio);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ingresarInsumo.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 373, 205);
		contentPane.add(lblNewLabel_1);

		comboProductos();
	}

	void comboProductos() {
		ArrayList<Producto> lista = new Gestion().listaProductos();
		cbocodprod.addItem("Seleccionar producto");
		for (Producto p : lista) {
			cbocodprod.addItem(p.getNombre_prod());
		}
	}

	// METODO PARA RESERVAR UN INSUMO
	void reserva() {
		String nombre_insumo;
        int cod_prod;
        double precio;
        
		nombre_insumo = leerNombre();
		cod_prod=leercod_prod();
		precio=leerprecio();

		Insumo i = new Insumo();
		
		i.setCod_prod(cod_prod);
		i.setNombre_insumo(nombre_insumo);
		i.setPrecio_insumo(precio);
		
		Gestion g = new Gestion();
		int ok = g.registrarInsumo(i);
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el insumo", "¡ADVERTENCIA!", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Reserva registrada correctamente", "¡ENHORABUENA!", 1);
		}
	}

	
//Metodo get 
	String leerNombre() {
		return txtNombre.getText();
	}
	
	int leercod_prod() {
		return cbocodprod.getSelectedIndex();
	}
	
	double leerprecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
}
