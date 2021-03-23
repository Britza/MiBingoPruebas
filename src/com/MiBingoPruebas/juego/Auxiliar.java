package com.MiBingoPruebas.juego;

public class Auxiliar {

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

    public int[][] getMatrizNumerosNoLidos() {
        return matrizNumerosNoLidos;
    }

    public void setMatrizNumerosNoLidos(int[][] matrizNumerosNoLidos) {
        this.matrizNumerosNoLidos = matrizNumerosNoLidos;
    }
}
