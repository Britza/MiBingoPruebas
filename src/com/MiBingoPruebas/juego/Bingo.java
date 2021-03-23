package com.MiBingoPruebas.juego;


import javax.swing.*;

public class Bingo {

    public static void main(String[] args) {
        System.out.println("BINGO");

        int saida=0;

        do {
            String[] options = {"Comprar carton", "jugar", "cantar linea", "cantar bingo", "comprobar", "Fin"};
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione opción",
                    "Menú",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );


            if (seleccion == 0) {
                Juego.jugar(1);
            }
            if (seleccion == 1) {
                Juego.jugar(2);
            }
            if (seleccion == 2) {
                Juego.jugar(3);
            }
            if (seleccion == 3) {
                Juego.jugar(4);
            }
            if (seleccion == 4) {
                Juego.jugar(5);

            }
            if (seleccion == 5) {
                Juego.jugar(6);
                saida = 6;

            }
        } while (saida != 6);
    }
}



