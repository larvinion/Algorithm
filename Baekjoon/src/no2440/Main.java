package no2440;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		for(;count>0;count--){
			for(int star=count;star>0;star--)
				System.out.print("*");
			System.out.println();
		}
	}
}