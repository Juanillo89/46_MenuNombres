package ejercicio46;

import java.util.Scanner;

public class MenuNombres
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String opcion;
		String nombre;
		String[] nombres = new String[5];
		boolean repetido;
		int contNombres = 0;
		do
		{
			System.out.println();
			System.out.println("1.-Introducir nombre.");
			System.out.println("2.-Listar nombres.");
			System.out.println("3.-Eliminar nombre.");
			System.out.println("4.-Eliminar todos los nombres.");
			System.out.println("5.-Salir.");
			System.out.println();
			System.out.print("Opción (1-5): ");
			opcion = sc.nextLine();
			switch (opcion)
			{
			// Introducir nombre
			case "1":
				// Si la lista no está llena
				if(contNombres < nombres.length)
				{
					System.out.print("Introduce nombre: ");
					nombre = sc.nextLine();
					repetido = false;
					// Se buscan repetidos hasta el contador o hasta que se encuentre
					for(int i = 0; i < contNombres && !repetido; i++)
					{
						// Si es igual está repetido
						if(nombre.equalsIgnoreCase(nombres[i]))
						{
							repetido = true;
						}
					}
					// Si está repetido sólo se muestra el mensaje
					if(repetido)
					{
						System.out.println("Nombre repetido.");
					}
					// Si no está repetido se guarda el nombre en el array en la
					//posición del contador y se aumenta éste en uno
					else
					{
						nombres[contNombres] = nombre;
						contNombres++;
					}
				}
				// Si la lista está llena sólo se muestra el mensaje
				else
				{
					System.out.println("Lista llena.");
				}
				break;
			// Listar nombres
			case "2":
				// Se lista el array hasta el contador
				for(int i = 0; i < contNombres; i++)
				{
					System.out.print(nombres[i] + "\t");
				}
				// Si el contador está a cero la lista está vacía
				if(contNombres == 0)
				{
					System.out.println("Lista vacía.");
				}
				break;
			// Eliminar nombre
			case "3":
				// Si hay nombres introducidos
				if(contNombres != 0)
				{
					System.out.print("Nombre a eliminar: ");
					nombre = sc.nextLine();
					repetido = false;
					// Se busca el nombre en el array hasta el contador o
					//hasta que se encuentre
					int i = 0;
					while(i < contNombres && !repetido)
					{
						if(nombre.equalsIgnoreCase(nombres[i]))
						{
							repetido = true;
						}
						else
						{
							i++;
						}
					}
					// Si se ha encontrado
					if(repetido)
					{
						// Se mueven los nombres una posición a la izquierda
						//desde la posición donde se encontró que quedará machacada
						//y se resta uno al contador de nombres
						for(int j = i; j < nombres.length - 1; j++)
						{
							nombres[j] = nombres[j + 1];
						}
						contNombres--;
					}
					// Si no se ha encontrado
					else
					{
						System.out.println("El nombre no está en la lista.");
					}
				}
				// Si el contador de nombres está a cero
				else
				{
					System.out.println("Lista vacía.");
				}
				break;
			// Eliminar todos los nombres
			case "4":
				// Si la lista no está vacía se pone el contador a cero
				if(contNombres != 0)
				{
					contNombres = 0;
					System.out.println("Nombres eliminados.");
				}
				// Si está vacía se muestra el mensaje
				else
				{
					System.out.println("La lista ya está vacía.");
				}
				break;
			// Salir
			case "5":
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		}
		// Se seguirá mostrando el menú mientras no se elija salir
		while(!opcion.equals("5"));
		sc.close();
	}
}
