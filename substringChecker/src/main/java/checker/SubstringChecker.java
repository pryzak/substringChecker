package checker;

import java.util.ArrayList;
import java.util.List;

public class SubstringChecker {

	/**
	 * Verifies if string b is substring of a.
	 * 
	 * Each occurrence of '*' in the second substring means that it can be a
	 * match for zero or more characters of the first string.
	 * 
	 * Additionally asterisk (*) may be considered as a regular character, if it
	 * is preceded by a backslash (\). Backslash (\) is considered as a regular
	 * character in all cases other than preceding the asterisk (*).
	 * 
	 * @param a
	 *            whole string
	 * @param b
	 *            substring
	 * @return true if a is substring of b, in other case false
	 * @throws RuntimeException
	 *             when substring is longer than whole string
	 */
	public static boolean isSubstring(String a, String b) throws RuntimeException {

		return isSubstring(null, a, b);
	}

	private static boolean isSubstring(Integer startIndex, String a, String b) throws RuntimeException {

		if (startIndex == null) {
			startIndex = 0;
		}

		List<Integer> asteriskPos = new ArrayList<>();
		List<Integer> escapingSlashPos = new ArrayList<>();

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '*' && (i == 0 || b.charAt(i - 1) != '\\')) {
				asteriskPos.add(i);
			} else if (b.charAt(i) == '\\' && i < b.length() - 1 && b.charAt(i + 1) == '*') {
				escapingSlashPos.add(i);
			}
		}

		if (asteriskPos.size() == b.length()) {
			return true;
		}

		if (b.length() - asteriskPos.size() - escapingSlashPos.size() > a.length()) {
			throw new RuntimeException("Substring is longer than string");
		}

		// pominięte backslashe
		int pastBackslashes = 0;

		for (int i = startIndex; i < a.length(); i++) {
			for (int j = 0; j < b.length();) {
				
				// jeśli gwiazdka, to pomijamy kolejne gwiazdki i sprawdzamy
				// tylko pozostałą część
				if (asteriskPos.contains(j)) {
					while (j < b.length() - 1) {
						if (b.charAt(j + 1) == '*') {
							j++;
						} else
							break;
					}
					return isSubstring(startIndex, a, b.substring(j + 1));
				}

				// koniec stringa 'a', nie znaleziono substringa
				if (i + j - pastBackslashes >= a.length()) {
					return false;
				}

				// znaki pasują
				if (a.charAt(i + j - pastBackslashes) == b.charAt(j) && !escapingSlashPos.contains(j)) {
					
					// koniec stringa, wszystko pasuje
					if (j >= b.length() - 1) {
						return true;
					}
					j++;
					
				// jeśli gwiazdka w miejscu \*
				} else if (a.charAt(i + j - pastBackslashes) == '*' && escapingSlashPos.contains(j)) {
					
					// koniec stringa, wszystko pasuje
					if (j + 1 >= b.length() - 1) {
						return true;
					}
					j += 2;
					pastBackslashes++;
				} else {
					// nie znaleziono pasującego znaku, przechodzimy do natępnego znaku z 'a'
					break;
				}
			}
		}

		return false;
	}

}
