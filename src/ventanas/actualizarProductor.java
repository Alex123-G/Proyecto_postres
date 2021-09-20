package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Producto;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class actualizarProductor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actualizarProductor frame = new actualizarProductor();
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
	public actualizarProductor() {
		setTitle("Actualizar Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(actualizarProductor.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Actualizar Producto");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(52, 11, 185, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Codigo del producto:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 54, 110, 31);
		contentPane.add(lblNewLabel_1);

		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtcodigo.setBounds(130, 59, 96, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre del producto:");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 90, 110, 20);
		contentPane.add(lblNewLabel_2);

		txtnombre = new JTextField();
		txtnombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtnombre.setBounds(130, 90, 96, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarproducto();
			}
		});
		btnNewButton.setBounds(52, 129, 131, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(actualizarProductor.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_3.setBounds(0, 0, 875, 298);
		contentPane.add(lblNewLabel_3);

	}

	void actualizarproducto() {
		int codigo_prodcuto;
		String nombre_prudcto;

		codigo_prodcuto = codigo_prodcuto();
		nombre_prudcto = nombre_producto();

		Producto p = new Producto();
		p.setCod_prod(codigo_prodcuto);
		p.setNombre_prod(nombre_prudcto);

		Gestion g = new Gestion();
		int ok = g.actualizarProducto(p);
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto", "¡ADVERTENCIA!", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Producto actualizado correctamente", "¡ENHORABUENA!", 1);
		}
	}

	int codigo_prodcuto() {
		return Integer.parseInt(txtcodigo.getText());

	}

	String nombre_producto() {
		return txtnombre.getText();

	}
}
