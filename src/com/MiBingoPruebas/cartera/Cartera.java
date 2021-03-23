package com.MiBingoPruebas.cartera;

import java.io.*;
import java.util.Scanner;

public class Cartera {

    public static void escribirNombre(String nomeFich,String nombreJugador){
        File fi = new File(nomeFich+".txt");
        PrintWriter escribir = null;
        try {
            escribir=new PrintWriter(nomeFich);
            escribir.println(nombreJugador);
        } catch (FileNotFoundException ex){
            System.out.println("erro escribirNumeros "+ex.toString());
        }finally {
            escribir.close();
        }
    }

    public static String lerFicheiro(String nomFich){
        String datos = null;
        Scanner sc =null;
        File f =new File(nomFich+".txt"); //Dende o directorio raiz, o ficheiro esta na carpeta do ficheiro
        try {
            sc= new Scanner(f).useDelimiter("\\s*,\\s*");
            while (sc.hasNextLine()){
                datos=sc.nextLine();
                System.out.println(datos);
            }
        }catch (FileNotFoundException ex){
            System.out.println("Erro lectura liña, "+ ex.toString());
        }finally {
            sc.close();
        }
        return datos;
    }

    public static void añadirLinea(String nomeFich, String nombre) {
        PrintWriter f = null;
        int puntuacionInicial = 0;
        File fich;
        try {
            FileWriter engadir = new FileWriter(new File(nomeFich + ".txt"), true);//True para engadir ao final do ficheiro
            f = new PrintWriter(engadir);
            puntuacionInicial = puntuacionInicial + 150;
            f.println(nombre + " : " + puntuacionInicial);

        } catch (IOException ex) {
            System.out.println("erro " + ex.getMessage());
        }

        f.close();

    }

    public static void añadirBingo(String nomeFich, String nombreJugador) {
        PrintWriter f = null;
        int puntuacionInicial = 0;
        File fich;
        try {
            FileWriter engadir = new FileWriter(new File(nomeFich + ".txt"), true);//True para engadir ao final do ficheiro
            f = new PrintWriter(engadir);

            puntuacionInicial = puntuacionInicial + 500;

            f.println(puntuacionInicial);

        } catch (IOException ex) {
            System.out.println("erro " + ex.getMessage());
        }

        f.close();

    }
}
