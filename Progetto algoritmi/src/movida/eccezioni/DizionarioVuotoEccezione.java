package movida.eccezioni;

public class DizionarioVuotoEccezione extends RuntimeException{

	public DizionarioVuotoEccezione() {
		super("Il dizionario è vuoto");
	}
}
