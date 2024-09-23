package uniandes.dpoo.aerolinea.tiquetes;

import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.Tiquete;

/**
 * Esta clase se encarga de manejar todos los tiquetes vendidos por la aerolínea.
 * Se encarga de registrar tiquetes, consultar tiquetes por su código y validar si un tiquete existe o no.
 */
public class Tiquetes {

    // Un mapa donde las llaves son los códigos de los tiquetes y los valores son los tiquetes
    private Map<String, Tiquete> tiquetes;

    /**
     * Constructor de la clase Tiquetes.
     * Inicializa la estructura para almacenar los tiquetes.
     */
    public Tiquetes() {
        tiquetes = new HashMap<>();
    }

    /**
     * Agrega un nuevo tiquete al sistema.
     * 
     * @param tiquete El tiquete a registrar.
     */
    public void registrarTiquete(Tiquete tiquete) {
        tiquetes.put(tiquete.getCodigo(), tiquete);
    }

    /**
     * Verifica si existe un tiquete con un código dado.
     * 
     * @param codigoTiquete El código del tiquete que se está buscando.
     * @return true si existe un tiquete con ese código, false en caso contrario.
     */
    public boolean existeTiquete(String codigoTiquete) {
        return tiquetes.containsKey(codigoTiquete);
    }

    /**
     * Retorna un tiquete basado en su código.
     * 
     * @param codigoTiquete El código del tiquete a buscar.
     * @return El tiquete correspondiente al código, o null si no existe.
     */
    public Tiquete obtenerTiquete(String codigoTiquete) {
        return tiquetes.get(codigoTiquete);
    }

    /**
     * Elimina un tiquete del sistema.
     * 
     * @param codigoTiquete El código del tiquete a eliminar.
     * @return true si el tiquete fue eliminado, false si no existía.
     */
    public boolean eliminarTiquete(String codigoTiquete) {
        return tiquetes.remove(codigoTiquete) != null;
    }

    /**
     * Retorna el número total de tiquetes vendidos.
     * 
     * @return El número total de tiquetes.
     */
    public int getNumeroTotalTiquetes() {
        return tiquetes.size();
    }

    /**
     * Imprime la información de todos los tiquetes registrados.
     */
    public void imprimirTiquetes() {
        for (Tiquete tiquete : tiquetes.values()) {
            System.out.println(tiquete);
        }
    }
}
