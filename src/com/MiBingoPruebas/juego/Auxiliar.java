package com.MiBingoPruebas.juego;

public class Auxiliar {

    private final int[][] matrizBingo = {{1, 1, 1, 1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 1}};
    private int[][]matrizNulos=new int[3][9];
    private static Auxiliar instance = null;

    public Auxiliar() {

    }


    public static Auxiliar getInstace() {
        if (instance==null){
            instance=new Auxiliar();

        }
            return instance;

    }

    public int[][] getMatrizBingo() {
        return matrizBingo;
    }
}
