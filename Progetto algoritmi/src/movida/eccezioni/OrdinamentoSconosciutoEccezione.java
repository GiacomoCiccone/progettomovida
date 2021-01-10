package movida.eccezioni;

import movida.commons.SortingAlgorithm;

public class OrdinamentoSconosciutoEccezione extends RuntimeException { 
	
	public OrdinamentoSconosciutoEccezione(SortingAlgorithm Ordinamento) {
		super("L'ordinamento tramite " + Ordinamento + " non è supportato.");
	}

}
