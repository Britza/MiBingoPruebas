package com.MiBingoPruebas.juego;

import com.MiBingoPruebas.cartera.Cartera;
import metodos.Metodos;
import javax.swing.*;

import static com.MiBingoPruebas.juego.Bombo.*;

public class Juego {

    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    static Carton carton = Carton.getInstace();
    static Auxiliar matrizAuxiliar = Auxiliar.getInstace();
    private static String nombreJugador =JOptionPane.showInputDialog("Nombre del jugador : ");

    /**
     *Método que permite elegir la opción de juego deseada (comprar carton, cantar linea...)
     * @param num número que recibe de la clase Bingo que le indica que opción debe ejecutra
     */
    public static void jugar(int num) {
        int numALeatorio = numerosSinRepeticion();
        Cartera.escribirNombre("Recuento",nombreJugador);

        switch (num) {

            case 1:
                Carton.comprarCarton();
                System.out.println("\n\n");
                break;
            case 2:

                boolean atopado = Bombo.comprobarNumeroBombo(numALeatorio, carton.getCarton(), matrizAuxiliar.getMatrizNumerosNoLidos());
                if (atopado == true) {
                    System.out.print(" " + ANSI_PURPLE + numALeatorio + ANSI_RESET);

                } else {
                    System.out.printf("%3d", numALeatorio);

                }
                break;
            case 3:
                boolean linea = Bombo.comprobarLinea(matrizAuxiliar.getMatrizNumerosNoLidos());
                    if (linea==true) {
                        Cartera.añadirLinea("Recuento",nombreJugador);
                        Cartera.lerFicheiro("Recuento");
                    }
                break;
            case 4:
                boolean bingo = Bombo.comprobarBingo(matrizAuxiliar.getMatrizNumerosNoLidos());
                    if (bingo==true) {
                        Cartera.añadirBingo("Recuento",nombreJugador);
                        Cartera.lerFicheiro("Recuento");
                        System.exit(0);
                    }
                break;
            case 5:

                Metodos.visualizar(matrizAuxiliar.getMatrizNumerosNoLidos());


                break;

            case 6:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

    }
}



