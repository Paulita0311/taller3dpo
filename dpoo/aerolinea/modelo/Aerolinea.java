package uniandes.dpoo.aerolinea.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.IPersistenciaAerolinea;
import uniandes.dpoo.aerolinea.persistencia.IPersistenciaTiquetes;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;

/**
 * En esta clase se organizan todos los aspectos relacionados con una Aerolínea.
 */
public class Aerolinea
{
    private List<Avion> aviones;
    private Map<String, Ruta> rutas;
    private List<Vuelo> vuelos;
    private Map<String, Cliente> clientes;

    public Aerolinea() {
        aviones = new LinkedList<Avion>();
        rutas = new HashMap<String, Ruta>();
        vuelos = new LinkedList<Vuelo>();
        clientes = new HashMap<String, Cliente>();
    }

    public void agregarRuta(Ruta ruta) {
        this.rutas.put(ruta.getCodigoRuta(), ruta);
    }

    public void agregarAvion(Avion avion) {
        this.aviones.add(avion);
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.put(cliente.getIdentificador(), cliente);
    }

    public boolean existeCliente(String identificadorCliente) {
        return this.clientes.containsKey(identificadorCliente);
    }

    public Cliente getCliente(String identificadorCliente) {
        return this.clientes.get(identificadorCliente);
    }

    public Collection<Avion> getAviones() {
        return aviones;
    }

    public Collection<Ruta> getRutas() {
        return rutas.values();
    }

    public Ruta getRuta(String codigoRuta) {
        return rutas.get(codigoRuta);
    }

    public Collection<Vuelo> getVuelos() {
        return vuelos;
    }

    public Vuelo getVuelo(String codigoRuta, String fechaVuelo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getRuta().getCodigoRuta().equals(codigoRuta) && vuelo.getFecha().equals(fechaVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public Collection<Cliente> getClientes() {
        return clientes.values();
    }

    public Collection<Tiquete> getTiquetes() {
        List<Tiquete> todosLosTiquetes = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            todosLosTiquetes.addAll(vuelo.getTiquetes());
        }
        return todosLosTiquetes;
    }

    public void cargarAerolinea(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException, InformacionInconsistenteException {
        IPersistenciaAerolinea cargador = CentralPersistencia.getPersistenciaAerolinea(tipoArchivo);
        cargador.cargarAerolinea(archivo, this);
    }

    public void salvarAerolinea(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException {
        IPersistenciaAerolinea cargador = CentralPersistencia.getPersistenciaAerolinea(tipoArchivo);
        cargador.salvarAerolinea(archivo, this);
    }

    public void cargarTiquetes(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException, InformacionInconsistenteException {
        IPersistenciaTiquetes cargador = CentralPersistencia.getPersistenciaTiquetes(tipoArchivo);
        cargador.cargarTiquetes(archivo, this);
    }

    public void salvarTiquetes(String archivo, String tipoArchivo) throws TipoInvalidoException, IOException {
        IPersistenciaTiquetes cargador = CentralPersistencia.getPersistenciaTiquetes(tipoArchivo);
        cargador.salvarTiquetes(archivo, this);
    }

    public void programarVuelo(String fecha, String codigoRuta, String nombreAvion) throws Exception {
        Avion avion = null;
        for (Avion a : aviones) {
            if (a.getNombre().equals(nombreAvion)) {
                avion = a;
                break;
            }
        }
        if (avion == null) {
            throw new Exception("El avión no existe.");
        }

        Ruta ruta = rutas.get(codigoRuta);
        if (ruta == null) {
            throw new Exception("La ruta no existe.");
        }

        for (Vuelo vuelo : vuelos) {
            if (vuelo.getAvion().equals(avion) && vuelo.getFecha().equals(fecha)) {
                throw new Exception("El avión ya está ocupado para esa fecha.");
            }
        }

        Vuelo nuevoVuelo = new Vuelo(ruta, fecha, avion);
        vuelos.add(nuevoVuelo);
    }

    public int venderTiquetes(String identificadorCliente, String fecha, String codigoRuta, int cantidad) throws VueloSobrevendidoException, Exception {
        Vuelo vuelo = getVuelo(codigoRuta, fecha);
        if (vuelo == null) {
            throw new Exception("El vuelo no existe.");
        }

        Cliente cliente = getCliente(identificadorCliente);
        if (cliente == null) {
            throw new Exception("El cliente no existe.");
        }

        if (vuelo.getAsientosDisponibles() < cantidad) {
            throw new VueloSobrevendidoException(vuelo);
        }

        int total = vuelo.venderTiquetes(cliente, cantidad);
        return total;
    }

    public void registrarVueloRealizado(String fecha, String codigoRuta) {
        Vuelo vuelo = getVuelo(codigoRuta, fecha);
        if (vuelo != null) {
            vuelo.registrarRealizacion();
        }
    }

    public String consultarSaldoPendienteCliente(String identificadorCliente) {
        Cliente cliente = getCliente(identificadorCliente);
        if (cliente != null) {
            return String.valueOf(cliente.calcularTiquetesPendientes());
        }
        return "0";
    }
}

   