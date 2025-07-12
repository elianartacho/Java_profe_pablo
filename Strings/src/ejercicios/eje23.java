package ejercicios;
//Método que retorne cuántas palabras de menos de 3 letras tiene una frase, considerando
// como separador de palabras únicamente el inicio de cadena, el espacio y el fin de cadena.

public class eje23 {
    public static void main(String[] args) {
        System.out.println(retorno("he tu sol"));
        
    }

    public static String retorno(String frase){
       int contador= 0;
       String espacio = ""; 

        for (int i = 0; i < frase.length() ; i++) {
           char actual = frase.charAt(i);
           if(i < 2){
            contador++; 
           }else if(espacio.equals(actual + "")){
                i = 0;
            }
        
        }
        return "hay " + contador + " palabras de menos de tres letras";
    }

}
