package test;

import java.util.Scanner;

public class Day1 {
	
	public static void main(String[] args){
		int flag = 1;
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			System.out.println(addDigits(num));
		}
		
	}
	
	public static int addDigits( int num ){
		int sum = num;
		while( sum >= 10 ){
			sum = cal(sum);
		}
		return sum;
	}
	
	public static int cal( int num ){
		int sum = 0;
		while( num > 0 ){
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}
	
}
