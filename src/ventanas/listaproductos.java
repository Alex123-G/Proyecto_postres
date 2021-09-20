package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimiento.Gestion;
import modelo.Producto;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class listaproductos extends JFrame {

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
					listaproductos frame = new listaproductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	String titulos [] = {"Codigo del producto","Nombre del producto"};
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);

	
	/**
	 * Create the frame.
	 */
	public listaproductos() {
		setTitle("Lista de Productos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(listaproductos.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Productos");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 27));
		lblNewLabel.setBounds(104, 11, 182, 51);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 423, 167);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		tblTabla.setModel(modelo);	
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));

		
		JButton btnlistar = new JButton("Listar");
		btnlistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista();
			}
		});
		
		btnlistar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnlistar.setBackground(Color.WHITE);
		btnlistar.setBounds(337, 20, 96, 38);
		contentPane.add(btnlistar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(listaproductos.class.getResource("/img/descarga14.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1072, 422);
		contentPane.add(lblNewLabel_1);
	}
	
	
	void lista() {
		Gestion g=new Gestion();
		ArrayList<Producto> lista=g.listaProductos();
		if(lista==null) {
			JOptionPane.showMessageDialog(null, "No se encontro pedidos pendientes","¡Ocurrio un problema!",0);			
		}
		else {
			for(Producto p:lista) {
				Object datos[]= {p.getCod_prod(),p.getNombre_prod()};
				modelo.addRow(datos);
				}
			}
	}
		
	
}
