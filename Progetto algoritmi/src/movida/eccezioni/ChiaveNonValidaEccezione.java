package movida.eccezioni;

public class ChiaveNonValidaEccezione extends RuntimeException{
	
	private Comparable k;
	
	public ChiaveNonValidaEccezione(Comparable k) {
		super("La chiave " + k + " non è presente.");
	}
	
	public ChiaveNonValidaEccezione() {}

}
