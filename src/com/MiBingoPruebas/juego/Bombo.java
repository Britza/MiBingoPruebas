package com.MiBingoPruebas.juego;

import com.MiBingoPruebas.cartera.Cartera;

import java.util.Arrays;
import java.util.Random;

public class Bombo {
    /**
     * Método que crea un array de números aleatorios del 1 al 90
     * @return devuelve el número
     */

    public static int numerosSinRepeticion() {
        int i = 0;
        Random aleatorio = new Random();
        int aleatorios[] = new int[90];
        aleatorios[i] = aleatorio.nextInt(90) + 1;
        for (i = 1; i < aleatorios.length; i++) {
            aleatorios[i] = aleatorio.nextInt(90) + 1;
            for (int j = 0; j < i; j++) {
                if (aleatorios[i] == aleatorios[j]) {
                    i--;
                }
            }
        }

        int numeroAleatorio = aleatorios[aleatorio.nextInt(90)];
        System.out.println("\n\n " + numeroAleatorio);
        return numeroAleatorio;

    }

    /**
     * Método que recibe como parametros un número sacado por el bombo , el carton y una matriz auxiliar. Si el número
     * recibido se encuentra en el carton, la matriz auxiliar pone un uno en la posición en la que se encuentra el número
     * sacado en el cartón.
     * @param num número recibido del bombo
     * @param carton matriz carton, carton del jugador
     * @param matrizNumerosNoLidos matriz auxiliar complementaria al cartón
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

    /**
     * Método que comprubea si se ha cantado bingo
     * @param matriz
     * @return devuelve true si se ha cantado bingo y false si no se ha cantado.Se cuentan el total de unos que  hay en la matriz auxiliar
     */
    public static boolean comprobarBingo(int [][] matriz) {
        int cont = 0;
        boolean bingo=false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    cont++;
                    if (cont == 15) {
                        bingo = true;
                    }
                }
            }
            System.out.println(cont);

        }
        if (bingo) {
            System.out.println("Bingo");
        } else {
            System.out.println("Sigue intentandolo");
        }
        return bingo;
    }

    /**
     * Método que sirve para saber si se ha cantado linea. Se cuentan la cantidad de unos que hay en la matriz auxiliar por fila
     * @param matriz
     * @return
     */
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
        if (linea) {
            System.out.println("LINEA");
        } else
            System.out.println("Sigue intentandolo");
        return linea;

    }

    /**
     * Método que permite elegir la opción de juego deseada (comprar carton, cantar linea...)
     * @param num el número recibido se extrae de la opción elegida por el jugador
     */
    public static void jugar(int num) {
        Carton carton = Carton.getInstace();
        Auxiliar matrizNumerosNoLidos = Auxiliar.getInstace();

        switch (num) {
            case 1:
                Carton.comprarCarton();
                System.out.println("\nPuntuacion Inicial");
                break;
            case 2:
                //Si no se ha comprado un carton hay que tratarlo
                int num1 = numerosSinRepeticion();
                Bombo.comprobarNumeroBombo(num1, carton.getCarton(), matrizNumerosNoLidos.getMatrizNumerosNoLidos());

                break;

            case 3:
                boolean linea=Bombo.comprobarLinea(matrizNumerosNoLidos.getMatrizNumerosNoLidos());
                Cartera.añadir("miViejaEnBragas",linea);
                if (linea==true) {
                    Cartera.lerFicheiro("miViejaEnBragas");
                }
                break;
            case 4:
                boolean bingo= Bombo.comprobarBingo(matrizNumerosNoLidos.getMatrizNumerosNoLidos());
                Cartera.añadirBingo("MiviejaEnBragas",bingo);

                break;
            case 5:

                Carton.imprimirCarton(matrizNumerosNoLidos.getMatrizNumerosNoLidos());


                break;

            case 6:
                System.exit(0);
        }
    }
}
