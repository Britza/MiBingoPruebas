package com.MiBingoPruebas.cartera;

import java.io.*;
import java.util.Scanner;

public class Cartera {
    /**
     * Método que escribe el nombre de un jugador en un fichero. Se le pasa por parametros el nombre del fichero y el nombre del jugador
     * @param nomeFich nombre del fichero
     * @param nombreJugador nombre del jugador
     */
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

    /**
     * Método que lee lo que hay en un fichero (se le pasa por parametros) y devuelve lo que leyo del fichero
     * @param nomFich
     * @return devuelve los datos leidos del fichero
     */

    public static String lerFicheiro(String nomFich) {
        String datos = null;
        Scanner sc = null;
        File f = new File(nomFich + ".txt"); //Dende o directorio raiz, o ficheiro esta na carpeta do ficheiro
        try {
            sc = new Scanner(f).useDelimiter("\\s*,\\s*");
            while (sc.hasNextLine()) {
                datos = sc.nextLine();
                System.out.println(datos);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro lectura liña, " + ex.toString());
        } finally {
            sc.close();
        }
        return datos;
    }

    /**
     * Método que añade al fichero la puntuación obtenida por un jugador si ha cantado linea
     * @param nomeFich recibe el nombre del fichero
     * @param nombre recibe el nombre del jugador
     */

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
    /**
     * Método que añade al fichero la puntuación obtenida por un jugador si ha cantado bingo
     * @param nomeFich recibe el nombre del fichero
     * @param nombreJugador recibe el nombre del jugador
     */
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
