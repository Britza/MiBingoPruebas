package com.MiBingoPruebas;

import javax.swing.*;
import java.util.logging.Level;

public class Bingo {

    //public static void main(String[] args) {
        /*int bombo=0;
        int[][] carton=new int[3][9];

        Carton.generarCarton(carton);
        bombo=Carton.bombos(carton);
        Carton.imprimirCarton(carton);*/

    public static void main(String[]s){
        RegistrarEditables();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    private static void RegistrarEditables() {

        try {
            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


       // Carton.visualizarPila();




