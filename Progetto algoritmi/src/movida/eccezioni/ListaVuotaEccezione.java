package movida.eccezioni;

public class ListaVuotaEccezione extends RuntimeException{

	public ListaVuotaEccezione() {
		super("La lista è vuota");
	}
}
