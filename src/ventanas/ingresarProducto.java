package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ingresarProducto extends JFrame {
	private static final long serialVersionUID = -8958440970887629009L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnReservar;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresarProducto frame = new ingresarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ingresarProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage(ingresarProducto.class.getResource("/img/icono.png")));
		setTitle("Registro de producto");
		setBounds(100, 100, 371, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre del producto :");
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNombre.setBounds(10, 63, 111, 21);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(131, 63, 119, 19);
		contentPane.add(txtNombre);

		JLabel lblNewLabel = new JLabel("Registro de producto");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(58, 11, 224, 36);
		contentPane.add(lblNewLabel);

		btnReservar = new JButton("Reservar ");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(Color.WHITE);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserva();
			}
		});
		btnReservar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnReservar.setBounds(115, 99, 119, 36);
		contentPane.add(btnReservar);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ingresarProducto.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, -36, 875, 298);
		contentPane.add(lblNewLabel_1);

	}

	// METODO PARA RESERVAR UNA MATRICULA O PENSION
	void reserva() {
		String nombre;

		nombre = leerNombre();

		Producto p = new Producto();
		p.setNombre_prod(nombre);

		Gestion g = new Gestion();
		int ok = g.registrarProducto(p);
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar producto", "¡ADVERTENCIA!", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Reserva registrada correctamente", "¡ENHORABUENA!", 1);
		}
	}

//Metodo get 

	String leerNombre() {
		return txtNombre.getText();
	}

}
