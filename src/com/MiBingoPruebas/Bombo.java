package com.MiBingoPruebas;

public class Bombo {

    public static int generarNumeroAleatorio(){
        int num=(int)(Math.random()*90);
        System.out.println("\n\n "+num);
        return num ;
    }

    public static void comprobarNumeroBombo(int num,int[][][]carton,int[][][]matrizNulos){
       boolean atopado=false;
        for (int i=0;i< carton.length;i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (num == carton[i][j][0]) {
                    atopado = true;
                    System.out.println("Atopado");
                    matrizNulos[i][j][0]=1;
                    // return atopado;
                }
            }
        }
        if (atopado==false) {
            System.out.println("\nO numero non está no arrai");
        }
    }

}
