package com.MiBingoPruebas.juego;

import java.util.Arrays;
import java.util.Random;

public class Bombo {


    public static int numerosSinRepeticion(){
        int i=0;
        Random aleatorio =new Random();
        int aleatorios[]=new int[90];
        aleatorios[i]=aleatorio.nextInt(90)+1;
        for (i=1;i<aleatorios.length;i++) {
            aleatorios[i] = aleatorio.nextInt(90) + 1;
            for (int j = 0; j < i; j++) {
                if (aleatorios[i] == aleatorios[j]) {
                    i--;
                }
            }
        }

        int numeroAleatorio=aleatorios[aleatorio.nextInt(90)];
        System.out.println("\n\n "+numeroAleatorio);
        return numeroAleatorio;

    }


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
        boolean bingo=false;
        Auxiliar matrizAuxiliarBingo = Auxiliar.getInstace();
        if (Arrays.deepEquals(matrizAuxiliarBingo.getMatrizBingo(), matrizNumerosNoLeidos)) {
            bingo=true;
            System.out.println("Bingo");
        } else
            System.out.println("Vuelve a intentarlo la proxima vez");
    }

    public static boolean comprobarLinea(int[][] matriz) {
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
        return linea;

    }
}