import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;
	
	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		key = _key;
		cipher_text = text;
	}

	/*
	 * This method generates the keystream by repeating the key until it reaches the length of the ciphertext.
	 * Then, it generates the plaintext by using the Vigenere cipher table.
	 * @param void
	 * @return void
	 */
	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}
	/*
	 * This method generates the keystream by repeating the key until it reaches the length of the ciphertext.
	 * @param void
	 * @return void
	 */
	private void generate_keystream() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cipher_text.length(); i++) {
			sb.append(key.charAt(i % key.length()));
		}
		keystream = sb.toString();
	}
	

	/*
	 * This method generates the plaintext by using the Vigenere cipher table.
	 * @param void
	 * @return void
	 */
	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		StringBuilder sb = new StringBuilder();
		Iterator <Character> iter = map.keySet().iterator();
		int i = 0;
		while(iter.hasNext() && i < cipher_text.length()){
			
			char ptc = (char) iter.next();
			
			Iterator <Character>  iter2 = map.get(ptc).keySet().iterator();
			while(iter2.hasNext() && i < cipher_text.length()){
				char c = iter2.next();
				
				// if the keystream and the ciphertext match, append the plaintext character to the stringbuilder
				if( c == keystream.charAt(i) && map.get(ptc).get(c) == cipher_text.charAt(i) ){
					sb.append(ptc);
					
					i++;
					break;
				}
			}
			
			if(iter.hasNext() == false && i != cipher_text.length())	{
				iter = map.keySet().iterator();
			}
		}
		plain_text = sb.toString();

	}


	/**
	 * This method returns the keystream.
	 * @return String
	 */
	public String get_keystream() {
		return keystream;
	}

	/**
	 * This method returns the plaintext.
	 * @return String 
	 */
	public String get_plain_text() {
		return plain_text;
	}
}
