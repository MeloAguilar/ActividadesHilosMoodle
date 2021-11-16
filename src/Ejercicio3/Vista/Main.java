package Ejercicio3.Vista;

import Ejercicio3.Controlador.GestionPedidos;
import Ejercicio3.Modelo.Pedido;
import Ejercicio3.Modelo.TipoProducto;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GestionPedidos gp = new GestionPedidos();

        List<Pedido> pedidos = gp.getPedidos();

        int parteACadaHilo = pedidos.size()/Runtime.getRuntime().availableProcessors();
        int hilos = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < pedidos.size(); i++) {





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