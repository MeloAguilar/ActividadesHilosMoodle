package Ejercicio3.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
        generarListaProductos();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    private void generarListaProductos() {
        int cantidadProductos = (int) ((Math.random() * 25)+1);
        int tipo;
        for (int i = 0; i < cantidadProductos; i++) {
            tipo = (int) (Math.random() * 3) + 1;
            switch (tipo) {
                case 1 -> {
                    productos.add(new Producto(TipoProducto.HERRAMIENTA));
                }
                case 2 -> {
                    productos.add(new Producto(TipoProducto.RECAMBIO));
                }
                case 3 -> {
                    productos.add(new Producto(TipoProducto.LIMPIEZA));
                }
            }
        }
    }


    public double precioTipoProducto(TipoProducto tipo) {
        double precio = 0;
        for (Producto p : productos) {
            if (p.getTipo() == tipo) {
                double precioTotalProd = p.getCantidad() * p.getPrecio();
                precio += precioTotalProd;

            }
        }
        return Math.round(precio * 100.00) / 100.00;
    }

    public int cantidadTipoProducto(TipoProducto tipo) {
        int cantidad = 0;
        for (Producto p : productos) {
            if(p.getTipo() == tipo){
                cantidad += p.getCantidad();
            }
        }
        return cantidad;
    }


}
