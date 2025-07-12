package ejercicios;
//Desarrollar un método que indique si una palabra es un palíndromo.
// a. Modificarlo para que indique si una frase es un palíndromo.
public class eje09 {
    public static void main(String[] args) {
        System.out.println(palindromo("rotor"));
    }

    public static String palindromo(String texto){
        //inicio una variable donde guardar la cadena invertida y otro para el resultado 
         String inver = "";
         String resul = "";

         // con este for lo recorres del final al principio
        for (int i = texto.length() - 1; i >= 0; i--) {
            //caracter a caracter
           char tex = texto.charAt(i);
           //vas acumulando los char en inver
            inver += tex;        
        } 
        // comparamos los strings con el metodo equals
        if (texto.equals(inver)){
              resul = "Es palindromo";
            }else{
               resul = "No es palindromo";
            }
            //retorno el resultado
        return resul;
    }

}
