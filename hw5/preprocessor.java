public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
		
	public preprocessor(String str) {
		initial_string = str;
		preprocessed_string = "";
	}

	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	
	/*
	 * This method capitalizes the initial_string.
	 */
	private void capitalize() {
		initial_string = initial_string.toUpperCase();
	}

	/*
	 * This method cleans the initial_string from non-alphabetic characters.
	 */
	private void clean() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < initial_string.length();i++){
			if(initial_string.charAt(i) >=  65 && initial_string.charAt(i) <= 90 ){
				sb.append(initial_string.charAt(i));
			}
			else if(initial_string.charAt(i) == 'İ'){
				sb.append('I');
			}
		}
		preprocessed_string = sb.toString();
	}
	
	/*
	 * This method returns the preprocessed string.
	 */
	public String get_preprocessed_string() {
		return preprocessed_string;
	}
}