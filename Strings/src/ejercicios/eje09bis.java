package ejercicios;


public class eje09bis  {
    public static void main(String[] args) {
        System.out.println(palindromo("anita lava la tina"));
    }

     public static boolean palindromo(String texto){
        //inicio una variable donde guardar la cadena invertida y otro para el resultado 
         String inver = "";
         
         //con replaceAll(lo que quiero quitar,por lo que sustituyo) quito los espacios y con toLowerCase lo pongo en minusculas
         
          texto =  texto.replaceAll(" ","").toLowerCase();
         // con este for lo recorres del final al principio
        for (int i = texto.length() - 1; i >= 0; i--) {
            //caracter a caracter
           char tex = texto.charAt(i);
           //vas acumulando los char en inver
            inver += tex;        
        } 
     

        // comparamos los strings con el metodo equals
        if (texto.equals(inver)){
               return true;
            }else{
               return false;
            }
            //retorno el resultado
  
    }
}   
