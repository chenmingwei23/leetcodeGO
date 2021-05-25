	package leetcodeGO;
	
	import java.util.*;
import java.util.stream.Collectors;
	
	public class longestPalindromicSubstring {
	
	    public static String longestPalindrome(String s) {
	    	String max = "";
	    	int maxLength = 0;
	    	char [] sequence = new char[2 * s.length() - 1];
	    	for (int i = 0; i <s.length(); i ++) {
	    		sequence[2*i] = s.charAt(i);
	    		if (2*i+1 >= 2 * s.length() - 1) {
	    			break;
	    		}
	    		sequence[2*i+1] = '#';
	    	}
	    	
	    	for (int i = 0; i < 2*s.length() - 1; i ++ ) {
	    		int forward = i;
	    		int backward = i;
	    		ArrayList<Character> temp = new ArrayList<>();
	    		System.out.print(i+" "+sequence[i]+" ");
	    		while (forward >0 && backward < 2*s.length() - 2) {
	    			if (sequence[forward] != sequence[backward]) {
	    				break;
	    			}
	    			forward --;
    				backward ++;
	    			
	    		}
	    		System.out.println(forward + " " + backward+" ");
	    		if(backward - forward > maxLength) {
	    			maxLength = backward - forward;
	    			max = s.substring(forward/2, backward/2 + 1);
	    		}
	    	}
	    	
	    	return max;
	    }
	    
		public static void main(String args[]) {
			String s = "babad";
			System.out.println(longestPalindrome(s));
		}
	}
	
