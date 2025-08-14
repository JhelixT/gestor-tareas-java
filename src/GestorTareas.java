package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea() {
        Scanner consola = new Scanner(System.in);
        String continuar;

        do {
            System.out.println("Ingrese la descripcion de la tarea");
            String descripcion = consola.nextLine();
            System.out.println("Ingrese el estado de la tarea (pendiente/completada)");
            String estado = consola.nextLine();

            Tarea nuevaTarea = new Tarea(descripcion, estado);
            tareas.add(nuevaTarea);

            System.out.println("¿Desea agregar otra tarea? (S/N)");
            continuar = consola.nextLine();

        } while (continuar.equalsIgnoreCase("S"));
        consola.close();
    }
}
