package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import mantenimiento.Gestion;
import modelo.Insumo;
import modelo.Producto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class ConsultaDeInusmosxPrdoucto extends JFrame {

	private JPanel contentPane;
	private JTable tblTabla;

	String titulos [] = {"Nombre de insumo","Precio de insumo"};
	
	DefaultTableModel modelo = new DefaultTableModel(titulos,0);
	
	
	private JComboBox<String> cboCod_Prod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeInusmosxPrdoucto frame = new ConsultaDeInusmosxPrdoucto();
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
	public ConsultaDeInusmosxPrdoucto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setTitle("Busqueda de insumos por producto");
		//Par colocarle un icono a la imagen
				this.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaDeInusmosxPrdoucto.class.getResource("/img/icono.png")));
				
		setBounds(100, 100, 616, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 580, 189);
		contentPane.add(scrollPane);
		
		//Colocar la cabecera para la tabla
		tblTabla = new JTable();
		tblTabla.setFont(new Font("Agency FB", Font.BOLD, 16));
		
		tblTabla.getTableHeader().setFont(new Font("Agency FB", Font.BOLD, 17));
		tblTabla.setModel(modelo);
		scrollPane.setViewportView(tblTabla);
		
		JLabel lblproducto = new JLabel("Seleccione el producto:");
		lblproducto.setFont(new Font("Agency FB", Font.BOLD, 17));
		lblproducto.setBounds(10, 20, 135, 18);
		contentPane.add(lblproducto);
		
		cboCod_Prod = new JComboBox<String>();
		cboCod_Prod.setBackground(Color.WHITE);
		cboCod_Prod.setFont(new Font("Agency FB", Font.BOLD, 17));
		cboCod_Prod.setBounds(137, 18, 147, 22);
		contentPane.add(cboCod_Prod);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(Color.WHITE);
		btnListar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		comboproducto();
		
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		listaxprod();
			
			}
		});
		
		
		btnListar.setBounds(334, 18, 140, 26);
		contentPane.add(btnListar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(484, 18, 106, 26);
		contentPane.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultaDeInusmosxPrdoucto.class.getResource("/img/descarga14.jpg")));
		lblNewLabel.setBounds(0, 0, 601, 253);
		contentPane.add(lblNewLabel);
		
		
	}
	
	
	void comboproducto() {
		ArrayList<Producto> lista=new Gestion().listaProductos();
	cboCod_Prod.addItem("Seleccione el producto");
	for(Producto p:lista) {
		cboCod_Prod.addItem(p.getNombre_prod());}	
	}
	
	
	void listaxprod() {
		int cod_prod;
		cod_prod=leerprod();
		Gestion g=new Gestion();
		ArrayList<Insumo> lista=g.listadeinsumosxprod(cod_prod);
		if(lista==null) {
			JOptionPane.showMessageDialog(null, "No se encontro insumo","¡Ocurrio un problema!",0);			
		}
		else {
			
			for(Insumo i:lista) {
				Object datos[]= {i.getNombre_insumo(),i.getPrecio_insumo()};
				modelo.addRow(datos);
				
				}
			}
		}
	
	void limpiar() {
		int fila = tblTabla.getRowCount();
		for(int i = fila-1; i>=0; i--){
			 modelo.removeRow(i);
		}
		
	}

	
	//Metodo get
	
	int leerprod() {
		return cboCod_Prod.getSelectedIndex();
		
	}
}
