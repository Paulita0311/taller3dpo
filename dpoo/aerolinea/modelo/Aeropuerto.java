package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;

/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto {
    // Constante para el radio aproximado de la Tierra en kilómetros
    public static final int RADIO_TERRESTRE = 6371;

    /**
     * Nombre del aeropuerto
     */
    private String nombre;

    /**
     * Código único del aeropuerto
     */
    private String codigo;

    /**
     * Nombre de la ciudad en la que está ubicado el aeropuerto
     */
    private String nombreCiudad;

    /**
     * Latitud del aeropuerto
     */
    private double latitud;

    /**
     * Longitud del aeropuerto
     */
    private double longitud;

    /**
     * Conjunto estático de códigos de aeropuertos ya creados para evitar duplicados
     */
    private static Set<String> codigos = new HashSet<>();

    /**
     * Constructor de la clase Aeropuerto.
     * 
     * @param nombre       Nombre del aeropuerto
     * @param codigo       Código único del aeropuerto
     * @param nombreCiudad Nombre de la ciudad del aeropuerto
     * @param latitud      Latitud del aeropuerto
     * @param longitud     Longitud del aeropuerto
     * @throws AeropuertoDuplicadoException Si ya existe un aeropuerto con el mismo código
     */
    public Aeropuerto(String nombre, String codigo, String nombreCiudad, double latitud, double longitud)
            throws AeropuertoDuplicadoException {
        if (codigos.contains(codigo)) {
            throw new AeropuertoDuplicadoException(codigo);
        }
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreCiudad = nombreCiudad;
        this.latitud = latitud;
        this.longitud = longitud;
        codigos.add(codigo); // Agregar el código a la lista de códigos ya usados
    }

    /**
     * Retorna el nombre del aeropuerto
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el código del aeropuerto
     * 
     * @return código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna el nombre de la ciudad donde está el aeropuerto
     * 
     * @return nombreCiudad
     */
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    /**
     * Retorna la latitud del aeropuerto
     * 
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * Retorna la longitud del aeropuerto
     * 
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Este método calcula la distancia *aproximada* entre dos aeropuertos.
     * 
     * @param aeropuerto1 Primer aeropuerto
     * @param aeropuerto2 Segundo aeropuerto
     * @return La distancia en kilómetros entre los puntos
     */
    public static int calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        // Convertir los ángulos a radianes para facilitar las operaciones trigonométricas
        double latAeropuerto1 = Math.toRadians(aeropuerto1.getLatitud());
        double lonAeropuerto1 = Math.toRadians(aeropuerto1.getLongitud());
        double latAeropuerto2 = Math.toRadians(aeropuerto2.getLatitud());
        double lonAeropuerto2 = Math.toRadians(aeropuerto2.getLongitud());

        // Calcular la distancia debido a la diferencia de latitud y de longitud
        double deltaX = (lonAeropuerto2 - lonAeropuerto1) * Math.cos((latAeropuerto1 + latAeropuerto2) / 2);
        double deltaY = (latAeropuerto2 - latAeropuerto1);

        // Calcular la distancia real en kilómetros
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY) * RADIO_TERRESTRE;

        return (int) Math.round(distancia);
    }

    /**
     * Elimina un aeropuerto del conjunto de códigos para permitir que se pueda reutilizar el código
     * 
     * @param codigo Código del aeropuerto que se desea eliminar
     */
    public static void eliminarCodigo(String codigo) {
        codigos.remove(codigo);
    }

    @Override
    public String toString() {
        return "Aeropuerto [nombre=" + nombre + ", codigo=" + codigo + ", nombreCiudad=" + nombreCiudad + ", latitud="
                + latitud + ", longitud=" + longitud + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) obj;
        return codigo.equals(other.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}

