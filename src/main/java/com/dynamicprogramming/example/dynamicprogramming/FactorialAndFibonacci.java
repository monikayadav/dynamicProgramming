package com.dynamicprogramming.example.dynamicprogramming;

public class FactorialAndFibonacci {
	public static void main(String[] args) {
		int n = 6;
		printFactorial(n);
		printFabonacci(n);
	}

	private static void printFactorial(int n) {
		int[] fact = new int[n+1];
		fact[1] = 1;
		for(int i = 2; i<=n; i++) {
			fact[i] = i * fact[i-1];
		}
		System.out.println(fact[n]);		
	}
	
	private static void printFabonacci(int n) {
		int[] fab = new int[n+1];
		fab[0] = 0;
		fab[1] = 1;
		for (int i = 2; i<n; i++) {
			fab[i] = fab[i-1] + fab[i-2];
		}
		System.out.println(fab[n-1]);
	}

}
