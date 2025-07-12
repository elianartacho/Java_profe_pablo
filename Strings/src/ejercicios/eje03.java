package ejercicios;
// Ejercicio 3: Pedir al usuario una cadena de texto y mostrar cada letra en una línea diferente.
public class eje03 {
 
    public static void main(String[] args) {
        System.out.println(cadena("Hola Mundo"));
    
    }

    public static String cadena(String texto) {
        // Longitud del texto
      
        for (int i = 0; i < texto.length(); i++) {
          char letra = texto.charAt(i);
            System.out.println("Letra( "+  i + "):" + letra);
        }

        return texto;
    }

    
}