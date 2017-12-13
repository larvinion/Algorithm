package no1463;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int count = 0;
		
		HashMap<Integer, LinkedBlockingQueue<Integer>> map = new HashMap<Integer, LinkedBlockingQueue<Integer>>();
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		LinkedBlockingQueue<Integer> tempQueue;
		
		queue.add(number);
		map.put(count, queue);
		
		while(true){
			queue = map.get(count);
			if(queue.contains(1))
				break;
			
			tempQueue = new LinkedBlockingQueue<Integer>();
			while(!queue.isEmpty()){
				number = queue.poll();
				
				if(number % 3 == 0)
					tempQueue.add(number/3);
				if(number % 2 == 0)
					tempQueue.add(number/2);
				tempQueue.add(number-1);
			}
			
			map.put(++count, tempQueue);
		}
		
		System.out.println(count);
	}
}
