package src;
import java.util.Scanner;

public class TestGestor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== GESTOR DE TAREAS ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tareas completadas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Agregar tarea seleccionado");
                    break;
                case 2:
                    System.out.println("Listar tareas seleccionado");
                    break;
                case 3:
                    System.out.println("Marcar como completada seleccionado");
                    break;
                case 4:
                    System.out.println("Eliminar completadas seleccionado");
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}