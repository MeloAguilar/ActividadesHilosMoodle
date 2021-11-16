package Ejercicio3.Controlador;

import Ejercicio3.Modelo.Pedido;
import Ejercicio3.Modelo.Producto;
import Ejercicio3.Modelo.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class GestionPedidos{
    List<Pedido> pedidos = new ArrayList<>();


    public GestionPedidos() {
        generarListapedidos();
    }

    public List<Pedido> getPedidos()
    {
        return pedidos;
    }

    private void generarListapedidos()
    {
        for (int i = 0; i < 100000; i++)
        {
            this.pedidos.add(new Pedido());
        }
    }



}