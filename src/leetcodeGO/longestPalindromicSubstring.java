package leetcodeGO;

import java.util.*;

public class longestPalindromicSubstring {
	
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		}
		else if (s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		} 
		return isPalindrome(s.substring(1, s.length()-1));
	}
	
    public static String longestPalindrome(String s) {
    	String max = "";
    	for (int i = 0; i < s.length(); i ++) {
    		if(s.length() - i<=max.length()){
    			return max;
    		}
    		for (int j = s.length() - 1; j>=i ; j--) {
    			if( j - i <= max.length()){
    				break;
    			}
    			if (s.charAt(i) == s.charAt(j)) {
    				if (isPalindrome(s.substring(i, j+1))){
    					if (j - i>=max.length()){
    						System.out.println(s.substring(i, j+1));
        					max = s.substring(i, j+1);
        					break;
    					}
    				}
    			}
    		}
    		
    	}
        return max;
    }
    
	public static void main(String args[]) {
		String s = "aba";
		System.out.println(isPalindrome(s));
	}
}

