package Ejercicio3.Vista;

import Ejercicio3.Controlador.GestionPedidos;
import Ejercicio3.Controlador.HiloGestor;
import Ejercicio3.Modelo.Pedido;
import Ejercicio3.Modelo.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int cantidadHerramientas = 0;
        int cantidadLimpieza = 0;
        int cantidadRecambios = 0;
        double precioHerramientas = 0;
        double precioLimpieza = 0;
        double precioRecambios = 0;

        List<HiloGestor> hilosGestores = new ArrayList<>();
        List<Thread> hilos = new ArrayList<>();
        GestionPedidos gp = new GestionPedidos();
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            hilosGestores.add(new HiloGestor(gp, i));
            hilos.add(new Thread(hilosGestores.get(i)));
        }




        for (Thread hilo : hilos) {
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }

        for (HiloGestor hilo: hilosGestores)
        {

            cantidadHerramientas += hilo.getCantidadHerramientas();
            cantidadLimpieza += hilo.getCantidadLimpieza();
            cantidadRecambios += hilo.getCantidadRecambios();

            precioHerramientas += hilo.getPrecioHerramientas();
            precioLimpieza += hilo.getPrecioLimpieza();
            precioRecambios += hilo.getPrecioRecambios();

        }


        System.out.println("\nVENTAS Y ANTIDADES DEL HILO PRINCIPAL\n");
        System.out.printf("La cantidad de herramientas es %s\n" +
                "La cantidad de productos de limpieza es %s\n" +
                "La cantidad de recambios es %s\n" +
                "El precio total de herramientas es %s\n" +
                "El precio total de productos de limpieza es %s \n" +
                "El precio total de productos de recambios  es %s",cantidadHerramientas, cantidadLimpieza, cantidadRecambios,  Math.round(precioHerramientas*100.00)/100.00, Math.round(precioLimpieza*100.00)/100.00, Math.round(precioRecambios*100.00)/100.00);

        /**
         * Aqui necesitamos algo que haga que se repartan los pedidos entre los
         * procesadores del sistema. Se que la llamada al metodo es Runtime.getRuntime().availableProcessors()
         * pero no se como coño hacer para repartir esas tareas
         */

        //todo tienes que generar un metodo run pedazo de inutil
        //todo Donde meter el método run
        //todo En gestionCantidades y GestionPrecios se debe meter el runnable


    }

}
/**
 * Pedido ped = new Pedido();
 * System.out.println("Precio de la cantidad total de Herramientas: " + ped.precioTipoProducto(TipoProducto.HERRAMIENTA));
 * System.out.println("Precio de la cantidad total de Recambios: " + ped.precioTipoProducto(TipoProducto.RECAMBIO));
 * System.out.println("Precio de la cantidad total de Limpieza: " + ped.precioTipoProducto(TipoProducto.LIMPIEZA));
 * <p>
 * <p>
 * System.out.println("Cantidad total de Herramientas: " + ped.cantidadTipoProducto(TipoProducto.HERRAMIENTA));
 * System.out.println("Cantidad total de Recambios: " + ped.cantidadTipoProducto(TipoProducto.RECAMBIO));
 * System.out.println("Cantidad total de Limpieza: " + ped.cantidadTipoProducto(TipoProducto.LIMPIEZA));
 */