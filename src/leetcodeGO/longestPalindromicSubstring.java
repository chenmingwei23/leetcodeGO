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
	    		//System.out.print(i+" "+sequence[i]+" ");
	    		while (forward >0 && backward < 2*s.length() - 2) {
	    			forward --;
    				backward ++;
	    			if (sequence[forward] != sequence[backward]) {
	    				if (i == 4) {
		    				//System.out.print("forward:"+forward + " backward:"+ backward +" ");
		    			}
	    				forward ++;
	    				backward --;
	    				break;
	    			}
	    			if (i == 4) {
	    				//System.out.print("forward:"+forward + " backward:"+ backward +" ");
	    			}
	    			
	    			
	    		}
	    		//System.out.println(forward + " " + backward+" ");
	    		if(sequence[forward] != '#') {
	    			if (s.substring(forward/2, backward/2 + 1).length() > max.length()) {
		    			max = s.substring(forward/2, backward/2 + 1);
		    			//System.out.println("forward:"+forward + " backward:"+ backward +" ");
	    			}
	    			
	    		} else if (sequence[forward] == '#') {
	    			if (s.substring((forward+1)/2, (backward-1)/2 + 1).length() > max.length()) {
		    			max = s.substring((forward+1)/2, (backward-1)/2 + 1);
		    			//System.out.println("forward:"+forward + " backward:"+ backward +" ");
	    			}
	    		}
	    	}
	    	
	    	return max;
	    }
	    
		public static void main(String args[]) {
			String s = "cbbcdddd";
			System.out.println(longestPalindrome(s));
		}
	}
	
