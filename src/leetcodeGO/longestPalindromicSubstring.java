	package leetcodeGO;
	
	import java.util.*;
	
	public class longestPalindromicSubstring {
	
	    public static String longestPalindrome(String s) {
	    	String max = s;
	    	int len = s.length();
	    	boolean[][] isPalindrome= new boolean[len][len];
	    	for (int i = 0; i<len;i++) {
	    		char [] temp;
	    		for (int j = len - 1; j >= i;j -- ) {
	    			if (s.charAt(j)!=s.charAt(i)) {
	    				continue;
	    			}
	    			temp = s.substring(i, j+1).toCharArray(); 
	    		}
	    	}
	    	return max;
	    }
	    
		public static void main(String args[]) {
			String s = "ab";
			System.out.println(longestPalindrome(s));
		}
	}
	
