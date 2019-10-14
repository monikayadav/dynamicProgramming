package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairWithGivenDifference {

	public static void main(String[] args) {
		Integer[] inputList = { 1, 5, 3, 4, 2 };
		int n = 3;
		findnumPairWithHashMap(inputList, n);
		findnumPairWithBinarySearch(inputList, n);
	}

	private static void findnumPairWithBinarySearch(Integer[] inputList, int n) {
		Arrays.sort(inputList);
		int count = 0;
		int i = 0;
		int j = 0;
		while (j < inputList.length) {
			int k = inputList[j] - inputList[i];
			if (k == n) {
				count++;
				System.out.println(inputList[i] + ", " + inputList[j]);
				i++;
				j++;
			} else if (n > k) {
				j++;
			} else {
				i++;
			}
		}
		System.out.println(count);
	}

	private static void findnumPairWithHashMap(Integer[] inputList, int n) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i : Arrays.asList(inputList)) {
			map.put(i, new ArrayList<Integer>());
		}
		int count = 0;
		for (int i : map.keySet()) {
			List<Integer> numList = map.get(i - n);
			if (numList != null) {
				count++;
				numList.add(i);
			}
		}
		System.out.println(count);
		for (int i : map.keySet()) {
			for (int j : map.get(i)) {
				System.out.println(i + ", " + j);
			}
		}
	}

}
