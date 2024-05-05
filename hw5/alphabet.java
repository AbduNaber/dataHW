import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class alphabet {
	private Set<Character> english_alphabet = new LinkedHashSet<Character>();
	private Map<Character, Map<Character, Character>> map = new HashMap<Character,  Map<Character, Character>>();
	

	/**
	 * This constructor fills the english_alphabet set with the uppercase English alphabet letters.
	 * Then, it fills the map with the Vigenere cipher table.
	 */
	public alphabet() {
		// do not edit this method
		fill_english_alphabet();
		fill_map();
	}
	
	/**
	 * This method fills the english_alphabet set with the uppercase English alphabet letters.
	 */
	private void fill_english_alphabet() {
		// do not edit this method
		for(char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()) {
		    english_alphabet.add(c);
		}
	}
	
	/**
	 * This method fills the map with the Vigenere cipher table.
	 */
	private void fill_map() {
		Iterator <Character> iter = english_alphabet.iterator();
		Map<Character, Character> mapVal ;

		while(iter.hasNext()) {
		    mapVal = new HashMap<Character, Character>();
			char c = (char) iter.next();
			
			Iterator <Character>iter2 = english_alphabet.iterator();
			while(iter2.hasNext()) {
				char c2 = iter2.next();
				int i = ((int) c + (int) c2 - (2 *(int) 'A' ) ) % 26 ; 
				char c3 = (char) (i + (int) 'A');
			
				mapVal.put(c2, c3);
				
			}
			
			map.put(c, mapVal);
		
		}
	}

	/*
	 * This method prints the Vigenere cipher table.
	 */
	public void print_map() {
		// do not edit this method
		System.out.println("*** Viegenere Cipher ***\n\n");
		System.out.println("    " + english_alphabet);
		System.out.print("    ------------------------------------------------------------------------------");
		for(Character k: map.keySet()) {
			System.out.print("\n" + k + " | ");
			System.out.print(map.get(k).values());
		}
		System.out.println("\n");
		
	}

	public Map get_map() {
		return map;
	}
}