package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Vuelo {

    private Ruta ruta;
    private String fecha;
    private Avion avion;
    private List<Tiquete> tiquetes;
    private boolean realizado;

    /**
     * Constructor de la clase Vuelo.
     * 
     * @param ruta La ruta que cubre el vuelo.
     * @param fecha La fecha en que se realiza el vuelo.
     * @param avion El avión asignado al vuelo.
     */
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
        this.realizado = false; // Inicialmente, el vuelo no ha sido realizado.
    }

    // Getters y Setters

    public Ruta getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public boolean esRealizado() {
        return realizado;
    }

    /**
     * Retorna los tiquetes asociados al vuelo.
     * 
     * @return Una colección de tiquetes.
     */
    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }

    /**
     * Agrega un tiquete al vuelo.
     * 
     * @param tiquete El tiquete que se agrega al vuelo.
     */
    public void agregarTiquete(Tiquete tiquete) {
        this.tiquetes.add(tiquete);
    }

    /**
     * Marca el vuelo como realizado.
     */
    public void registrarRealizacion() {
        this.realizado = true;
    }

    /**
     * Calcula los asientos disponibles en el vuelo.
     * 
     * @return La cantidad de asientos disponibles.
     */
    public int getAsientosDisponibles() {
        int asientosOcupados = tiquetes.size();
        return avion.getCapacidad() - asientosOcupados;
    }

    @Override
    public String toString() {
        return "Vuelo [ruta=" + ruta + ", fecha=" + fecha + ", avion=" + avion.getNombre() 
               + ", realizado=" + realizado + ", tiquetesVendidos=" + tiquetes.size() + "]";
    }

	public int venderTiquetes(Cliente cliente, int cantidad) {
		// TODO Auto-generated method stub
		return 0;
	}
}
