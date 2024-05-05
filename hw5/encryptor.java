import java.util.Map;



public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";
	
	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map = _map;
		plain_text = text;
		key = _key;
	}
	
	/**
	 * This method generates the keystream by repeating the key until it reaches the length of the plaintext.
	 * Then, it generates the ciphertext by using the Vigenere cipher table.
	 */
	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}
	
	/**
	 * This method generates the keystream by repeating the key until it reaches the length of the plaintext.
	 */
	private void generate_keystream() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < plain_text.length(); i++) {
			sb.append(key.charAt(i % key.length()));
		}
		keystream = sb.toString();
	}
	
	/**
	 * This method generates the ciphertext by using the Vigenere cipher table.
	 */
	private void generate_cipher_text() {
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < keystream.length();i++){
			
				sb.append(map.get(keystream.charAt(i)).get(plain_text.charAt((i))));
			
		} 
		cipher_text = sb.toString();
	}

	
	public String get_keystream() {
		return keystream;
	}
	
	public String get_cipher_text() {
		return cipher_text;
	}
}
