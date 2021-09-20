package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class menuPrincipal extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		})
		;
	}

	/**
	 * Create the frame.
	 */
	public menuPrincipal() {

		setTitle("Menu Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(menuPrincipal.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 419);
		//Centrar jframe o vista
		this.setLocationRelativeTo(null);
		
		


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimento");
		mnNewMenu.setFont(new Font("Rockwell", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Insumo");
		mntmNewMenuItem.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarInsumo ii=new ingresarInsumo();
				ii.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ii.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Agregar Producto");
		mntmNewMenuItem_1.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarProducto ip=new ingresarProducto();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agregar Cliente");
		mntmNewMenuItem_2.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarCliente ip=new ingresarCliente();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Pedidos");
		mnNewMenu_1.setFont(new Font("Rockwell", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Agregar Pedido");
		mntmNewMenuItem_3.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarPedido ip=new ingresarPedido();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Buscar Pedido");
		mntmNewMenuItem_4.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaPedidos ip=new listaPedidos();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listar pedidos NO cancelados");
		mntmNewMenuItem_9.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaPedidosFaltantes ip=new listaPedidosFaltantes();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listar pedidos cancelados");
		mntmNewMenuItem_10.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaPedidosEntregados ip=new listaPedidosEntregados();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Actualizar estado del pedido");
		mntmNewMenuItem_11.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarpedido ip=new actualizarpedido();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_2 = new JMenu("Listar");
		mnNewMenu_2.setFont(new Font("Rockwell", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listar Precios");
		mntmNewMenuItem_7.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				precios_productos ip=new precios_productos();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar ingredientes por producto");
		mntmNewMenuItem_8.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ConsultaDeInusmosxPrdoucto ip=new ConsultaDeInusmosxPrdoucto();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Listar Productos");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				listaproductos ip=new listaproductos();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
			
			}
		});
		mntmNewMenuItem_13.setFont(new Font("Rockwell", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_3 = new JMenu("Modificar");
		mnNewMenu_3.setFont(new Font("Rockwell", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Modificar precios de insumos");
		mntmNewMenuItem_5.setFont(new Font("Rockwell", Font.PLAIN, 14));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarInsumo ip=new actualizarInsumo();
				ip.setVisible(true);
				
				
				//Esta line de codigo espara que aparesca centrada
				ip.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Modificar producto");
		mntmNewMenuItem_6.setFont(new Font("Rockwell", Font.PLAIN, 14));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	actualizarProductor ap=new actualizarProductor();
	ap.setVisible(true);
	ap.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblfondo = new JLabel("");
		lblfondo.setIcon(new ImageIcon(menuPrincipal.class.getResource("/img/descarga14.jpg")));
		lblfondo.setBounds(0, 0, 658, 485);
		contentPane.add(lblfondo);
		
	}
}
