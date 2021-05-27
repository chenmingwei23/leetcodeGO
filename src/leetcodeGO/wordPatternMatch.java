package leetcodeGO;

import java.util.*;

public class wordPatternMatch {
	Map<Character, String> dict = new HashMap<Character, String>();
	
	public boolean wordPatternMatch(String pattern, String s) {
		if(pattern.length() == 0) {
			return s.length() == 0;
		}
		char currentLetter = pattern.charAt(0);
		for(int i = 1; i <= s.length() - pattern.length() + 1; i++) {
			String substring = s.substring(0, i);
			String mapstring = dict.get(currentLetter);
			if ((mapstring != null && substring.equals(mapstring)) || (mapstring == null && !dict.containsValue(substring))){
				System.out.println(currentLetter +" "+substring);
				dict.put(currentLetter, substring);
				if (wordPatternMatch(pattern.substring(1), s.substring(i))) {
					return true;
				} else if (mapstring == null){
					dict.remove(currentLetter);
					
				}
			}
		}
		return false;
    }
	
	public static void main(String args[]) {
		wordPatternMatch s = new wordPatternMatch();
		
		System.out.print(s.wordPatternMatch("abab", "redblueredblue"));
	}
}
