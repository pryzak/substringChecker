package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import checker.SubstringChecker;

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
		assertEquals(true, SubstringChecker.isSubstring("test", "*t**e**s*****t*"));
		assertEquals(true, SubstringChecker.isSubstring("it is very long long long long long long test", "it * test"));
		assertEquals(true, SubstringChecker.isSubstring("a*bcd\\", "a\\*bc"));
		assertEquals(true, SubstringChecker.isSubstring("\\abcde*sdaf\\*s", "\\a*\\*sda"));
		assertEquals(true, SubstringChecker.isSubstring("a*aaa*a", "*a\\*"));
		assertEquals(true, SubstringChecker.isSubstring("\\lorem ipsum *", "*m \\*"));
		assertEquals(true, SubstringChecker.isSubstring(" dy\\*nami c", "*dy\\\\**"));
		assertEquals(true, SubstringChecker.isSubstring(" dy\\*nami c", "*dy*\\*nami c"));
		assertEquals(true, SubstringChecker.isSubstring("123*45", "1*\\*4**"));
		assertEquals(true, SubstringChecker.isSubstring("*1", "\\*"));
		assertEquals(true, SubstringChecker.isSubstring("*1", "\\**"));
		assertEquals(true, SubstringChecker.isSubstring("*1", "\\*1*"));
		assertEquals(true, SubstringChecker.isSubstring(" * @", "\\**"));
		assertEquals(true, SubstringChecker.isSubstring(" * @", "\\**@*"));
		assertEquals(true, SubstringChecker.isSubstring("//*//", "//\\**"));
		assertEquals(true, SubstringChecker.isSubstring("a * rr !", "a \\** !"));
		assertEquals(true, SubstringChecker.isSubstring("***", "\\*"));
		assertEquals(true, SubstringChecker.isSubstring("***", "\\*\\*\\*"));
		assertEquals(true, SubstringChecker.isSubstring("***", "\\**\\*\\*"));
		assertEquals(true, SubstringChecker.isSubstring("a*rr\\*", "a\\**\\\\*"));
		assertEquals(true, SubstringChecker.isSubstring("\\\\*", "\\\\\\*"));
		assertEquals(true, SubstringChecker.isSubstring("f1ni$ *h \\", " \\*h "));

		assertEquals(false, SubstringChecker.isSubstring("abcd", "abd*"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "acd*"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "acd"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "abd"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "bcde"));
		assertEquals(false, SubstringChecker.isSubstring("abcd", "*abd"));
		assertEquals(false, SubstringChecker.isSubstring("zAq!@wSXxq\\", "q!*Q"));
		assertEquals(false, SubstringChecker.isSubstring("lorem\\ipsum", "lorem\\*ipsum"));
		assertEquals(false, SubstringChecker.isSubstring(" dy\\*nami c", "*dy*\\*namic"));
		assertEquals(false, SubstringChecker.isSubstring("\\\\\\", "\\*"));
		assertEquals(false, SubstringChecker.isSubstring("\\\\abcde*sdaf\\\\*s", "\\\\a*\\\\*sda"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testException() {
		
		SubstringChecker.isSubstring("abc", "abcd");
	}
	
}
