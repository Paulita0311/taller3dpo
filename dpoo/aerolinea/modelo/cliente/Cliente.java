package uniandes.dpoo.aerolinea.modelo.cliente;

public abstract class Cliente {
    protected String identificador;

    public Cliente(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente other = (Cliente) obj;
        return identificador.equals(other.identificador);
    }

    @Override
    public int hashCode() {
        return identificador.hashCode();
    }

    @Override
    public String toString() {
        return "Cliente [identificador=" + identificador + "]";
    }

    /**
     * Método abstracto que cada tipo de cliente deberá implementar.
     * Calcula cuántos tiquetes pendientes tiene el cliente.
     * @return La cantidad de tiquetes pendientes
     */
    public abstract int calcularTiquetesPendientes();

	public abstract Object getTipoCliente();
}
