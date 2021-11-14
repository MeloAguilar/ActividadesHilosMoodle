package Ejercicio1;

public class MediaHilo implements Runnable {

    private int[] numeros;
    private int inicio;
    private int fin;
    private String nombre;
    private double resultado;

    public MediaHilo(int[] numeros, String nombre) {
        this.nombre = nombre;
        this.numeros = numeros;
        this.inicio = 0;
        this.fin = numeros.length;
        this.resultado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        int suma = 0;
        for (int i = inicio; i < fin; i++) {
            suma += numeros[i];
        }

        this.resultado = (double)suma / (this.fin - this.inicio);
        System.out.println("Resultado Hilo " + this.nombre +":  "+ this.resultado);
    }

    public double getResultado() {
        return resultado;
    }
}
