package no11720;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
	
		int numbers = sc.nextInt();
		int result = 0;
		
		sb.append(sc.next());
		
		for(int i=0; i<numbers; i++){
			result += Integer.parseInt(sb.substring(i, i+1));
		}
		System.out.println(result);
		
		sc.close();
	}
}
