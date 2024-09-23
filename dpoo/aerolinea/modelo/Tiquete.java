package uniandes.dpoo.aerolinea.modelo;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {

    private String codigo;
    private Vuelo vuelo;
    private Cliente cliente;
    private int tarifa;
    private boolean usado;

    /**
     * Constructor de la clase Tiquete.
     * @param codigo El código único del tiquete.
     * @param vuelo El vuelo asociado al tiquete.
     * @param cliente El cliente que compró el tiquete.
     * @param tarifa El valor de la tarifa pagada por el cliente.
     */
    public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.usado = false; // Inicialmente, el tiquete no está usado.
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getTarifa() {
        return tarifa;
    }

    public boolean esUsado() {
        return usado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Marca el tiquete como usado.
     */
    public void marcarComoUsado() {
        this.usado = true;
    }

    /**
     * Sobrescribe el método toString para imprimir la información del tiquete.
     */
    @Override
    public String toString() {
        return "Tiquete [codigo=" + codigo + ", vuelo=" + vuelo + ", cliente=" + cliente.getIdentificador() 
                + ", tarifa=" + tarifa + ", usado=" + usado + "]";
    }

    /**
     * Sobrescribe el método equals para comparar tiquetes por su código.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tiquete other = (Tiquete) obj;
        return codigo.equals(other.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
