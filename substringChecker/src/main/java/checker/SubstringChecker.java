package checker;

public class SubstringChecker {

	/**
	 * Checks if string b is substring of a.
	 * Each ocurrence of *
	 * 
	 * @param a whole string
	 * @param b substring
	 * @return
	 * @throws RuntimeException
	 */
	public static boolean isSubstring(String a, String b) throws RuntimeException {
		
		int count = 0;
		if (b.length() > a.length()) {
			for(char c : b.toCharArray()) {
				if(c != '*') count++;
			}
			if(count > a.length())
				throw new RuntimeException("substring is longer than string");
		}
		
		//zliczamy wystąpienia '*'
		int stars = 0;
		for (int j = 0; j < b.length(); j++) {
			if(b.charAt(j) == '*') {
				stars ++;
			}
		}
		if(stars == b.length()) {
			return true;
		}
		
		//pomijamy '*' jeśli są na początku substringa
		//s to indeks początkowy
		int s = 0;
		for (int j = 0; j < b.length(); j++) {
			if(b.charAt(j) == '*') {
				s = j + 1;
			}
			else break;
		}
		
		//pomijamy '*' jeśli są na końcu substringa
		//e to indeks końcowy
		int e = b.length() - 1;
		for (int j = b.length() - 1; j >= 0; j--) {
			if(b.charAt(j) == '*') {
				e = j - 1;
			}
			else break;
		}
		
		for (int i = 0; i <= a.length() - (b.length() - stars); i++) {
			for (int j = s; j <= e; ) {
				//znaki pasują
				if (a.charAt(i + j - s) == b.charAt(j) || b.charAt(j) == '*') {
					//koniec stringa
					if (j == e) {
						return true;
					}
					j++;
				} else {
					//poprzedni znak to '*'
					if(j > 0 && b.charAt(j - 1) == '*' && j >= s) {
						//koniec stringa
						if (j == e) {
							return true;
						}
						else if(i < a.length() - 1) {
							i++;
						}
						else {
							return false;
						}
					}
					else {
						break;
					}
				}
			}
		}
		return false;
	}

}
