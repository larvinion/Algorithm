package no2420;

import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println(BigInteger.valueOf(sc.nextInt()).subtract(BigInteger.valueOf(sc.nextInt())).abs());
		
		sc.close();
	}
}
