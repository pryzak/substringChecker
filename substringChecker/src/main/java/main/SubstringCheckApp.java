package main;

import java.util.Scanner;

import checker.SubstringChecker;


public class SubstringCheckApp {
	
    public static void main( String[] args ) {
    	Scanner in = new Scanner(System.in);
    	outer:
    	while(true) {
	    	System.out.println("Enter string: ");
	    	String a = in.nextLine();
	    	System.out.println("Enter substring: ");
	    	String b = in.nextLine();
	    	System.out.println();
	    	boolean isSubstring = SubstringChecker.isSubstring(a, b);
	    	System.out.println(isSubstring ? "b is substring of a" : "b is not substring of a");
	    	System.out.println("check another string? (y/n)");
	    	while(true) {
	    		String c = in.nextLine();
		    	if(c.equals("y")) continue outer;
		    	else if(c.equals("n")) break outer;
	    	}
    	}
    	in.close();
    }
    
}
