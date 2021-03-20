package com.MiBingoPruebas.juego;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Carton extends JFrame {

    JPanel panel_principal;
    JPanel panel_botones;
    JButton[] boton;
    int[][] espacios = new int[3][9];
    /*int[] compColumna = new int[9];
    int contL = 0;
    int contIntro = 0;
    int htotales;
    int contNumeros = 0;
    int contadorPosicion = 0;
    ArrayList<Integer> numeros = new ArrayList();*/
    int i = 0;
    int numeroCarton;
    public static boolean cantadoLinea = false;
    public static boolean linea = false;
    int[][]carton=new int[3][9];

    public Carton() {
        this.numeroCarton = Bingo2.ncartones;
        this.setTitle("Carton " + this.numeroCarton);
        this.setSize(550, 240);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(0);
        this.visible();
        this.setVisible(true);
    }

    void visible() {
        this.panel_principal = new JPanel();
        this.panel_principal.setLayout(new BorderLayout());
        this.panel_botones = new JPanel();
        this.panel_botones.setLayout(new GridLayout(3, 9, 8, 8));
        this.crearBotones();
        this.panel_principal.add("Center", this.panel_botones);
        this.getContentPane().add(this.panel_principal);
    }

    void crearBotones() {
        this.boton = new JButton[27];
        this.i = 0;

       generarCarton();

        for(int col = 0; col < 3; ++col) {
            for(int f = 0; f < 9; ++f) {
                this.boton[this.i] = new JButton("" + this.espacios[col][f]);
                if (this.espacios[col][f] == 0) {
                    this.boton[this.i].setBackground(Color.BLACK);
                    this.boton[this.i].setText("");
                }

                this.panel_botones.add(this.boton[this.i]);
                ++this.i;
            }
        }

    }


    void generarCarton() {
        int k = 0;
        Random aleatorio = new Random();

        for(int i = 0; i < carton.length; ++i) {
            for(int j = 0; j < carton[i].length; ++j) {
                if (i == 0) {
                    if (j == 0) {
                        carton[i][j] = aleatorio.nextInt(7) + 1;
                    } else {
                        carton[i][j] = aleatorio.nextInt(8) + 10 * j;
                    }
                } else {
                    if (i == 1) {
                        k = 0;
                    } else if (i == 2) {
                        k = 1;
                    }

                    carton[i][j] = aleatorio.nextInt(9 + k) + 10 * j;

                    do {
                        carton[i][j] = aleatorio.nextInt(9 + k) + 10 * j;
                    } while(carton[i][j] <= carton[i - 1][j]);
                }
            }

            int var10002 = carton[2][8]++;
        }

    }

    /*public static int bombos(int[][] carton) {
        int bombo = 0;

        for(int i = 0; i < carton.length; ++i) {
            for(int j = 0; j < carton[i].length; ++j) {
                carton[0][0] = bombo;
                carton[1][0] = bombo;
                carton[2][1] = bombo;
                carton[0][2] = bombo;
                carton[1][3] = bombo;
                carton[2][3] = bombo;
                carton[2][4] = bombo;
                carton[0][5] = bombo;
                carton[1][6] = bombo;
                carton[2][6] = bombo;
                carton[0][7] = bombo;
                carton[1][8] = bombo;
            }
        }

        return bombo;
    }*/

    /*public static void imprimirCarton(int[][] carton) {
        for(int i = 0; i < carton.length; ++i) {
            System.out.println(" \n ");

            for(int j = 0; j < carton[i].length; ++j) {
                System.out.printf("%3d ", carton[i][j]);
            }
        }

    }*/

    public void buscarNumero(int numeroMagico) {
        int nboton = 0;

        for(int fila = 0; fila < 3; ++fila) {
            for(int columna = 0; columna < 9; ++columna) {
                if (this.espacios[fila][columna] == numeroMagico) {
                    this.boton[nboton].setBackground(Color.red);
                    if (!cantadoLinea) {
                        this.compLinea();
                    }
                }
            }

            ++nboton;
        }

    }


    public void compLinea() {
        int nboton = 0;

        for(int fila = 0; fila < 3; ++fila) {
            int correcto = 0;

            for(int columna = 0; columna < 9; ++columna) {
                if (this.boton[nboton].getBackground().equals(Color.red) || this.boton[nboton].getBackground().equals(Color.black)) {
                    ++correcto;
                }

                ++nboton;
            }

            if (correcto == 9) {
                linea = true;
                cantadoLinea = true;
                JOptionPane.showMessageDialog((Component)null, "Linea Realizada en Carton " + this.numeroCarton, "LINEA", 1);
                Bingo2.btn_iniciar.setText("Jugar para bingo");
                System.out.println("linea");
            }
        }

    }
}
