
package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;




public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

    private static final int COSTO_POR_KM = 1000;

    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        return costoBase + valorImpuestos;
    }

    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        return distancia * COSTO_POR_KM;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        return 0; // En temporada alta no se aplican descuentos
    }
}