package uniandes.dpoo.aerolinea.modelo;

public class Avion {
    private String nombre;
    private int capacidad;

    public Avion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Avion [nombre=" + nombre + ", capacidad=" + capacidad + "]";
    }
}