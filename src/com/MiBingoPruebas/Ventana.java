package com.MiBingoPruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Ventana extends JFrame implements Runnable {

    public static final  int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private String nombre;


    public Ventana(){

        setTitle(" Bingo ");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
    }

    public boolean validacion(String nombre){
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

    int x =340;
    int y= 200;

    int a[] = { 390,  86,86};
    int b[] = { 340, 200, 100};

    int vertices = 3;

    private void actualizar(){
        //x++;



    }


    private void dibujar(){

        bs=canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(3);
            return;

        }
        g = bs.getDrawGraphics();
        //--------------------------

        g.setColor(Color.red);

        g.drawPolygon(a, b, vertices);


        //g.clearRect(0,0,WIDTH,HEIGHT);


        g.drawRect(x,y, 100,100);

        //g.drawLine(x,y,100,100);


        //--------------------------
        g.dispose();
        bs.show();

    }


    @Override
    public void run() {

        while(running){

            actualizar();
            dibujar();

        }

        stop();

    }
    public void start(){

        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop(){

        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
