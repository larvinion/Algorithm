package no2750;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[] list = new int[testCase];
		
		for(int i=0; i<testCase; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		for(int number : list) {
			System.out.println(number);
		}
	}
}