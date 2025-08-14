package src;
public class Tarea {

    private String descripcion;
    private String estado;
   
    public Tarea(String descripcion, String estado){
        this.descripcion=descripcion;
        this.estado=estado;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
