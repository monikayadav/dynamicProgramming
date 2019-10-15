package com.dynamicprogramming.example.dynamicprogramming;

public class LongestRepeatedSequence {
	public static void main(String[] args) {
		String x = "ATACTCGGA";

		int[][] DP = new int[x.length() + 1][x.length() + 1];
		LRSLength(x, DP);
		System.out.println(LRS(x, x.length(), x.length(), DP));
	}

	private static String LRS(String x, int m, int n, int[][] DP) {
		if (m == 0 || n == 0) {
			return "";
		}
		if (x.charAt(m - 1) == x.charAt(n - 1) && m != n) {
			return LRS(x, m - 1, n - 1, DP) + x.charAt(m - 1);
		}
		if (DP[m - 1][n] > DP[m][n - 1]) {
			return LRS(x, m - 1, n, DP);
		} else {
			return LRS(x, m, n - 1, DP);
		}
	}

	private static void LRSLength(String x, int[][] DP) {

		for (int i = 1; i <= x.length(); i++) {
			for (int j = 1; j <= x.length(); j++) {
				if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				} else {
					DP[i][j] = Integer.max(DP[i - 1][j], DP[i][j - 1]);
				}
			}
		}

	}
}
