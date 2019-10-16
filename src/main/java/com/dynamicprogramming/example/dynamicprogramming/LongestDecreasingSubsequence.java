package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestDecreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		findLDS(arr);
	}

	private static void findLDS(int[] arr) {
		List<List<Integer>> lds = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			lds.add(i, new ArrayList<Integer>());
		}
		lds.get(0).add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[j] > arr[i] && lds.get(i).size() < lds.get(j).size()) {
					lds.set(i, new ArrayList<>(lds.get(j)));
				}
			}
			lds.get(i).add(arr[i]);
		}
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (lds.get(i).size() > lds.get(j).size()) {
				j = i;
			}
		}
		System.out.print("Shortest sequence is : " + lds.get(j));

	}
}
