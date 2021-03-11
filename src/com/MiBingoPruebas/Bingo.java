package com.MiBingoPruebas;

public class Bingo {

    public static void main(String[] args) {
        int bombo=0;
        int[][] carton=new int[3][9];

        Carton.generarCarton(carton);
        bombo=Carton.nulos(carton);
        Carton.imprimirCarton(carton);




       // Carton.visualizarPila();

    }

}
