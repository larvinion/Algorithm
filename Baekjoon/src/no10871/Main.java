package no10871;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int numbers = sc.nextInt();
		int standard = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<numbers; i++){
			int temp = sc.nextInt();
			
			if(temp < standard){
				sb.append(temp + " ");
			}
		}
		System.out.println(sb.substring(0, sb.length()-1));
		
		sc.close();
	}
}