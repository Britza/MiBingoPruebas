package com.MiBingoPruebas.juego;

public class Auxiliar {

    private int[][] matrizNumerosNoLidos = new int[3][9];

    private static Auxiliar instance = null;

    /**
     * Constructor sin parametros de la clase Auxiliar
     */
    public Auxiliar() {

    }

    /**
     * Método que comprueba si se ha instanciado un Auxiliar, si se ha instanciado se devuelve la instancia y si no se crea
     *
     * @return devuelve la instancia del Auxiliar
     */

    public static Auxiliar getInstace() {
        if (instance == null) {
            instance = new Auxiliar();

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
