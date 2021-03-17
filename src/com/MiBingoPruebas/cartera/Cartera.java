package com.MiBingoPruebas.cartera;

import java.io.*;
import java.util.Scanner;

public class Cartera {
    public static void puntuacionInicial(String nomeFich){
        File fi = new File(nomeFich+".txt");
        PrintWriter escribir = null;
        try {
            escribir= new PrintWriter(fi);
            escribir.println(1500);
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
    public static void Bingo(String nomeFich){
        PrintWriter f=null;
        File fich;
        try {
            FileWriter engadir= new FileWriter(new File(nomeFich+".txt"),true);//True para engadir ao final do ficheiro
            f= new PrintWriter(engadir);
            int bingo=Integer.parseInt(lerFicheiro(nomeFich))+500;
            f.println(bingo);// como no toString();
        }catch (IOException ex){
            System.out.println("erro "+ex.getMessage());
        }
        f.close();
    }
    public static void Linea(String nomeFich){
        PrintWriter f=null;
        File fich;
        try {
            FileWriter engadir= new FileWriter(new File(nomeFich+".txt"),true);//True para engadir ao final do ficheiro
            f= new PrintWriter(engadir);
            int linea=Integer.parseInt(lerFicheiro(nomeFich))+150;
            f.println(linea);// como no toString();
        }catch (IOException ex){
            System.out.println("erro "+ex.getMessage());
        }
        f.close();
    }

}
