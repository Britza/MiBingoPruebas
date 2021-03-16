package com.MiBingoPruebas.juego;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bombo {

    //No se pueden repetir hay que solucionarlo
    public static int generarNumeroAleatorio() {
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(91) + 1;
        System.out.println("\n\n " + num);
        return num;
    }


  /*  public static void generarNumeroAleatorio() {
        int aleatorio;
        Random rnd = new Random();
        Set<Integer> generados = new HashSet<>();
        for (int i = 1; i <= 90; i++) {
            aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int posible = rnd.nextInt();
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    aleatorio = posible;
                    generado = true;
                }
            }
            //usa el v
        }

   */


    public static void comprobarNumeroBombo(int num, int[][] carton, int[][] matrizNumerosNoLidos) {
        boolean atopado = false;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (num == carton[i][j]) {
                    atopado = true;
                    System.out.println("Atopado");
                    matrizNumerosNoLidos[i][j] = 1;
                    // return atopado;
                }
            }
        }
        if (!atopado) {
            System.out.println("\nO numero non está no arrai");
        }
    }

    public static void comprobarBingo(int[][] matrizNumerosNoLeidos) {
        Auxiliar matrizAuxiliarBingo = Auxiliar.getInstace();
        if (Arrays.deepEquals(matrizAuxiliarBingo.getMatrizBingo(), matrizNumerosNoLeidos)) {
            System.out.println("Bingo");
        } else
            System.out.println("Vuelve a intentarlo la proxima vez");
    }

    public static void comprobarLinea(int[][] matriz) {
        int cont = 0;
        boolean linea = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    cont++;
                    if (cont == 5) {
                        linea = true;
                    }
                }
            }
            System.out.println(cont);
            cont = 0;

        }
        if (linea == true) {
            System.out.println("LINEA");
        } else
            System.out.println("Sigue intentandolo");

    }
}