package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import hotel.*;
import javax.swing.ImageIcon;
import java.awt.Color;
public class Jinternal_Inicio extends JInternalFrame {
	private JTextField txthotel;
	private JTextField txthotel1;
	private JTextField txthotel2;
	 int maxHotels = 10;
		Grafo g=new Grafo(maxHotels);
		private JTextField txtdistancia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jinternal_Inicio frame = new Jinternal_Inicio();
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
	public Jinternal_Inicio() {
		setBounds(100, 100, 744, 425);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOTEL");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 35));
		lblNewLabel.setBounds(312, 11, 110, 21);
		getContentPane().add(lblNewLabel);
		
		txthotel = new JTextField();
		txthotel.setColumns(10);
		txthotel.setBounds(312, 77, 86, 20);
		getContentPane().add(txthotel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE DEL HOTEL");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1.setBounds(112, 83, 190, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.setFont(new Font("Roboto", Font.BOLD, 17));
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				g.addHotel(txthotel.getText());
				JOptionPane.showMessageDialog(null, "Hotel añadido!");
								
			}
		});
		btningresar.setBounds(296, 108, 105, 23);
		getContentPane().add(btningresar);
		
		JButton btnarco = new JButton("Ingresar distancia");
		btnarco.setFont(new Font("Roboto", Font.BOLD, 17));
		btnarco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hotelindex1=g.getHotelIndexByName(txthotel1.getText());
				int hotelindex2=g.getHotelIndexByName(txthotel2.getText());
				String input=txtdistancia.getText();
				if (isNumeric(input)) {
                     JOptionPane.showMessageDialog(null, "Distancia agregada");
                 } else {
                     JOptionPane.showMessageDialog(null, "Por favor, ingrese una distancia valida");
                 }
				g.addDistance(hotelindex1, hotelindex2, Integer.valueOf(txtdistancia.getText()));
				
			}
		});
		btnarco.setBounds(167, 223, 173, 23);
		getContentPane().add(btnarco);
		
		txthotel1 = new JTextField();
		txthotel1.setBounds(183, 174, 86, 20);
		getContentPane().add(txthotel1);
		txthotel1.setColumns(10);
		
		txthotel2 = new JTextField();
		txthotel2.setBounds(471, 174, 86, 20);
		getContentPane().add(txthotel2);
		txthotel2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PUNTO DE SALIDA");
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 177, 163, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PUNTO DE LLEGADA");
		lblNewLabel_4.setForeground(new Color(139, 0, 0));
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_4.setBounds(279, 165, 182, 35);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnmostrar = new JButton("mostrar hoteles");
		btnmostrar.setFont(new Font("Roboto", Font.BOLD, 17));
		btnmostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.printGraph();
			}
		});
		btnmostrar.setBounds(371, 223, 155, 23);
		getContentPane().add(btnmostrar);
		
		txtdistancia = new JTextField();
		txtdistancia.setBounds(606, 174, 86, 20);
		getContentPane().add(txtdistancia);
		txtdistancia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DISTANCIA");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_2.setBounds(597, 149, 106, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Jinternal_Inicio.class.getResource("/images/2017030611304896805.jpg")));
		lblNewLabel_5.setBounds(0, 0, 728, 384);
		getContentPane().add(lblNewLabel_5);

	}
	 private static boolean isNumeric(String str) {
	        try {
	            Integer.parseInt(str); // Intenta convertir el texto en un número entero
	            return true; // Si no se lanza una excepción, el valor es numérico
	        } catch (NumberFormatException e) {
	            return false; // Si ocurre una excepción, el valor no es numérico
	        }
	    }
}
