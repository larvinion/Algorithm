package kyu6_playingwithdigits;

public class Solution {
	public static long digPow(int n, int p) {
		int total = 0;
		int number = n;
		int exponent = p;
		int count = 1;
		
		int[] array = new int[Integer.toString(n).length()];
		
		for(int i=0; i<array.length; i++){
			array[i] = number % 10;
			number /= 10;
			array[i] = (int)Math.pow(array[i], exponent+array.length-1-i);
			total += array[i];
		}
		
		while(n*count <= total){
			if(n*count == total)
				return count;
			count++;
		}
		
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println(digPow(89, 1));
		System.out.println(digPow(92, 1));
		System.out.println(digPow(695, 2));
		System.out.println(digPow(46288, 3));
	}

}
