package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.Grafo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private Jinternal_Inicio ji;
	private Jinternal_Registro jr;
	private JinternalGrafoDraw jg;
	JDesktopPane panelP = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
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
	public Interfaz() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 458);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarInicio();
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Está seguro de salir","Salir",JOptionPane.YES_NO_OPTION)==0) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Mostrar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Mostrar Hoteles");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarGrafo();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Habitaciones Disponibles");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ayuda al cliente");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Informacion");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panelP.setBackground(SystemColor.windowBorder);
		panelP.setBounds(0, 0, 1364, 717);
		contentPane.add(panelP);
		
	}
	void cargarInicio() {
		if(ji==null || ji.isClosed()) {
		
		ji=new Jinternal_Inicio();
		panelP.add(ji);
		ji.show(); 
		}
	}
	void cargarGrafo() {
		/*jg=new JinternalGrafoDraw();
		panelP.add(jg);
		jg.show();
		*/
		Grafo grafo = new Grafo(10);
        grafo.addHotel("Hotel A");
        grafo.addHotel("Hotel B");
        grafo.addHotel("Hotel C");
        grafo.addHotel("Hotel D");
        grafo.addDistance(0, 1, 100);
        grafo.addDistance(1, 2, 100);
        grafo.addDistance(2, 3, 100);
        grafo.addDistance(3, 0, 100);
        grafo.setVertexPosition(0, 100, 100);
        grafo.setVertexPosition(1, 300, 100);
        grafo.setVertexPosition(2, 300, 300);
        grafo.setVertexPosition(3, 100, 300);

        JinternalGrafoDraw internalFrame = new JinternalGrafoDraw(grafo);

        panelP.add(internalFrame);
        internalFrame.show();

	}
			
}

