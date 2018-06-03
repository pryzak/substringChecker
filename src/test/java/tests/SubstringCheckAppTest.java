package tests;

import main.SubstringChecker;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringCheckAppTest {

	
	@Test
	public void testComparator() {
		assertEquals(true, SubstringChecker.isSubstring("abcd", "abcd"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "bc"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "a*c"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "a*d"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "*c*"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "a*c*"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "*abcd"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "*abcd*"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "abcd*"));
		assertEquals(true, SubstringChecker.isSubstring("abcd", "*"));

		assertEquals(false, SubstringChecker.isSubstring("abcd", "abd*"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "acd*"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "acd"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "abd"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "bcde"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "*abd"));

	}
	
	@Test(expected=RuntimeException.class)
	public void testException() {
		SubstringChecker.isSubstring("abc", "abcd");
	}
	
}
