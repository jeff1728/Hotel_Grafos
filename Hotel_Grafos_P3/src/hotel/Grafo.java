package hotel;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Grafo {
	  private String[] hotels;     // Arreglo para almacenar nombres de hoteles
	    private int[][] distances;   // Matriz para almacenar distancias entre hoteles
	    private int[] xPositions; // Coordenadas x de los vértices
	    private int[] yPositions; // Coordenadas y de los vértices
	    public Grafo(int maxHotels) {
	        hotels = new String[maxHotels];         // Inicializa el arreglo de hoteles con tamaño máximo
	        distances = new int[maxHotels][maxHotels]; // Inicializa la matriz de distancias con tamaño máximo
	        xPositions = new int[maxHotels];
	        yPositions = new int[maxHotels];
	    }

	    public void addHotelRecursive(String hotelName, int index) {
	        if (index < hotels.length) {      // Verifica si el índice está dentro de los límites del arreglo
	            if (hotels[index] == null) {  // Verifica si el espacio en el índice está vacío
	                hotels[index] = hotelName; // Agrega el nombre del hotel en el índice actual
	                System.out.println("Hotel agregado en el índice " + index);
	                return;
	            }
	            addHotelRecursive(hotelName, index + 1); // Llamada recursiva para buscar el siguiente índice
	        } else {
	            System.out.println("No hay espacio para más hoteles."); // Se imprime si no hay espacio disponible
	        }
	    }

	    public void addHotel(String hotelName) {
	        addHotelRecursive(hotelName, 0); // Llama al método recursivo para agregar un hotel
	    }

	    public void addDistance(int hotelIndex1, int hotelIndex2, int distance) {
	        distances[hotelIndex1][hotelIndex2] = distance; // Agrega la distancia entre dos hoteles en la matriz
	        distances[hotelIndex2][hotelIndex1] = distance; // La matriz es simétrica, por lo que se agrega en ambos sentidos
	    }

	    public int getHotelIndexByName(String hotelName) {
	        for (int i = 0; i < hotels.length; i++) {
	            if (hotels[i] != null && hotels[i].equalsIgnoreCase(hotelName)) {
	                return i; // Devuelve el índice del hotel que coincide con el nombre
	            }
	        }
	        return -1; // Si no se encuentra el hotel, devuelve -1
	    }

	    public void printGraph() {
	        for (int i = 0; i < hotels.length; i++) {
	            if (hotels[i] != null) {
	                String output = hotels[i] + " -> ";
	                for (int j = 0; j < hotels.length; j++) {
	                    if (distances[i][j] != 0 && hotels[j] != null) {
	                        output += hotels[j] + "(" + distances[i][j] + " km) ";
	                    }
	                }
	                JOptionPane.showMessageDialog(null, output); // Muestra el grafo 
	            }
	        }
	    }
	    public String[] getHotels() {
	        return hotels;
	    }
	    public int[][] getDistances() {
	        return distances;
	    }
	    public void setVertexPosition(int index, int x, int y) {
	        xPositions[index] = x;
	        yPositions[index] = y;
	    }

	    public int getXPosition(int index) {
	        return xPositions[index];
	    }

	    public int getYPosition(int index) {
	        return yPositions[index];
	    }
}