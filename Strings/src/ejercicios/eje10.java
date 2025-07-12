package ejercicios;
//Desarrollar un método que, dada una cadena, retorne su sigla, es decir, la primera letra
//de cada palabra en mayúsculas. Por ejemplo, si recibe ’Universal serial bus’ debe devolver
// ’USB’.
public class eje10 {
    public static void main(String[] args) {
        System.out.println(siglas("Universal serial bus"));
    }

    public static String siglas(String texto){
       texto =  texto.toUpperCase();
       String uno = "";
       String espacio = " ";

       //recorro las palabras
        for (int i = 0; i < texto.length(); i++) {
            char actual = texto.charAt(i);
            //cuando es igual a cero la meto en la variable
            if(i == 0){
               uno = String.valueOf(actual);
               
                    //cuando hay un espacio comparo 
            }else if(espacio.equals(actual + "")){
                //y coloco actual en una posicion mas
              actual = texto.charAt( i + 1 );
              //concateno para ir sumando todas las letras
                uno += String.valueOf(actual);
                 
            }
        }
        return  uno;
    }

}
