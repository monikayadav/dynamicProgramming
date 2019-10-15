package com.dynamicprogramming.example.dynamicprogramming;

public class LongestPalindromicSubSequence {
	public static void main(String[] args) {
		String x = "XABBDCACBX";
		String y = new StringBuilder(x).reverse().toString();
		int m = x.length();
		int[][] DP = new int[m + 1][m + 1];
		System.out.println("The Length of Longest palindromic sub sequence is " + LCS(x, y, m, m, DP));
		System.out.println("The Longest palindromic sub sequence is :" + logestPalindromicSequence(x, y, m, m, DP));
	}

	private static String logestPalindromicSequence(String x, String y, int m, int n, int[][] DP) {
		if (m == 0 || n == 0) {
			return "";
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return logestPalindromicSequence(x, y, m - 1, n - 1, DP) + x.charAt(m - 1);
		} else if (DP[m - 1][n] > DP[m][n - 1]) {
			return logestPalindromicSequence(x, y, m - 1, n, DP);
		}
		return logestPalindromicSequence(x, y, m, n - 1, DP);
	}

	private static int LCS(String x, String y, int m, int n, int[][] DP) {

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				} else {
					DP[i][j] = Integer.max(DP[i][j - 1], DP[i - 1][j]);
				}
			}
		}
		return DP[m][n];
	}
}
