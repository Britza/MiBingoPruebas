package com.MiBingoPruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio  extends JFrame {
    private static String nomb;
    private JButton salir, empezarJuego;
    private  JLabel textNombre, fondos, cargador;
    private JTextField nameTextArea; //Aqui se escribe

    public Inicio(){
        configuraciones();
    }

    private void configuraciones(){
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bingo");
        modeloDeMaus();
        nombreText();
        nameEreaText();
        fondos();
        salirBtoon();
        empezarJuegoBtton();
        cargadorBarra();
        pack();
        setSize(400,380);
        setLocationRelativeTo(null);
    }

    private void modeloDeMaus(){
        setCursor(new Cursor(Cursor.HAND_CURSOR));//tipo de cursor
    }

    private void nameEreaText(){
        nameTextArea = new JTextField();
        nameTextArea.setBounds(140,140,160,30);
        getContentPane().add(nameTextArea);
    }

    private void cargadorBarra(){
        cargador = new JLabel();
        cargador.setBounds(10,280,440,40);
        getContentPane().add(textNombre);
    }

    private void nombreText(){
        textNombre = new JLabel();
        textNombre.setText("Nombre: ");
        textNombre.setBounds(80,130,70,40);
        getContentPane().add(textNombre);
    }

    private void fondos(){
        for(int i=0; i<2; i++){
            fondos = new JLabel();
            fondos.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\britz\\OneDrive\\Imágenes" +i+ ".png")));
            if(i==0){
                fondos.setBounds(70,40,90,70);
            }
            else {
                fondos.setBounds(100, 40, 90, 70);
            }
                getContentPane().add(fondos);
        }
    }
    private void empezarJuegoBtton(){
        empezarJuego = new JButton();
        empezarJuego.setFont(new java.awt.Font("OCR A Extended",3,14));
        empezarJuego.setText("Empezar juego");
        empezarJuego.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        empezarJuego.setBounds(100,210,170,25);
        getContentPane().add(empezarJuego);
    }

    private void salirBtoon(){
        salir = new JButton();
        salir.setFont(new Font("OCR A Extended",1,14));
        salir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
            }
        });
        salir.setBounds(290,210,100,30);
        getContentPane().add(salir);
    }

    private void salidaMouseClicked(MouseEvent mouseEvent){
        System.exit(0);
    }

    private void entrarMouseClicked(MouseEvent mouseEvent){
        String nombre = nameTextArea.getText();
        if(valido(nombre)){
            Hilo h =new Hilo();
            nomb=nombre;
            h.start();
        }
    }

    private boolean valido(String nombre){
        boolean res = true;
        char letra;
        if(nombre.length()>0){
            for(int i=0; i<nombre.length();i++){
                letra = nombre.charAt(i);
                if(letra>='a' && letra<='z' || letra>='A' && letra<='Z'){
                }
                else {
                    res=false;
                    break;
                }
            }
        }return res;
    }

    private class Hilo extends Thread{

        URL f;

        @Override
        public void run() {
            cargando();
        }

        private void cargandoImagen(int i){
            f=getClass().getResource("imagenes/cargando"+i+".png");
            ImageIcon imagen = new ImageIcon(f);
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(cargador.getWidth(), cargador.getHeight(), Image.SCALE_AREA_AVERAGING));
            cargador.setIcon(icono);
            repaint();
        }

        private void cargando(){
            for (int i=0; i<6; i++){
                try{
                    cargandoImagen(i);
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }


    }




}
