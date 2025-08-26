package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTareas {
    private static List<Tarea> tareas = new ArrayList<>();

    public static void agregarTarea() {
        Scanner consola = new Scanner(System.in);
        String continuar;

        do {
            String descripcion;
            String estado;
            do{
                System.out.println("Ingrese la descripcion de la tarea");
                descripcion = consola.nextLine();
                if(descripcion.equals("")){
                    System.out.println("No se permiten descripciones vacias");
                }
            }while(descripcion.equals(""));
            
            do {
                System.out.println("Ingrese el estado de la tarea (pendiente/completada)");
                estado = consola.nextLine().toLowerCase();
                if(estado.equals("")) {
                    System.out.println("No se permiten estados vacios");
                } else if (!estado.equals("pendiente") && !estado.equals("completada")) {
                    System.out.println("Estado no válido. Use 'pendiente' o 'completada'");
                }
            } while(estado.equals("") || (!estado.equals("pendiente") && !estado.equals("completada")));

            Tarea nuevaTarea = new Tarea(descripcion, estado);
            tareas.add(nuevaTarea);

            System.out.println("¿Desea agregar otra tarea? (S/N)");
            continuar = consola.nextLine();

        } while (continuar.equalsIgnoreCase("S"));
        consola.close();
    }

    public static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("\n=== LISTA DE TAREAS ===");
        int contador = 1;
        for (Tarea tarea : tareas) {
            System.out.printf("%d. Descripción: %s | Estado: %s%n", 
                            contador++, 
                            tarea.getDescripcion(), 
                            tarea.getEstado());
        }
        System.out.println("=====================");
    }

    public static void marcarComoCompletada() {
    
    }

    public static void eliminarCompletadas() {
        
    }
}
