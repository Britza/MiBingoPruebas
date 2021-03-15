package com.MiBingoPruebas;

public class Bingo {

    public static void main(String[] args) {
        int[][][]carton=new int[3][9][1];
        int [][][]matrizNumerosNoLidos=new int[3][9][1];
        Carton.generarCarton(carton);
        Carton.bombos(carton);
        Carton.imprimirCarton(carton);
        /*
        System.out.println("\n");
        Carton.matrizNumerosNoLeidos(matrizNumerosNoLidos);
        System.out.println("\n");
        Bombo.comprobarNumeroBombo(Bombo.generarNumeroAleatorio(),carton,matrizNumerosNoLidos);
        System.out.println("\n");
        Carton.imprimirCarton(matrizNumerosNoLidos);
        */
        System.out.println();

    }

}
