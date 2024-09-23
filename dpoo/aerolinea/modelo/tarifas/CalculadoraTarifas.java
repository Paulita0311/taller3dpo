package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta es una clase abstracta encargada de calcular cuánto se le debe cobrar a un cliente
 * particular para un vuelo particular.
 */
public abstract class CalculadoraTarifas {

    // Impuesto aplicable al costo base
    public static final double IMPUESTO = 0.28;

    /**
     * Calcula la tarifa total que se le debe cobrar a un cliente para un vuelo particular,
     * incluyendo el costo base, los impuestos y cualquier descuento aplicable.
     * 
     * @param vuelo El vuelo para el cual se debe calcular la tarifa.
     * @param cliente El cliente que está comprando el tiquete.
     * @return El valor total de la tarifa para ese cliente en ese vuelo.
     */
    public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula el costo base del vuelo para un cliente particular.
     * 
     * @param vuelo El vuelo para el cual se está calculando el costo.
     * @param cliente El cliente que está comprando el tiquete.
     * @return El costo base del vuelo sin incluir impuestos o descuentos.
     */
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula el porcentaje de descuento que se debe aplicar para el cliente.
     * El descuento dependerá del tipo de cliente.
     * 
     * @param cliente El cliente para quien se calcula el descuento.
     * @return El porcentaje de descuento aplicable.
     */
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula la distancia en kilómetros entre los aeropuertos de origen y destino
     * de una ruta particular.
     * 
     * @param ruta La ruta del vuelo.
     * @return La distancia en kilómetros.
     */
    protected int calcularDistanciaVuelo(Ruta ruta) {
        return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
    }

    /**
     * Calcula el valor de los impuestos que se deben aplicar a un costo base.
     * 
     * @param costoBase El costo base del vuelo.
     * @return El valor de los impuestos.
     */
    protected int calcularValorImpuestos(int costoBase) {
        return (int) Math.round(costoBase * IMPUESTO);
    }
}
