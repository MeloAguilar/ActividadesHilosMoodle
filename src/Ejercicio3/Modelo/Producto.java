package Ejercicio3.Modelo;

public class Producto {

    private TipoProducto tipo;
    private double precio;
    private int cantidad;


    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad() {
        this.cantidad = (int) (Math.random() * 50);
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio() {
        if (this.getTipo() == TipoProducto.HERRAMIENTA) {
            this.precio = (Math.random() * 130) + 4.5;
        } else if (this.getTipo() == TipoProducto.RECAMBIO) {
            this.precio = (Math.random() * 28.9) + 2;
        } else if (this.getTipo() == TipoProducto.LIMPIEZA) {
            this.precio = (Math.random() * 14.5) + 0.45;
        }
        this.precio = Math.round(this.precio*100.00)/100.00;
    }

    public Producto(TipoProducto tipo) {
        this.tipo = tipo;
        setPrecio();
        setCantidad();
    }

    @Override
    public String toString() {
        return "Producto{" + "\n" +
                "tipo = " + tipo +
                ", precio = " + precio +
                ", cantidad = " + cantidad + "\n" +
                '}';
    }
}



