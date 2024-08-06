package com.java.exceptions.practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Divident: ");
		int divident = sc.nextInt();
		
		System.out.println("Divisor: ");
		int divisor = sc.nextInt();
		
		try {
			
			if(divisor == 0)
				throw new DivideByZeroException("Divide by 0");
			
			double result = ((double)divident/(double)divisor);
			System.out.println("Result: " + result);
			
		}
		
		catch (DivideByZeroException e) {
			System.out.println(e);
		}
		
		finally {
			sc.close();
		}		
		
	}

}
