package hotel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  Scanner scanner=new Scanner(System.in);
		  int maxHotels = 10;
		  Grafo h = new Grafo(maxHotels);
		  
		  int choice=0;
		  do {
			  System.out.println("1. Agregar hotel");
	            System.out.println("2. Agregar distancia entre hoteles");
	            System.out.println("3. Mostrar grafo");
	            System.out.println("4. Salir");
	            System.out.print("Seleccione una opción: ");
	             choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Ingrese el nombre del hotel: ");
	                    String hotelName = scanner.nextLine();
	                    h.addHotel(hotelName);
	                    break;
	                case 2:
	                    System.out.print("Ingrese el nombre del primer hotel: ");
	                    String hotelName1 = scanner.nextLine();
	                    int hotelIndex1 = h.getHotelIndexByName(hotelName1);
	                    if (hotelIndex1 == -1) {
	                        System.out.println("Hotel no encontrado.");
	                        break;
	                    }
	                    System.out.print("Ingrese el nombre del segundo hotel: ");
	                    String hotelName2 = scanner.nextLine();
	                    int hotelIndex2 = h.getHotelIndexByName(hotelName2);
	                    if (hotelIndex2 == -1) {
	                        System.out.println("Hotel no encontrado.");
	                        break;
	                    }
	                    System.out.print("Ingrese la distancia en km: ");
	                    int distance = scanner.nextInt();
	                    h.addDistance(hotelIndex1, hotelIndex2, distance);
	                    break;
	                case 3:
	                    h.printGraph();
	                    break;
	                case 4:
	                    System.out.println("Saliendo del programa.");
	                    return;
	                default:
	                    System.out.println("Opción inválida. Inténtelo de nuevo.");
	            
          	}
          }while(choice!=4);

	}

 }


