package com.MiBingoPruebas.juego;

import javax.swing.*;

public class Bingo {

    public static void main(String[] args) {
        int[][]carton = new int[3][9];
        System.out.println("BINGO");
        int[][] matrizNumerosNoLidos = new int[3][9];

        String opcion;


        do {
            opcion = JOptionPane.showInputDialog("***Menu***\n1.Comprar cartón\n2.Empezar la partida\n3.Cantar linea\n4.Cantar Bingo\n5.Comprobaciones\n6.Salir");
            switch (opcion) {
                case "1":
                    Carton.imprimirCarton(matrizNumerosNoLidos);
                    System.out.println("\n");
                    Carton.generarCarton(carton);
                    Carton.bombos(carton);
                    Carton.imprimirCarton(carton);
                    break;
                case "2":
                    //Si no se ha comprado un carton hay que tratarlo
                    Bombo.comprobarNumeroBombo(Bombo.generarNumeroAleatorio(), carton, matrizNumerosNoLidos);
                    break;
                case "3":
                    Bombo.comprobarLinea(matrizNumerosNoLidos);
                    break;
                case "4":
                    System.out.println("\n");
                    Bombo.comprobarBingo(matrizNumerosNoLidos);
                    break;
                case "5":
                    System.out.println("\n");
                    Carton.imprimirCarton(matrizNumerosNoLidos);
                    break;
                case "6":
                    System.exit(0);
            }
        } while (!opcion.equalsIgnoreCase("6"));

    }


}

