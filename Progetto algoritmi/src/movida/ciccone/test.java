package movida.ciccone;

import java.util.Arrays;
import java.util.Comparator;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort<String[]> sort = new Sort();
		
		String[] frasi = new String[8];
		frasi[0] = "aiaiif";
		frasi[1] = "vndsng";
		frasi[2] = "ccaiif";
		frasi[3] = "asndsng";
		frasi[4] = "gaiif";
		frasi[5] = "zndsng";
		frasi[6] = "caaiif";
		frasi[7] = "bbndsng";
		System.out.println(Arrays.toString(frasi));
		
		
		Sort.selectionSort(frasi, new Sort.sortByAlphabet());
		System.out.println(Arrays.toString(frasi));
		
		frasi[0] = "aiaiif";
		frasi[1] = "vndsng";
		frasi[2] = "ccaiif";
		frasi[3] = "asndsng";
		frasi[4] = "gaiif";
		frasi[5] = "zndsng";
		frasi[6] = "caaiif";
		frasi[7] = "bbndsng";
		System.out.println(Arrays.toString(frasi));
		
		Sort.mergeSort(frasi, new Sort.sortByAlphabet());
		System.out.println(Arrays.toString(frasi));
		System.out.println(Arrays.toString(frasi));
		System.out.println(Arrays.toString(frasi));
		

	}

}
