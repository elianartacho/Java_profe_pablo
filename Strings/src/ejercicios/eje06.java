package ejercicios;
//Método que cuente el número de veces que aparece un carácter en una cadena.

public class eje06 {
    public static void main(String[] args) {
        System.out.println(caracter("hola guapa",'a'));
    }

    //Este metodo recibe un String u un caracter
    public static String caracter(String texto, char letra) {
        //inicializamos el contador a 0
        //para contar el numero de veces que aparece la letra en el texto
        int sumar = 0;
       
        //recorremos el texto letra a letra
        //con el metodo charAt(i) vamos a ir obteniendo cada letra del texto
        for(int i = 0;i< texto.length();i++){
            char letra1 = texto.charAt(i);
           //comparamos si la letra1 es igual a la letra que nos han pasado
            //si es asi incrementamos el contador
            //si no, no hacemos nada
          if(letra1 == letra){
              sumar++;
            } 
        }
        //al final del recorrido devolvemos el resultado
        //concatenamos el texto con la letra y el numero de veces que aparece
        //en el texto
        //devolvemos el resultado
        return " el texto contiene " + letra + " "+sumar + " veces " ;
       
    }
}
