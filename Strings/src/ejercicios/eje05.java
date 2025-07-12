package ejercicios;
//Método que pida un carácter c y un número n y que devuelva una cadena con c repetido
// n veces. Ej: repite(‘a’, 4) debe retornar “aaaa”
public class ej05 {
    public static void main(String[] args) {
        System.out.println(repite('a', 4));
    }
    // metodo que recoge un char y el numero de veces que se repite y al meterlo en el for y concatenarlo
    //una cadena que guardo en result
    //al final devuelvo la cadena result
    public static String repite(char c, int n){
        String result = "";

        for(int i = 0; i < n ;i++){
           result +=c;
           
    }
    return result;

}
}
