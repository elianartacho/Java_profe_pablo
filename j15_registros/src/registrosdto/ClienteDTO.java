package registrosdto;

//es un objeto inmutable que se usa para transportar datos y asi nos ahorramos
// el mantenimiento de tanto codigo
//ser crea un constructor con getter,equals y to string
public record ClienteDTO(int idCliente, String apellidos, int nroCliente, String categoria) {

	
}
