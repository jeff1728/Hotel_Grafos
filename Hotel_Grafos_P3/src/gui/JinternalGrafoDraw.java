package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hotel.Grafo;

public class JinternalGrafoDraw extends JInternalFrame {

	private Grafo grafo; // Referencia al grafo
	 @Override
	    public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2d = (Graphics2D) g;

	        for (int i = 0; i < grafo.getHotels().length; i++) {
	            if (grafo.getHotels()[i] != null) {
	                int x = calculateXPosition(i);
	                int y = calculateYPosition(i);

	                g2d.setColor(Color.RED);
	                g2d.drawOval(x, y, 20, 20);

	                g2d.setColor(Color.BLACK);
	                g2d.drawString(grafo.getHotels()[i], x, y);
	            }
	        }
	        for (int i = 0; i < grafo.getHotels().length; i++) {
	            for (int j = i + 1; j < grafo.getHotels().length; j++) {
	                int distance = grafo.getDistances()[i][j];
	                if (distance > 0) {
	                    int x1 = grafo.getXPosition(i) + 10;
	                    int y1 = grafo.getYPosition(i) + 10;
	                    int x2 = grafo.getXPosition(j) + 10;
	                    int y2 = grafo.getYPosition(j) + 10;

	                    g2d.setColor(Color.BLUE);
	                    g2d.drawLine(x1, y1, x2, y2);
	                }
	            }
	        }
	    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Grafo grafo = new Grafo(5); // Create a graph with maximum 5 vertices
				        grafo.addHotel("Hotel A");
				        grafo.addHotel("Hotel B");
				        grafo.addHotel("Hotel C");
				        grafo.addHotel("Hotel D");
				        grafo.addDistance(0, 1, 50); // Hotel A - Hotel B
				        grafo.addDistance(1, 2, 50); // Hotel B - Hotel C
				        grafo.addDistance(2, 3, 50); // Hotel C - Hotel D
				        grafo.addDistance(3, 0, 50); // Hotel D - Hotel A
				        
				        grafo.addDistance(0, 1, 100); // Hotel A - Hotel B
				        grafo.addDistance(1, 2, 100); // Hotel B - Hotel C
				        grafo.addDistance(2, 3, 100); // Hotel C - Hotel D
				        grafo.addDistance(3, 0, 100); // Hotel D - Hotel A
				        
				        EventQueue.invokeLater(() -> {
				            JFrame frame = new JFrame("Graph Drawing Example");
				            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				            frame.setSize(600, 400);
				            frame.setLocationRelativeTo(null);

				            JinternalGrafoDraw internalFrame = new JinternalGrafoDraw(grafo);
				            frame.add(internalFrame);
				            internalFrame.setVisible(true);

				            frame.setVisible(true);
				        });
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 private int calculateXPosition(int index) {
	        // Calculate the x position based on the index or any logic you want
	        // For simplicity, let's use a basic formula: 50 pixels between each vertex
	        return 50 + index * 50;
	    }

	    private int calculateYPosition(int index) {
	        // Calculate the y position based on the index or any logic you want
	        // For simplicity, let's use a constant y position
	        return 150;
	    }


	/**
	 * Create the frame.
	 */
	 public JinternalGrafoDraw(Grafo grafo) {
	        this.grafo = grafo;
	        setBounds(100, 100, 683, 455);
	        this.setSize(500, 500);
	        this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);
	    }
	
	
}
