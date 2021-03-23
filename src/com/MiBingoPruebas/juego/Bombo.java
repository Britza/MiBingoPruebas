package com.MiBingoPruebas.juego;

import com.MiBingoPruebas.cartera.Cartera;
import metodos.Metodos;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Bombo {

    /**
     * Método que crea un  número aleatorio del 1 al 90 y si no estan en la coleccion de numerosyutilizados
     * lo añade
     *
     * @return devuelve un numero aleatorio.
     */

    public static int numerosSinRepeticion(){
        Random random=new Random();
        int numAleatorio = 0;
        //Conjunto de números ya utilizados
        Set<Integer> numerosUtilizados=new HashSet<>();
        //Vamos a   generar numeros aleatorios 20
        while (numerosUtilizados.size()<90){
            //Vamos a generar un numero entre el 1 y el 90
            numAleatorio= random.nextInt(90)+1;
            if (!numerosUtilizados.contains(numAleatorio)){
                // System.out.println(numAleatorio);
                numerosUtilizados.add(numAleatorio);
            }
        }
        return numAleatorio;
    }

    /**
     * Método que recibe como parametros un número sacado por el bombo , el carton y una matriz auxiliar. Si el número
     * recibido se encuentra en el carton, la matriz auxiliar pone un uno en la posición en la que se encuentra el número
     * sacado en el cartón.
     *
     * @param num                  número recibido del bombo
     * @param carton               matriz carton, carton del jugador
     * @param matrizNumerosNoLidos matriz auxiliar complementaria al cartón
     */

    public static boolean comprobarNumeroBombo(int num, int[][] carton, int[][] matrizNumerosNoLidos) {
        boolean atopado = false;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (num == carton[i][j]) {
                    atopado = true;
                    //System.out.println(num+"\nAtopado");
                    matrizNumerosNoLidos[i][j] = 1;
                    // return atopado;
                }
            }
        }
        return atopado;
    }

    /**
     * Método que comprubea si se ha cantado bingo
     *
     * @param matriz se recibe la matriz auxiliar
     * @return devuelve true si se ha cantado bingo y false si no se ha cantado.Se cuentan el total de unos que  hay en la matriz auxiliar
     */
    public static boolean comprobarBingo(int[][] matriz) {
        int cont = 0;
        boolean bingo = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    cont++;
                    if (cont == 15) {
                        bingo = true;
                    }
                }
            }
        }
        /*if (bingo) {
            System.out.println("\n Bingo");
        } else {
            System.out.println("\n Sigue intentandolo");
        }*/
        return bingo;
    }

    /**
     * Método que sirve para saber si se ha cantado linea. Se cuentan la cantidad de unos que hay en la matriz auxiliar por fila
     *
     * @param matriz se recibe la matriz auxiliar
     * @return devuelve true si se ha cantado linea y false si no se ha cantado linea.
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
            cont = 0;
        }
        /*if (linea) {
            System.out.println("\n LINEA");
        } else
            System.out.println("\n Sigue intentandolo");*/
        return linea;

    }

    /**
     * Método que permite elegir la opción de juego deseada (comprar carton, cantar linea...)
     *
     * @param num el número recibido se extrae de la opción elegida por el jugador
     */

}
