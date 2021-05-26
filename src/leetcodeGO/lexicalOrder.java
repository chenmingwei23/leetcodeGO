package leetcodeGO;

import java.util.*;

public class lexicalOrder {
	static void dfs(int n, int parent, List<Integer> result) {	
		int now = parent * 10;
		for (int i  = 0; i < 10; i++) {
			if (now + i > n) {
				return;
			}
			else {
				System.out.println(now+i);
				result.add(now+i);
				dfs(n, now + i, result);	
			}
		}
		return;
		
	}
	static public List<Integer> lexicalOrder(int n) {
		
		
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			if (i > n) {
				break;
			}else {
				System.out.println(i);
				result.add(i);
				dfs(n,i, result);
			}
		}

		return result;
    }
	
	public static void main(String args[]) {
		int n = 111;
		List<Integer> res = lexicalOrder(n);
		for (int i : res) {
			System.out.println(i);
		}
	}
}	
