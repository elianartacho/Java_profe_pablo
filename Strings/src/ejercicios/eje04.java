package ejercicios;

import java.util.Scanner;

//Pedir al usuario una frase y un carácter, y decir si la frase contiene ese carácter.
public class eje04 {
    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       System.out.println("Introduce una frase:");
       String frase = teclado.nextLine();
       System.out.println("Introduce un carácter:");
       char caracter = teclado.nextLine().charAt(0);
       System.out.println(cadena(frase, caracter)); 
    }

    public static String cadena(String texto, char letra) {
        // Longitud del texto
        int longitud = texto.length();
        String resultado = "El texto no contiene el carácter '" + letra + "'";

        // Recorremos el texto para buscar el carácter
        for (int i = 0; i < longitud; i++) {
            char caracterActual = texto.charAt(i);
            if (caracterActual == letra) {
                resultado = "El texto contiene el carácter '" + letra + "'";
                break;
            }
        }

        return resultado;
    }

}
