package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class FibonacciSet {
	public static void main(String[] args) {
		Integer[] inputList = {0,2,8,5,2,1,4,13,23};
		findFibSubset(inputList);
	}

	private static void findFibSubset(Integer[] inputList) {
		List<Integer> fibList = new ArrayList<Integer>();
		int max = Collections.max(Arrays.asList(inputList));
		int a = 0;
		int b = 1;
		fibList.add(a);
		fibList.add(b);
		while (b < max) {
			int c = a + b;
			a = b;
			b = c;
			fibList.add(c);
		}
		for (int i : Arrays.asList(inputList)) {
			if (fibList.contains(i)) {
				System.out.println(i);
			}
		}

	}
}
