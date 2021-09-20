package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import mantenimiento.Gestion;
import modelo.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class precios_productos extends JFrame {

	private JPanel contentPane;
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	
	
	String titulos [] = {"Nombre del producto","Costo del producto"};
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);
	private JLabel lblNewLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					precios_productos frame = new precios_productos();
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
	public precios_productos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setTitle("Lista de precios de productos");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(actualizarInsumo.class.getResource("/img/icono.png")));
		setForeground(Color.ORANGE);
		setBackground(Color.WHITE);
		setFont(new Font("DialogInput", Font.BOLD, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage(precios_productos.class.getResource("/img/icono.png")));
		setTitle("Lista precios");
		setBounds(100, 100, 512, 293);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 469, 166);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setModel(modelo);
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));

		scrollPane.setViewportView(tblTabla);
		
		
		JButton btnListar = new JButton("Listar precios");
		btnListar.setBackground(Color.WHITE);
		btnListar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listadeprecio();
				
				
			}
		});
		btnListar.setBounds(164, 197, 168, 43);
		contentPane.add(btnListar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(precios_productos.class.getResource("/img/descarga14.jpg")));
		lblNewLabel.setBounds(0, 0, 498, 254);
		contentPane.add(lblNewLabel);
	}
	
	
	void listadeprecio() {
		Gestion g=new Gestion();
		ArrayList<Producto> lista=g.listaProductosSuma();
		if(lista==null) {
			JOptionPane.showMessageDialog(null, "No se encontro productos","¡Ocurrio un problema!",0);			
		}
		else {
			
			for(Producto p:lista) {
				Object datos[]= {p.getNombre_prod(),p.getSuma()};
				modelo.addRow(datos);
				}
			}
	
		
	}
	
}
