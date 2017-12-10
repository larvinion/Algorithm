package no1110;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cycleCount = 0;
		int standard = sc.nextInt();
		int divisor = 10;
		
		int nextNumber = standard;
		
		while(standard != nextNumber || cycleCount == 0){
			nextNumber = (nextNumber % divisor) * 10 + ((nextNumber / divisor) + (nextNumber % divisor)) % divisor;
			cycleCount++;
		}
		
		System.out.println(cycleCount);
		
		sc.close();
	}
}
