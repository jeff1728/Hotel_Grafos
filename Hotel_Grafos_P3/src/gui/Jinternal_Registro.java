package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Jinternal_Registro extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jinternal_Registro frame = new Jinternal_Registro();
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
	public Jinternal_Registro() {
		getContentPane().setBackground(SystemColor.text);
		setBounds(100, 100, 525, 436);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel.setBounds(213, 26, 83, 40);
		getContentPane().add(lblNewLabel);

	}

}
