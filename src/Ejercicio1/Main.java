package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int tiempo = 0;
        Scanner sc = new Scanner(System.in);
        int[][] numeros = new int[20][1000000];
        generarLista(numeros);
        List<MediaHilo> listaProcesos = generarListaProcesos(numeros);

        List<Thread> listaHilos = generarListaHilos(listaProcesos);





        System.out.println("Escribe el tiempo en milisegundos");
        tiempo = sc.nextInt();
        joinearHilos(listaHilos, tiempo);




        double media = calcularResultados(listaProcesos) / numeros.length;


        System.out.println("Media: " + media);


    }


    /**
     * Método estático que rellena un array de dos dimensiones
     * con números random entre 0 y 10000
     * @param numeros
     * */
    private static void generarLista(int[][] numeros) {
        Random numRandom = new Random();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numRandom.nextInt(10000);
            }
        }
    }

    /**
     * Método que genera una lista de MediaHilo mediante un bucle
     * del tipo foreach. Se introduce como 
     * @param numeros
     * @return
     */
    private static List<MediaHilo> generarListaProcesos(int[][] numeros) {
        List<MediaHilo> mdh = new ArrayList<>();
        int num = 1;
        for (int[] numero : numeros) {
            String nombre = "h" + num;
            mdh.add(new MediaHilo(numero, nombre));

            num++;
        }
        return mdh;
    }

    /**
     * Método que genera una lista de hilos de logitud igual a
     * la lista de los que se le asocia, en este caso una lista de
     * 'MediaHilo'
     *
     * @param listaProcesos
     * @return lista de Thread -> listaHilos
     */
    private static List<Thread> generarListaHilos(List<MediaHilo> listaProcesos) {
        List<Thread> listaHilos = new ArrayList<>();
        for (MediaHilo hilo : listaProcesos) {
            listaHilos.add(new Thread(hilo));
        }
        return listaHilos;
    }

    /**
     * Método que inicia todos los hilos de una lista de hilos dada
     * como parámetro.
     * @param lista
     */
    private static void iniciarHilos(List<Thread> lista) {
        for (Thread hilo : lista) {

        }
    }

    /**
     * Método que hace que los
     * @param lista
     * @param tiempo
     */
    private static void joinearHilos(List<Thread> lista, int tiempo) {
        for (Thread hilo : lista) {
            hilo.start();
        }
        for (Thread hilo : lista) {
            try {
                hilo.wait(tiempo);
                hilo.notifyAll();
                if(!hilo.isAlive()){
                    hilo.interrupt();

                }
            } catch (InterruptedException e) {
                System.out.println("Cálculo Cancelado");
                break;
            }
        }
    }


    /**
     * Método que, dada una lista de 'MediaHilo', tome la variable resultado
     * de cada objeto y la sume para después devolver esta suma.
     * @param lista
     * @return double -> resultado
     */
    private static double calcularResultados(List<MediaHilo> lista) {
        double resultado = 0;
        for (MediaHilo hilo : lista) {
            resultado += hilo.getResultado();
        }
        return resultado;

    }

    /**
     * Método que se encarga de mostrar los cálculos internos de cada objeto 'MediaHilo'
     * Es un simple for que muestra por pantalla el nombre del hilo y su métod getResultado().
     * @param lista
     */
    private static void mostrarCalculos(List<MediaHilo> lista) {

        for (MediaHilo hilo : lista) {
            System.out.println("El hilo " + hilo.getNombre() + " dió como resultado:  " + hilo.getResultado());
        }
    }
}
