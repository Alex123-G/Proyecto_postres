package ventanas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.Gestion;
import modelo.Pedido;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class listaPedidosEntregados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaPedidosEntregados frame = new listaPedidosEntregados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	String titulos [] = {"Codigo del pedido","Fecha de entrega"};
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);

	
	/**
	 * Create the frame.
	 */
	public listaPedidosEntregados() {
		setTitle("Lista de Pedidos Cancelados");
		setIconImage(Toolkit.getDefaultToolkit().getImage(listaPedidosEntregados.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de pedidos pendientes");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(58, 11, 233, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnlistar = new JButton("Listar");
		btnlistar.setBackground(Color.WHITE);
		btnlistar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadepedidos();

			}
		});
		btnlistar.setBounds(337, 20, 96, 38);
		contentPane.add(btnlistar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 423, 167);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		tblTabla.setModel(modelo);	
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));
		

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(listaPedidosEntregados.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1072, 422);
		contentPane.add(lblNewLabel_1);
	}
	
	void listadepedidos() {
		Gestion g=new Gestion();
		ArrayList<Pedido> lista=g.lsitaPedidoxestadocancelado();
		if(lista==null) {
			JOptionPane.showMessageDialog(null, "No se encontro pedidos pendientes","¡Ocurrio un problema!",0);			
		}
		else {
			for(Pedido pe:lista) {
				Object datos[]= {pe.getCod__pedido(),pe.getFecha_de_entrega()};
				modelo.addRow(datos);
				}
			}
	}
	
}
