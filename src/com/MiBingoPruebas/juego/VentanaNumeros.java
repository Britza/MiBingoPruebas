package com.MiBingoPruebas.juego;

import javax.swing.*;
import java.awt.*;

public class VentanaNumeros extends JFrame {

    JPanel panel_principal;
    static JLabel numero = new JLabel("");

    public VentanaNumeros() {
        this.setTitle("");
        this.setBounds(450, 0, 80, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.visible();
        this.setVisible(true);
    }

    void visible() {
        this.panel_principal = new JPanel();
        numero.setBounds(0, 0, 80, 100);
        numero.setText("");
        numero.setFont(new Font("Serif", 1, 50));
        numero.setHorizontalAlignment(0);
        numero.setForeground(Color.BLUE);
        numero.setBackground(Color.getHSBColor(48.0F, 62.0F, 115.0F));
        this.panel_principal.setBackground(Color.getHSBColor(48.0F, 62.0F, 115.0F));
        numero.setOpaque(true);
        this.panel_principal.add(numero);
        this.getContentPane().add(this.panel_principal);
    }

    public static void main(String[] args) {
        new VentanaNumeros();
    }
}

