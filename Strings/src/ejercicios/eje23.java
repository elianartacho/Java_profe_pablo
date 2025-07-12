package ejercicios;
//Método que retorne cuántas palabras de menos de 3 letras tiene una frase, considerando
// como separador de palabras únicamente el inicio de cadena, el espacio y el fin de cadena.


public class eje23 {
    public static void main(String[] args) {
        System.out.println(retorno("he tu sol el ya vino"));
    }

    public static int retorno(String frase) {
        int contadorLetras = 0;
        int contadorPalabras = 0;

        for (int i = 0; i < frase.length(); i++) {
            char let = frase.charAt(i);

            if (let != ' ') {
                contadorLetras++; // Contamos letras
            } else {
                if (contadorLetras > 0 && contadorLetras < 3) {
                    contadorPalabras++; // Contamos palabra pequeña
                }
                contadorLetras = 0; // Reiniciamos para la siguiente palabra
            }
        }

        // Comprobamos la última palabra (por si no termina en espacio)
        if (contadorLetras > 0 && contadorLetras < 3) {
            contadorPalabras++;
        }

        return contadorPalabras;
    }
}

/* public class eje23 {
    public static void main(String[] args) {
        System.out.println(retorno("he tu sol"));
    }

    public static int retorno(String frase){
        int contador = 0;
        String[] palabras = frase.split(" "); // Dividimos la frase por espacios

        for(String palabra : palabras){
            if(palabra.length() < 3){
                contador++;
            }
        }
        return contador;
    }
}
 */