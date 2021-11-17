package Ejercicio3.Controlador;

import Ejercicio3.Modelo.Pedido;
import Ejercicio3.Modelo.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class HiloGestor implements Runnable {

    private int id;
    private GestionPedidos gp;
    private int cantidadHerramientas;
    private int cantidadLimpieza;
    private int cantidadRecambios;
    private double precioHerramientas;
    private double precioLimpieza;
    private double precioRecambios;
    private TipoProducto tipo;


    public int getId() {
        return id;
    }

    public int getCantidadHerramientas() {
        return cantidadHerramientas;
    }

    public int getCantidadLimpieza() {
        return cantidadLimpieza;
    }

    public int getCantidadRecambios() {
        return cantidadRecambios;
    }

    public double getPrecioHerramientas() {
        return precioHerramientas;
    }

    public double getPrecioLimpieza() {
        return precioLimpieza;
    }

    public double getPrecioRecambios() {
        return precioRecambios;
    }

    public HiloGestor(GestionPedidos gp, int numProc) {
        this.gp = gp;
        this.id = numProc;
        this.cantidadHerramientas = 0;
        this.cantidadRecambios =0;
        this.cantidadLimpieza = 0;
        this.precioHerramientas = 0;
        this.precioLimpieza = 0;
        this.precioRecambios = 0;
    }

    @Override
    public void run() {


        //   generamos una lista igual a la del objeto GestionPedido
        //para poder trabajar con ella más facilmente.
        //  Al dividir la cantidad total de pedidos entre el número de procesadores
        //tendremos la cantidad exacta de pedidos que tendrá que abarcar cada hilo.
        //Después lo multiplicamos por su posición dentro de la lista de pedidos para tener
        //la primera posición de la lista donde este hilo debe actuar.
        //Después solo tendremos que sumarle 1 a su id(su posición dentro del array)
        //para obtener la última posición que deberá

        List<Pedido> pedidos = gp.getPedidos();
        int cantidadPorHilo = pedidos.size()/Runtime.getRuntime().availableProcessors();
        int inicioHilo = cantidadPorHilo*(id);
        int finHilo = (cantidadPorHilo*(id+1))-1;


        for (int i = inicioHilo; i < finHilo; i++)
        {
            this.cantidadHerramientas = pedidos.get(i).cantidadTipoProducto(TipoProducto.HERRAMIENTA);
            this.cantidadLimpieza = pedidos.get(i).cantidadTipoProducto(TipoProducto.LIMPIEZA);
            this.cantidadRecambios = pedidos.get(i).cantidadTipoProducto(TipoProducto.RECAMBIO);
        }

        for (int i = inicioHilo; i < finHilo; i++)
        {
            this.precioHerramientas = Math.round(pedidos.get(i).precioTipoProducto(TipoProducto.HERRAMIENTA)*100.00)/100.00;
            this.precioRecambios = Math.round(pedidos.get(i).precioTipoProducto(TipoProducto.RECAMBIO)*100.00)/100.00;
            this.precioLimpieza = Math.round(pedidos.get(i).precioTipoProducto(TipoProducto.LIMPIEZA)*100.00)/100.00;
        }

        System.out.println("HILO NUMERO " + id + "\nCon especificaciones:");

           System.out.printf("""
                   La cantidad de herramientas es %s
                   La cantidad de productos de limpieza es %s
                   La cantidad de recambios es %s
                   El precio total de herramientas es %s
                   El precio total de productos de limpieza es %s\s
                   El precio total de productos de recambios  es %s\n""", cantidadHerramientas, cantidadLimpieza, cantidadRecambios, precioHerramientas, precioLimpieza, precioRecambios);

    }
}
