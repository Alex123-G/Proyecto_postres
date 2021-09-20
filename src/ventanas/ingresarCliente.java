package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Cliente;
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

public class ingresarCliente extends JFrame {
	private static final long serialVersionUID = -8958440970887629009L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnReservar;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresarCliente frame = new ingresarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ingresarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage(ingresarCliente.class.getResource("/img/icono.png")));
		setTitle("Registrar cliente");
		setBounds(100, 100, 352, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre del cliente:");
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNombre.setBounds(10, 58, 111, 21);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(113, 58, 148, 19);
		contentPane.add(txtNombre);

		JLabel lblNewLabel = new JLabel("Registro de cliente");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(77, 11, 196, 36);
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
		btnReservar.setBounds(113, 90, 122, 36);
		contentPane.add(btnReservar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ingresarCliente.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 516, 137);
		contentPane.add(lblNewLabel_1);

	}

	

	// METODO PARA RESERVAR UN INSUMO
	void reserva() {
		String nombre_cliente;
        
        
        
        nombre_cliente= leerNombre();

Cliente c=new Cliente();
		
	c.setNombre_cliente(nombre_cliente);
	
		Gestion g = new Gestion();
		int ok = g.registrarCliente(c);
		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente", "¡ADVERTENCIA!", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Reserva registrada correctamente", "¡ENHORABUENA!", 1);
		}
	}

	
//Metodo get 

	
	String leerNombre() {
		return txtNombre.getText();
	}
	
	
}
