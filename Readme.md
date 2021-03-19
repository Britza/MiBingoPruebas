# PROYECTO BINGO
##Descripción :
Juego Bingo de modalidad 90 (las bolas del bombo van desde 1 al 90)
## Esquema
#### 1. Crear cartones.
Los cartones se crean con una matriz de numeros aleatorios ordenados. Se utiliza la clase Random.
Los espacios nulos se le añaden después recorriendo la matriz con un for. (Se añaden 0 como espacios nulos).
#### 2. Generar nº aleatorios.
Se utiliza la clase Random para generar los números aleatorios y se guardan en un array.
#### 3. Visualizar cartones.
Los cartones se visualizan con un system.printfn("3%d",carton); que permite visualizar por consola el
carton separado y en forma matricial.
#### 4. Visualizar nº aleatorio.
#### 5. Tachar número que salga en el cartón.
Se guarda la posicion del número que ha salido del cartón en una matriz auxiliar de 0. Cuando sale un número
se pone un uno en la posición correspondiente a este.
#### 6. Volver a visualizar cartón.
#### 7. Comprobar si hay linea.
  La linea se comprueba contando la cantidad de unos por fila que hay en la matriz auxiliar.
#### 8. Comprobar si hay bingo.
El bingo se compprueba contando la cantidad de unos en total que hay en la matriz auxiliar.

Se utiliza la libreria javax.swing.*; para poder visualizar el menu con opciones.
