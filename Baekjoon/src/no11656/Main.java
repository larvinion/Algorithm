package no11656;

import java.util.*;

public class Main
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		char[] cha = new char[input.length()];
		String[] str = new String[cha.length];
		int cursor = str.length-1;
		
		for(int a=0; a < cha.length;a++){
			str[a] = "";
			
			if(a == 0){
				str[a] += input.charAt(cursor--);
			}else{
				str[a] = input.charAt(cursor--) + str[a-1] ;
			}
		}
		
		Arrays.sort(str);
		
		for(int a=0; a < cha.length;a++){
			System.out.println(str[a]);
		}
	}
}