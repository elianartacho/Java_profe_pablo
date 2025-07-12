package ejercicios;
//Método que reciba una cadena y retorne el número de vocales que contiene.

public class eje07 {
    public static void main(String[] args) {
    System.out.println(nVocal("elisabeth"));

    }

    public static String nVocal(String texto){
        texto.toLowerCase();
        int suma = 0;
        for (int i = 0; i < texto.length(); i++) {
            char tex = texto.charAt(i);
           
 //          if (tex == 'a' || tex == 'e' || tex == 'i' || tex == 'o' || tex == 'u') {
 //           suma++;
 //          }

            //Este if me recoge una cadena y con contains(recibe Strings) me dice si lo contiene 
            if("aeiou".contains(tex + ""))
                suma++;
        }
        return "El texto contiene " + suma + " vocales";
    }
     
}
