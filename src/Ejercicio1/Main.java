package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[][] numeros = new int[20][1000000];
        numeros = generarLista(numeros);
        List<MediaHilo> listaProcesos = new ArrayList<MediaHilo>();
        listaProcesos = generarListaProcesos(numeros);

        List<Thread> listaHilos = generarListaHilos(listaProcesos);

        iniciarHilos(listaHilos);

        joinearHilos(listaHilos, 5000);


        mostrarCalculos(listaProcesos);


        double media = calcularResultados(listaProcesos) / numeros.length;

        System.out.println("Media: " + media);


    }

    private static int[][] generarLista(int[][] numeros) {
        Random numRandom = new Random();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = numRandom.nextInt(10000);
            }

        }
        return numeros;
    }

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

    private static List<Thread> generarListaHilos(List<MediaHilo> listaProcesos) {
        List<Thread> listaHilos = new ArrayList<>();
        for (MediaHilo hilo : listaProcesos) {
            listaHilos.add(new Thread(hilo));
        }
        return listaHilos;
    }


    private static void iniciarHilos(List<Thread> lista) {
        for (Thread hilo : lista) {
            hilo.start();
        }
    }

    private static void joinearHilos(List<Thread> lista, int tiempo) {
        for (Thread hilo : lista) {
            try {
                hilo.join(tiempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static double calcularResultados(List<MediaHilo> lista) {
        double resultado = 0;
        for (MediaHilo hilo : lista) {
            resultado += hilo.getResultado();
        }
        return resultado;

    }

    private static void mostrarCalculos(List<MediaHilo> lista) {

        for (MediaHilo hilo : lista) {
            System.out.println("El hilo " + hilo.getNombre() + " dió como resultado:  " + hilo.getResultado());
        }
    }
}
