package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Insumo;
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

public class actualizarInsumo extends JFrame {
	private static final long serialVersionUID = -8958440970887629009L;
	private JPanel contentPane;
	private JButton btnReservar;
	private JLabel lblPrecioDeInsumo;
	private JTextField txtPrecio;
	private JComboBox<String> cboInsumo;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actualizarInsumo frame = new actualizarInsumo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public actualizarInsumo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage(actualizarInsumo.class.getResource("/img/icono.png")));
		setTitle("Actualizar estado del insumo");
	setBounds(100, 100, 390, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Actualizar insumo");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(84, 9, 167, 36);
		contentPane.add(lblNewLabel);

		btnReservar = new JButton("Actualizar");
		btnReservar.setForeground(Color.BLACK);
		btnReservar.setBackground(Color.WHITE);
		btnReservar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/*
				 * Ubicacion donde irira el ocdigo para realizar la actualizacion del inusmno,
				 * pero hemos ehco un metodo aparte para disminur el codigo,lo que hace el boton
				 * es llamar el metodo y ejecutar ese metodo;
				 */
				reserva();

			}
		});
		btnReservar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnReservar.setBounds(120, 122, 119, 36);
		contentPane.add(btnReservar);

		lblPrecioDeInsumo = new JLabel("Precio de insumo:");
		lblPrecioDeInsumo.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblPrecioDeInsumo.setBackground(Color.WHITE);
		lblPrecioDeInsumo.setBounds(28, 86, 111, 21);
		contentPane.add(lblPrecioDeInsumo);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(149, 88, 167, 19);
		contentPane.add(txtPrecio);
		
		JLabel lblNombre = new JLabel("Nombre de insumo:");
		lblNombre.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(28, 56, 102, 21);
		contentPane.add(lblNombre);
		
		cboInsumo = new JComboBox<String>();
		cboInsumo.setBounds(149, 56, 167, 22);
		contentPane.add(cboInsumo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(actualizarInsumo.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 374, 180);
		contentPane.add(lblNewLabel_1);

				comboInsumos();
	}

	void comboInsumos() {
		ArrayList<Insumo> lista = new Gestion().listadoDeInsumos();
		cboInsumo.addItem("Seleccionar insumo");
		for (Insumo i : lista) {
			cboInsumo.addItem(i.getNombre_insumo());
		}

	}

	// METODO PARA Actualizar un insumo
	void reserva() {

		int cod_insumo;
		double precio_insumo;
		
		cod_insumo=cod_insumo();
		precio_insumo=precio_insumo();
		
		Insumo i=new Insumo();
		
		i.setCod_insumo(cod_insumo);

		i.setPrecio_insumo(precio_insumo);

	Gestion g=new Gestion();
	int ok=g.actualizarInsumo(i);
	if(ok==0) {
		JOptionPane.showMessageDialog(null, "No se pudo actualizar el insumo", "¡ADVERTENCIA!", 0);
	} else {
		JOptionPane.showMessageDialog(null, "Insumo actualizado correctamente", "¡ENHORABUENA!", 1);
	}
	}
	
	

//Metodo get 

	int cod_insumo() {
		return cboInsumo.getSelectedIndex();
	}

	double precio_insumo() {
		return Double.parseDouble(txtPrecio.getText());
	}
}
