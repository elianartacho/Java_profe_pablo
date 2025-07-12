package ejercicios;
//Desarrollar un método que reciba una cadena y retorne otra con la original invertida.
public class eje08 {
    public static void main(String[] args) {
        System.out.println("La palabra invertida es"+ invertida("pato"));
    }

    public static String invertida (String texto){
        String inver = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
           char tex = texto.charAt(i);
            inver += tex;
        }
        return inver;
    }

}
