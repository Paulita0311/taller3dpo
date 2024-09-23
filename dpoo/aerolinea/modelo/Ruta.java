package uniandes.dpoo.aerolinea.modelo;

import java.util.Objects;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta {

    /**
     * Código único que identifica la ruta
     */
    private String codigoRuta;

    /**
     * Aeropuerto de origen de la ruta
     */
    private Aeropuerto origen;

    /**
     * Aeropuerto de destino de la ruta
     */
    private Aeropuerto destino;

    /**
     * Hora de salida de los vuelos para esta ruta (en formato hhmm)
     */
    private String horaSalida;

    /**
     * Hora de llegada de los vuelos para esta ruta (en formato hhmm)
     */
    private String horaLlegada;

    /**
     * Constructor de la clase Ruta
     * 
     * @param origen Aeropuerto de origen de la ruta
     * @param destino Aeropuerto de destino de la ruta
     * @param horaSalida Hora de salida de los vuelos para esta ruta (en formato hhmm)
     * @param horaLlegada Hora de llegada de los vuelos para esta ruta (en formato hhmm)
     * @param codigoRuta Código único que identifica la ruta
     */
    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoRuta = codigoRuta;
    }

    /**
     * Retorna el aeropuerto de origen de la ruta
     * @return El aeropuerto de origen
     */
    public Aeropuerto getOrigen() {
        return origen;
    }

    /**
     * Retorna el aeropuerto de destino de la ruta
     * @return El aeropuerto de destino
     */
    public Aeropuerto getDestino() {
        return destino;
    }

    /**
     * Retorna la hora de salida de los vuelos para esta ruta
     * @return La hora de salida en formato hhmm
     */
    public String getHoraSalida() {
        return horaSalida;
    }

    /**
     * Retorna la hora de llegada de los vuelos para esta ruta
     * @return La hora de llegada en formato hhmm
     */
    public String getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * Retorna el código de la ruta
     * @return El código único de la ruta
     */
    public String getCodigoRuta() {
        return codigoRuta;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos(String horaCompleta) {
        int minutos = Integer.parseInt(horaCompleta) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras(String horaCompleta) {
        int horas = Integer.parseInt(horaCompleta) / 100;
        return horas;
    }

    @Override
    public String toString() {
        return "Ruta [origen=" + origen.getNombre() + ", destino=" + destino.getNombre() + ", horaSalida=" + horaSalida
                + ", horaLlegada=" + horaLlegada + ", codigoRuta=" + codigoRuta + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ruta other = (Ruta) obj;
        return Objects.equals(codigoRuta, other.codigoRuta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoRuta);
    }
}
