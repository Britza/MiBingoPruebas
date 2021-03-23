package com.MiBingoPruebas.juego;

import java.util.Random;
import metodos.Metodos;

public class Carton {


    private static int[][] carton = new int[3][9];
    private static Carton instance = null;

    public Carton() {
    }

    public static Carton getInstace() {
        if (instance == null) {
            instance = new Carton();

        }
        return instance;

    }

    public static int[][] getCarton() {
        return carton;
    }

    public static void setCarton(int[][] carton) {
        Carton.carton = carton;
    }

    public static void generarCarton(int[][] carton) {
        int k = 0;
        Random aleatorio = new Random();
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        carton[i][j] = aleatorio.nextInt(7) + 1; // La priemra columna tendra siempre números del 0 al 9
                    } else {
                        carton[i][j] = aleatorio.nextInt(8) + (10 * j); // El resto de columnas tienen números que van desde j*10+un número aleatorio del 1 al 9 ejemplo columna cuatro del 40 al 49
                    }
                } else {
                    if (i == 1) {
                        k = 0;
                    } else {
                        if (i == 2) {
                            k = 1;
                        }
                    }
                    carton[i][j] = aleatorio.nextInt(9 + k) + (10 * j);
                    do {
                        carton[i][j] = aleatorio.nextInt(9 + k) + (10 * j);
                    } while (carton[i][j] <= carton[i - 1][j]);

                }
            }
            carton[2][8]++;
        }
    }

    public static int bombos(int[][] carton) {
        //ponemos la posicion del bombo en 0
        int bombo = 0;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                carton[0][0] = bombo;
                carton[1][0] = bombo;
                carton[2][1] = bombo;
                carton[0][2] = bombo;
                carton[1][3] = bombo;
                carton[2][3] = bombo;
                carton[2][4] = bombo;
                carton[0][5] = bombo;
                carton[1][6] = bombo;
                carton[2][6] = bombo;
                carton[0][7] = bombo;
                carton[1][8] = bombo;
            }
        }
        return bombo;
    }


    public static void comprarCarton() {
        Carton carton = Carton.getInstace();
        Auxiliar matrizNumerosNoLidos = Auxiliar.getInstace();
        Carton.generarCarton(carton.getCarton());
        Carton.bombos(carton.getCarton());
        setCarton(carton.getCarton());
        Metodos.visualizar(carton.getCarton());

    }

}



