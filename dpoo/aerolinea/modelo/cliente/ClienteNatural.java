package uniandes.dpoo.aerolinea.modelo.cliente;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son personas naturales.
 */
public abstract class ClienteNatural extends Cliente {

    public static final String NATURAL = null;
	/**
     * El nombre del cliente natural.
     */
    private String nombreCliente;

    /**
     * Constructor de la clase ClienteNatural.
     * 
     * @param nombreCliente El nombre del cliente natural.
     */
    public ClienteNatural(String nombreCliente) {
        super(NATURAL); // Llamada al constructor de la clase Cliente con el tipo "Natural".
        this.nombreCliente = nombreCliente;
    }

    /**
     * Retorna el nombre del cliente natural.
     * 
     * @return El nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Implementación del método abstracto que calcula los tiquetes pendientes.
     * La lógica puede variar según el número de tiquetes comprados o alguna otra regla.
     * 
     * @return El número de tiquetes pendientes para este cliente natural.
     */
    @Override
    public int calcularTiquetesPendientes() {
        // Aquí debe ir la lógica para calcular los tiquetes pendientes.
        // Por ejemplo, se puede usar una lista de tiquetes asociados a este cliente.
        // Para este ejemplo, devolveremos un valor ficticio.
        return 0; // Reemplazar con la lógica correcta.
    }

    /**
     * Retorna una representación textual del cliente natural.
     */
    @Override
    public String toString() {
        return "ClienteNatural [nombreCliente=" + nombreCliente + "]";
    }

    /**
     * Verifica si dos objetos ClienteNatural son iguales.
     * 
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales; false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClienteNatural other = (ClienteNatural) obj;
        return nombreCliente.equals(other.nombreCliente);
    }

    /**
     * Genera un código hash para el cliente natural.
     * 
     * @return El código hash del cliente.
     */
    @Override
    public int hashCode() {
        return nombreCliente.hashCode();
    }
}
