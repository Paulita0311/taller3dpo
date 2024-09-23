package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas.
 */
public class ClienteCorporativo extends Cliente {

    /**
     * Nombre de la empresa.
     */
    private String nombreEmpresa;

    /**
     * Tamaño de la empresa (medido en número de empleados o algún otro criterio relevante).
     */
    private int tamanoEmpresa;

    /**
     * Constantes que representan los tipos de clientes corporativos por tamaño.
     */
    public static final String CORPORATIVO = "Corporativo";
    public static final int GRANDE = 1;
    public static final int MEDIANA = 2;
    public static final int PEQUENA = 3;

    /**
     * Constructor de la clase ClienteCorporativo.
     * 
     * @param nombreEmpresa El nombre de la empresa.
     * @param tamanoEmpresa El tamaño de la empresa (puede ser una constante GRANDE, MEDIANA o PEQUENA).
     */
    public ClienteCorporativo(String nombreEmpresa, int tamanoEmpresa) {
        super(CORPORATIVO); // Llamada al constructor de la clase Cliente con el tipo "Corporativo".
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamanoEmpresa;
    }

    /**
     * Retorna el nombre de la empresa.
     * 
     * @return El nombre de la empresa.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Retorna el tamaño de la empresa.
     * 
     * @return El tamaño de la empresa (GRANDE, MEDIANA o PEQUENA).
     */
    public int getTamanoEmpresa() {
        return tamanoEmpresa;
    }

    /**
     * Implementación del método abstracto que calcula los tiquetes pendientes.
     * La lógica puede variar según el número de tiquetes comprados o alguna otra regla.
     * 
     * @return El número de tiquetes pendientes para este cliente corporativo.
     */
    @Override
    public int calcularTiquetesPendientes() {
        // Aquí debe ir la lógica para calcular los tiquetes pendientes.
        // Por ejemplo, se puede usar una lista de tiquetes asociados a este cliente.
        // Para este ejemplo, devolveremos un valor ficticio.
        return 0; // Reemplazar con la lógica correcta.
    }

    /**
     * Crea un nuevo objeto de tipo ClienteCorporativo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * 
     * @param cliente El objeto JSON que contiene la información.
     * @return El nuevo objeto inicializado con la información.
     */
    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tamanoEmpresa = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tamanoEmpresa);
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo.
     * 
     * @return El objeto JSON con toda la información del cliente corporativo.
     */
    public JSONObject salvarEnJSON() {
        JSONObject jobject = new JSONObject();
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        jobject.put("tipo", CORPORATIVO);
        return jobject;
    }

    @Override
    public String toString() {
        return "ClienteCorporativo [nombreEmpresa=" + nombreEmpresa + ", tamanoEmpresa=" + tamanoEmpresa + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClienteCorporativo other = (ClienteCorporativo) obj;
        return nombreEmpresa.equals(other.nombreEmpresa) && tamanoEmpresa == other.tamanoEmpresa;
    }

    @Override
    public int hashCode() {
        return nombreEmpresa.hashCode() + tamanoEmpresa;
    }
}

