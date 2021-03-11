package com.MiBingoPruebas;


import java.util.Random;
import java.util.Stack;

public class Carton {

    public static void generarCarton(int[][]carton){
        int k=0;
        Random aleatorio=new Random();
        for (int i=0;i<carton.length;i++){
            for (int j=0;j<carton[i].length;j++){
                if (i==0){
                    if (j==0) {
                        carton[i][j] = aleatorio.nextInt(7)  + 1; // La priemra columna tendra siempre números del 0 al 9
                    }else{
                            carton[i][j] = aleatorio.nextInt(8) + (10 *j); // El resto de columnas tienen números que van desde j*10+un número aleatorio del 1 al 9 ejemplo columna cuatro del 40 al 49
                        }
                    }else {
                    if (i==1){
                        k=0;
                    }else {
                        if (i == 2) {
                            k = 1;
                        }
                    }
                        carton[i][j]= aleatorio.nextInt(9+k)+(10*j);
                        do {
                            carton[i][j]=aleatorio.nextInt(9+k)+(10*j);
                        }while (carton[i][j]<=carton[i-1][j]);

                }
                }
                carton[2][8]++;
            }
        }
    public static int bombos(int[][] carton) {
        //ponemos la posicion del bombo en 0
        int bombo = 0;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
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
    }

    public static void imprimirCarton(int[][] carton) {

        for (int i = 0; i < carton.length; i++) {
            //Para visualizar unha matriz de números en non unha fila de números
            System.out.println(" \n ");
            for (int j = 0; j < carton[i].length; j++) {
                System.out.printf("%3d ", carton[i][j]); //%imprime una variable, utiliza al menos 3 espacios para mostrar rellenando segun sea necesrio ,d la variable será entera
            }
        }
    }

   public static int nulos(int[][]carton){
        int nulo=0;
       for (int i=0;i<3;i++){
                 carton[i][numerosSinRepeticion().pop()]=nulo;
                 carton[i][numerosSinRepeticion().pop()]=nulo;
                 carton[i][numerosSinRepeticion().pop()]=nulo;
                 carton[i][numerosSinRepeticion().pop()]=nulo;
       }
       return nulo;
   }

   public static void visualizarPila(){
       System.out.println(numerosSinRepeticion().pop());
       System.out.println(numerosSinRepeticion().pop());
       System.out.println(numerosSinRepeticion().pop());


   }



    public static Stack<Integer> numerosSinRepeticion(){
        int num;
        Random aleatorio=new Random();
        Stack < Integer > aleatorios = new Stack< Integer >();
        for (int i = 0; i < 4; i++) {
            num= aleatorio.nextInt(10);
            while (aleatorios.contains(num)) {
                num = aleatorio.nextInt(10);
            }
            aleatorios.push(num);
        }
        System.out.println("\nNúm. aleatorios sin repetición:");
        System.out.println(aleatorios.toString());
        return aleatorios;
    }
}



