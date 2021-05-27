package leetcodeGO;

import java.util.*;

public class solution {
	public static boolean correction(String s) {
		
		// /YYYYMMDD/[a-z0-9]+/hhmmss
		// 判断开头是否是/
		
		int pointer = 0;
		if (s.charAt(pointer) != '/') {
			return false;
		}
		pointer ++;
		
		String[] corpus = s.split("/");
		if (corpus.length < 3) {
			return false;
		}
		
		for (int index = 0; index <3; index ++) {
			char [] cur = corpus[index].toCharArray();
			System.out.println(corpus[index]);
			
			//判断年份
			if (index == 1) {
				int yearInt = 0;
				for (int i = 0; i < 4; i++) {
					yearInt += (int) (((int)cur[i] - 48)*Math.pow(10,3-i));
					System.out.println(cur[i]);
					if (yearInt < 2018 || yearInt > 2020) {
						System.out.println("年");
						return false;
					}
				}
				
				//判断月份
				int monthInt = 0;
				for (int i = 4; i < 6; i ++) {
					monthInt += ((int)cur[i] - 48)*Math.pow(10, 1-i);
					if (monthInt < 1 || monthInt > 12) {
						System.out.println("月");
						return false;
					}
				}
				
				//判断天
				int dayInt = 0;
				int [] bigMonth = {1,3, 5, 7, 8, 10, 12};
				int [] smallMonth = {4, 6, 9, 11};
				for (int i = 6; i < 8; i ++) {
					dayInt += ((int)cur[i] - 48)*Math.pow(10, 1-i);
					for (int j : bigMonth) {
						if (monthInt == j) {
							if (dayInt>31 || dayInt <= 0) {
								System.out.println("天");
								return false;
							}
						}else if (monthInt == 2 && yearInt == 2020){
							if (dayInt>29 || dayInt <= 0) {
								System.out.println("天");
								return false;
							}
						} else if (monthInt == 2 && yearInt != 2020) {
							if (dayInt>28 || dayInt <= 0) {
								System.out.println("天");
								return false;
							}
						} else {
							if (dayInt>30 || dayInt <= 0) {
								System.out.println("天");
								return false;
							}
						}
					}
				}
			}
			
			if (index == 2) {
				// 判断文件名
				if (!corpus[index].contains("[a-z0-9]")) {
					System.out.println("文件名");
					return false;
				}
			}
			
			if (index == 3) {
				// 判断时间
				int hour = 0, minute = 0 , second = 0;
				for (int i = 0; i < 2; i ++) {
					hour += ((int)cur[i] - 48)*Math.pow(10,1-i);
				}
				if (hour < 0 || hour > 23) {
					System.out.println("时间");
					return false;
				}
				
				for (int i = 2; i < 4; i ++) {
					minute += ((int)cur[i] - 48)*Math.pow(10,1-i);
				}
				if (minute < 0 || minute > 59) {
					System.out.println("时间");
					return false;
				}
				
				for (int i = 4; i < 6; i ++) {
					second += ((int)cur[i] - 48)*Math.pow(10,1-i);
				}
				if (second < 0 || second > 59) {
					System.out.println("时间");
					return false;
				}
			}
			
			
		}
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(correction("/20200716/a/171717"));
	}
}
