package com.MiBingoPruebas.juego;

public class Auxiliar {

    private final int[][] matrizBingo = {{0, 1, 0, 1, 1, 0, 1, 0, 1},{0, 1, 1, 0, 1, 1, 0, 1, 0}, {1, 0, 1, 0, 0, 1, 0, 1, 1}};
    private int[][]matrizNumerosNoLidos=new int[3][9];
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

    public int[][] getMatrizNumerosNoLidos() {
        return matrizNumerosNoLidos;
    }

    public void setMatrizNumerosNoLidos(int[][] matrizNumerosNoLidos) {
        this.matrizNumerosNoLidos = matrizNumerosNoLidos;
    }
}
