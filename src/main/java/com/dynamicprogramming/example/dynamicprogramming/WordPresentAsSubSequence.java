package com.dynamicprogramming.example.dynamicprogramming;

public class WordPresentAsSubSequence {
	public static void main(String[] args) {
		String x = "ABCBDAB";
		String y = "ACAB";
		System.out.print(y + "is present as subsequence : " + findSubSequence(x, y, x.length(), y.length()));
	}

	private static boolean findSubSequence(String x, String y, int m, int n) {
		int[][] DP = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					DP[i][j] = DP[i - 1][j - 1] + 1;
				} else {
					DP[i][j] = DP[i - 1][j];
				}
			}
		}
		return DP[m][n] == n;
	}
}
