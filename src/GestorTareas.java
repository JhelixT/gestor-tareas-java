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
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        mostrarTareas();
        Scanner consola = new Scanner(System.in);
        
        try {
            System.out.println("Indique el número de tarea que quiere marcar como completada:");
            int index = Integer.parseInt(consola.nextLine());
            if (index < 1 || index > tareas.size()) {
                System.out.println("Número de tarea inválido.");
                return;
            }

            Tarea tarea = tareas.get(index - 1);
            if (tarea.getEstado().equalsIgnoreCase("completada")) {
                System.out.println("La tarea ya está marcada como completada.");
                return;
            }

            tarea.setEstado("completada");
            System.out.println("Tarea marcada como completada exitosamente.");
            
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
        }
    }

    public static void eliminarCompletadas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        int sizePrevio = tareas.size();
        tareas.removeIf(tarea -> tarea.getEstado().equalsIgnoreCase("completada"));
        int tareasEliminadas = sizePrevio - tareas.size();

        if (tareasEliminadas > 0) {
            System.out.printf("Se han eliminado %d tareas completadas.%n", tareasEliminadas);
        } else {
            System.out.println("No había tareas completadas para eliminar.");
        }
    }
}
