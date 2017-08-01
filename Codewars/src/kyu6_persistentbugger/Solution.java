package kyu6_persistentbugger;

public class Solution{
	static class Persist {
		public static int persistence(long n) {
			// your code
			long temp = n;
			int count = 0;
			
			while(temp > 9){
				temp = count(temp);
				count++;
			}
			
			return count;
			
		}
		
		public static long count(long input){
			long temp = input;
			long result = 1;
			
			while(temp > 0){
				result *= temp%10;
				temp /= 10;
			}
			
			if(result != 0)
				return result;
			else
				return 0;
		}
	}
}
