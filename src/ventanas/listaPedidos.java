package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.Gestion;
import modelo.Pedido;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class listaPedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */

	String titulos [] = {"Codigo del pedido","Fecha del pedido","Fecha de entrega","Nombre del cliente","Nombre del producto","Cantidad"};
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaPedidos frame = new listaPedidos();
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
	public listaPedidos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(listaPedidos.class.getResource("/img/icono.png")));
		setTitle("Lista de pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 648, 164);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		//Agregar los datos de modelo a la cabesera de la tabla
		tblTabla.setModel(modelo);	
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));
		

		
		JLabel lblNewLabel = new JLabel("Lista de pedidos ");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(235, 19, 158, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnlistar = new JButton("Listar");
		btnlistar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnlistar.setBackground(Color.WHITE);
		btnlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			listapedidos();
			}
		});
		btnlistar.setBounds(562, 24, 96, 38);
		contentPane.add(btnlistar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(listaPedidos.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 700, 555);
		contentPane.add(lblNewLabel_1);
	}

	void listapedidos() {
		Gestion g=new Gestion();
		ArrayList<Pedido> lista=g.listapedido();
		if(lista==null) {
			JOptionPane.showMessageDialog(null, "No se encontro pedidos pendientes","¡Ocurrio un problema!",0);			
		}
		else {
			for(Pedido pe:lista) {
				Object datos[]= {pe.getCod__pedido(),pe.getFecha_de_pedido(),pe.getFecha_de_entrega(),pe.getNombre_cliente(),pe.getNombre_prod(),pe.getCantidad()};
				modelo.addRow(datos);
				}
			}

	}

}
