package com.dynamicprogramming.example.dynamicprogramming;

public class LongestCommonSubString {
	public static void main(String[] args) {
		String X = "ABABC", Y = "BABCA";
		int m = X.length(), n = Y.length();
		System.out.print("The Longest common substring is " + LCS(X, Y, m, n));
	}

	private static String LCS(String x, String y, int m, int n) {
		int[][] DP = new int[m + 1][n + 1];
		int len = 0;
		int index = m;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				}
				if (DP[i][j] > len) {
					len = DP[i][j];
					index = i;
				}
			}
		}
		return x.substring(index - len, index);
	}
}
