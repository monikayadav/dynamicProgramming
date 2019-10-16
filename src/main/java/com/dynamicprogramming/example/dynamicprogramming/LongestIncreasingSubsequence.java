package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		findLIS(arr);
	}

	private static void findLIS(int[] arr) {
		List<List<Integer>> lis = new ArrayList<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			lis.add(i, new ArrayList<Integer>());
		}
		lis.get(0).add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis.get(j).size() > lis.get(i).size()) {
					lis.set(i, new ArrayList<Integer>(lis.get(j)));
				}
			}
			lis.get(i).add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println("LIS[" + i + "] - " + lis.get(i));
		}
		// find the longest sequence
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (lis.get(i).size() > lis.get(j).size()) {
				j = i;
			}
		}
		System.out.print("Longest sequence is : " + lis.get(j));
	}
}
