package movida.eccezioni;

import movida.commons.MapImplementation;

public class DizionarioSconosciutoEccezione extends RuntimeException{
	
	public DizionarioSconosciutoEccezione(MapImplementation Dizionario) {
		super("L'implementazione del dizionario tramite" + Dizionario + " non è supportata.");
	}
	
}
