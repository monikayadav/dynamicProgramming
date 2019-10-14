package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class EqualSubsetSumProblem {

	public static void main(String[] args) {
		int[] set = { 3, 1, 1, 2, 2, 1 };
		findEqualSumSet(set);
	}

	private static void findEqualSumSet(int[] set) {
		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}
		System.out.println(sum);
		if (sum % 2 != 0) {
			System.out.println("Sum is not even number");
			return;
		}
		int halfSum = sum / 2;
		boolean[][] dp = new boolean[halfSum + 1][set.length + 1];
		for (int i = 0; i <= set.length; i++) {
			dp[0][i] = true;
		}
		for (int i = 1; i <= halfSum; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= halfSum; i++) {
			for (int j = 1; j <= set.length; j++) {
				if (i - set[j - 1] >= 0) {
					dp[i][j] = dp[i][j - 1] || dp[i - set[j - 1]][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		/**
		 * for (int i = 0; i <= halfSum; i++) { for (int j = 0; j <= set.length; j++)
		 * System.out.print(dp[i][j] + " "); System.out.println(); }
		 **/

		List<Integer> set1 = new ArrayList<Integer>();
		List<Integer> set2 = new ArrayList<Integer>();

		// If partition is not possible
		// print -1 and return.
		if (!dp[halfSum][set.length]) {
			System.out.print("-1\n");
			return;
		}

		// Start from last
		// element in dp table.
		int i = halfSum;
		int j = set.length;

		while (i >= 0 && j > 0) {

			// If current element does
			// not contribute to k, then
			// it belongs to set 2.
			if (dp[i][j - 1]) {
				j--;
				set2.add(set[j]);
			}
			// If current element contribute
			// to k then it belongs to set 1.
			else if (dp[i - set[j - 1]][j - 1]) {
				j--;
				i -= set[j];
				set1.add(set[j]);
			}
		}

		// Print elements of both the sets.
		System.out.print("Set 1 elements: ");
		for (i = 0; i < set1.size(); i++)
			System.out.print(set1.get(i) + " ");

		System.out.print("\nSet 2 elements: ");

		for (i = 0; i < set2.size(); i++)
			System.out.print(set2.get(i) + " ");
	}

}
