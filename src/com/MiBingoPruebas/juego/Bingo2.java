package com.MiBingoPruebas.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Bingo2 extends JFrame {

    JPanel panel_principal;
    JPanel panel_botones;
    static ArrayList<Carton> cartones = new ArrayList();
    static ArrayList<Integer> numerosNombrados = new ArrayList();
    int numeroMagico = 0;
    static int ncartones = 1;
    static JButton btn_iniciar = new JButton();
    boolean creado = false;

    public Bingo2() {
        this.setTitle("Bingo");
        this.setSize(300, 300);
        this.setResizable(true);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.visible();
        this.setVisible(true);
    }

    void visible() {
        this.panel_principal = new JPanel();
        this.panel_principal.setLayout(new BorderLayout());
        this.panel_botones = new JPanel();
        this.panel_botones.setLayout(new GridLayout(3, 1, 8, 8));
        this.crearBotones();
        this.panel_principal.add("Center", this.panel_botones);
        this.getContentPane().add(this.panel_principal);
        ImageIcon icono = new ImageIcon("iconos/bingo.png");
        this.setIconImage(icono.getImage());
    }

    public static void main(String[] args) {
        new Bingo2();
    }

    void crearBotones() {
        btn_iniciar.setText("Iniciar");
        btn_iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (Bingo2.cartones.isEmpty()) {
                        JOptionPane.showMessageDialog((Component)null, "Primero debes tener algun carton", "ALTO!", 2);
                    } else {
                        if (!Carton.cantadoLinea) {
                            Bingo2.btn_iniciar.setText("Jugar para linea");
                        }

                        if (!Bingo2.this.creado) {
                            new VentanaNumeros();
                            Bingo2.this.creado = true;
                        }

                        Bingo2.this.jugar();
                    }
                } catch (Exception var4) {
                    System.out.println("Error: " + var4);
                }

            }
        });
        this.panel_botones.add(btn_iniciar);
        JButton btn_carton = new JButton();
        btn_carton.setText("Carton");
        btn_carton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (Bingo2.numerosNombrados.isEmpty()) {
                        Bingo2.cartones.add(new Carton());
                        ++Bingo2.ncartones;
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "La partida esta en marcha, deberas esperar", "ALTO!", 2);
                    }
                } catch (Exception var3) {
                    System.out.println("Error: " + var3);
                }

            }
        });
        this.panel_botones.add(btn_carton);
        JButton btn_salir = new JButton();
        btn_salir.setText("Salir");
        this.panel_botones.add(btn_salir);
        btn_salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    System.exit(0);
                } catch (Exception var3) {
                    System.out.println("Error: " + var3);
                }

            }
        });
    }

    public void jugar() {
        boolean esta = false;

        do {
            this.numeroMagico = (int)(Math.random() * 90.0D);
            if (!numerosNombrados.contains(this.numeroMagico) && this.numeroMagico != 0) {
                numerosNombrados.add(this.numeroMagico);
                System.out.println("numero: " + this.numeroMagico);
                VentanaNumeros.numero.setText("" + this.numeroMagico);
                esta = true;
            }
        } while(!esta);

        Iterator var2 = cartones.iterator();

        while(var2.hasNext()) {
            Carton nCarton = (Carton)var2.next();
            nCarton.buscarNumero(this.numeroMagico);
        }

    }
}
