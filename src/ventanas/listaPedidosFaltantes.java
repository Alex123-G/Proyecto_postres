package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.Gestion;
import modelo.Pedido;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class listaPedidosFaltantes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	String titulos [] = {"Codigo del pedido","Fecha de entrega"};
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaPedidosFaltantes frame = new listaPedidosFaltantes();
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
	public listaPedidosFaltantes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 290);
		setIconImage(Toolkit.getDefaultToolkit().getImage(actualizarInsumo.class.getResource("/img/icono.png")));
		setTitle("Lista de pedido por cancelar");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("Lista de pedidos pendientes");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(58, 11, 239, 51);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 423, 167);
		contentPane.add(scrollPane);
		
		JTable tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		//Agregar los datos de modelo a la cabesera de la tabla
		tblTabla.setModel(modelo);	
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));
				
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(listaPedidosFaltantes.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1072, 422);
		contentPane.add(lblNewLabel_1);
	}

	void listadepedidos() {
		Gestion g=new Gestion();
		ArrayList<Pedido> lista=g.listaPedidoxestado();
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
