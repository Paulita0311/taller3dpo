package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {

    private static final int COSTO_POR_KM_NATURAL = 600;
    private static final int COSTO_POR_KM_CORPORATIVO = 900;
    private static final double DESCUENTO_PEQUENA = 0.02;
    private static final double DESCUENTO_MEDIANA = 0.1;
    private static final double DESCUENTO_GRANDE = 0.2;

    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);
        return (int) Math.round(costoBase * (1 - descuento) + valorImpuestos);
    }


    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        if (cliente instanceof ClienteNatural) {
            return distancia * COSTO_POR_KM_NATURAL;
        } else if (cliente instanceof ClienteCorporativo) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        }
        return 0;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
            switch (clienteCorporativo.getTamanoEmpresa()) {
                case ClienteCorporativo.PEQUENA:
                    return DESCUENTO_PEQUENA;
                case ClienteCorporativo.MEDIANA:
                    return DESCUENTO_MEDIANA;
                case ClienteCorporativo.GRANDE:
                    return DESCUENTO_GRANDE;
                default:
                    return 0;
            }
        }
        return 0; // Los clientes naturales no tienen descuento
    }
}