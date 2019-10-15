package com.dynamicprogramming.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSequence {
	public static void main(String[] args) {
		String x = "ABCBDAB";
		String y = "BDCABA";
		System.out.print("The length of LCS is " + findLCS(x, y, x.length(), y.length()));
	}

	public static Set<String> findLCS(String x, String y, int m, int n) {
		int[][] DP = new int[m + 1][n + 1];
		LCSLength(x, y, m, n, DP);
		List<String> lcs = LCS(x, y, x.length(), y.length(), DP);
		return new HashSet<>(lcs);

	}

	public static List<String> LCS(String x, String y, int m, int n, int[][] DP) {
		if (m == 0 || n == 0) {
			return new ArrayList<>(Collections.nCopies(1, ""));
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			List<String> lcs = LCS(x, y, m - 1, n - 1, DP);
			for (int i = 0; i < lcs.size(); i++) {
				lcs.set(i, lcs.get(i) + (x.charAt(m - 1)));
			}
			return lcs;
		}
		if (DP[m - 1][n] > DP[m][n - 1]) {
			return LCS(x, y, m - 1, n, DP);
		}
		if (DP[m - 1][n] < DP[m][n - 1]) {
			return LCS(x, y, m, n - 1, DP);
		}
		List<String> top = LCS(x, y, m - 1, n, DP);
		List<String> left = LCS(x, y, m, n - 1, DP);

		top.addAll(left);
		return top;
	}

	/**
	 * 				|0 									if i==0 or j==0 <br>
	 * LCS[i][j] =  |LCS[i-1][j-1] +1 					if x[i-1] == y[j-1] <br>
	 * 				|max (LCS[i][j-1], LCS[i-1][j]) 	if x[i-1] != y[j-1] <br>
	 */
	private static int LCSLength(String x, String y, int m, int n, int[][] DP) {
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				} else {
					DP[i][j] = Integer.max(DP[i - 1][j], DP[i][j - 1]);
				}
			}
		}
		return DP[m][n];
	}
}
