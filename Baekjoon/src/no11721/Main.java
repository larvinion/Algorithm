package no11721;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		int charAt = 10;

		if(sb.length() <= charAt)
			System.out.println(sb.substring(0, sb.length()));
		else{
			System.out.println(sb.substring(0, charAt));
			
			while(sb.length() > charAt){
				sb.delete(0, charAt);
				
				if(sb.length() > charAt)
					System.out.println(sb.substring(0, charAt));
				else
					System.out.println(sb.substring(0, sb.length()));
			}
		}
		
		sc.close();
	}
}
