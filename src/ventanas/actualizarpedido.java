package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.Gestion;
import modelo.Pedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class actualizarpedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<?> cbopedido;
	private JTextField txtcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actualizarpedido frame = new actualizarpedido();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public actualizarpedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(actualizarpedido.class.getResource("/img/icono.png")));
		setTitle("Actualizar estado del pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 428, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizar Estado Pedido");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(16, 11, 216, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				pedido();
			}
		});
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnNewButton.setBounds(269, 109, 133, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo del pedido:");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 70, 119, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estado del pedido");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 93, 119, 19);
		contentPane.add(lblNewLabel_2);
		
		cbopedido = new JComboBox();
		cbopedido.setFont(new Font("Agency FB", Font.BOLD, 16));
		cbopedido.setModel(new DefaultComboBoxModel(new String[] {"Por realziar", "Realizado", "Entregado", "Por entregar"}));
		cbopedido.setBounds(139, 90, 93, 22);
		contentPane.add(cbopedido);
		
		
		
		txtcodigo = new JTextField();
		txtcodigo.setFont(new Font("Agency FB", Font.BOLD, 16));
		txtcodigo.setBounds(139, 66, 93, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(actualizarpedido.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_3.setBounds(0, 0, 417, 180);
		contentPane.add(lblNewLabel_3);
	}
	

void pedido(){
		
		int cod_pedido;
		int estado_pedido;
		
			cod_pedido=cod_pedido();
			estado_pedido=estado_pedido();
		
			Pedido pe=new Pedido();
					pe.setCod__pedido(cod_pedido);
			pe.setEstado_pedido(estado_pedido);
			
			Gestion ge=new Gestion();
			int ok=ge.actualizarPedido(pe);
		if (ok==0) {
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido", "¡ADVERTENCIA!", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Pedido actualizado correctamente", "¡ENHORABUENA!", 1);
		}
		
		
		}

	
	
	int cod_pedido() {
		return Integer.parseInt(txtcodigo.getText());		
	}
	
	int estado_pedido() {
		return cbopedido.getSelectedIndex();
	}
}
