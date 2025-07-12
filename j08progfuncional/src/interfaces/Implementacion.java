package interfaces;

public class Implementacion implements EjemploInterfaz {

	
	@Override
	public void procesa(String str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int otroProceso() {
		// TODO Auto-generated method stub
		return 0;
	}

	//si quiero puedo sobrrescribir cualquier metodo default 
	@Override
	public void haceAlgo() {
		EjemploInterfaz.super.haceAlgo();
	}
}
