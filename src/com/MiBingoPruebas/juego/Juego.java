package com.MiBingoPruebas.juego;

import com.MiBingoPruebas.cartera.Cartera;
import metodos.Metodos;

import javax.swing.*;

import static com.MiBingoPruebas.juego.Bombo.numerosSinRepeticion;

public class Juego {

    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    static Carton carton = Carton.getInstace();
    static Auxiliar matrizAuxiliar = Auxiliar.getInstace();
    private static String nombreJugador;
    static int numALeatorio;
    static         int cont = 0;


    /**
     * Método que permite elegir la opción de juego deseada (comprar carton, cantar linea...)
     *
     * @param num número que recibe de la clase Bingo que le indica que opción debe ejecutra
     */
    public static void jugar(int num) {
        Cartera.escribirNombre("Recuento", nombreJugador);
        numALeatorio = numerosSinRepeticion();
        switch (num) {

            case 1:
                nombreJugador = JOptionPane.showInputDialog("Nombre del jugador : ");
                Carton.comprarCarton();
                System.out.println("\n\n");
                break;
            case 2:

                boolean atopado = Bombo.comprobarNumeroBombo(numALeatorio, carton.getCarton(), matrizAuxiliar.getMatrizNumerosNoLidos());
                cont++;
                boolean linea = Bombo.comprobarLinea(matrizAuxiliar.getMatrizNumerosNoLidos());
                boolean bingo = Bombo.comprobarBingo(matrizAuxiliar.getMatrizNumerosNoLidos());

                if (atopado == true) {
                    System.out.print(" " + ANSI_PURPLE + numALeatorio + ANSI_RESET);

                } else {
                    System.out.printf("%3d", numALeatorio);
                }
                if (linea == false && bingo == false && cont==50) {
                    System.out.println("\nMala suerte, otra vez será");
                    System.exit(0);
                }
                break;
            case 3:
                boolean linea1 = Bombo.comprobarLinea(matrizAuxiliar.getMatrizNumerosNoLidos());
                if (linea1 == true) {
                    System.out.println("\nLinea");
                    Cartera.añadirLinea("Recuento", nombreJugador);
                    Cartera.lerFicheiro("Recuento");
                }else
                    System.out.println("\nSigue intentandolo");
                break;
            case 4:
                boolean bingo1 = Bombo.comprobarBingo(matrizAuxiliar.getMatrizNumerosNoLidos());
                if (bingo1 == true) {
                    System.out.println("\nBingo");
                    Cartera.añadirBingo("Recuento", nombreJugador);
                    Cartera.lerFicheiro("Recuento");
                    System.exit(0);
                }else
                    System.out.println("\nSigue intentandolo");
                break;
            case 5:

                Metodos.visualizar(matrizAuxiliar.getMatrizNumerosNoLidos());
                System.out.println("\n");

                break;

            case 6:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

    }

    public static void sacarNumerosBombo(boolean linea, boolean bingo) {

    }
}




