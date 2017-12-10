package no10988;

import java.util.*;

public class Main
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int felend = 0; 
		
		char[] cha = new char[str.length()];
		char[] cha2 = new char[str.length()];
		
		int cursor = str.length()-1;
		
		for(int i = 0; i < str.length(); i++){
			cha[i] = str.charAt(i);
			cha2[cursor--] = cha[i]; 
		}
		
		for(int i = 0; i < str.length(); i++){
			if(cha[i] != cha2[i]){
				felend = 0;
				break;
			}
			else{
				felend =1;
			}
		}
		
		System.out.println(felend);
		
		sc.close();
	}
}

