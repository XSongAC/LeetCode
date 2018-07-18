package arraysproblem;

import java.util.*;
//import java.util.Map.Entry;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		String as = "ashjgkaaababagjadpiofwefwesfsewfdasaba";
		String a1 = "abA";
		System.out.println("Is this String palindrom1? " + isPalindrom1(as));
		System.out.println("Is this String palindrom2? " + isPalindrom2(a1));
		System.out.println("TEST: " + longestPalindrome(as));

		return;

	}

	// dp(i, j) represents whether s(i ... j) can form a palindromic substring,
	// dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a
	// palindromic substring. When we found a palindrome, check if it's the
	// longest one. Time complexity O(n^2).
	public static String longestPalindrome(String s) {
		int n = s.length();
		String res = null;
		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				// if the length of the substring is less than 3 and your
				// character at ith position is same as jth position, then you
				// know that substring is a palindrome for sure
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}

	// optimization of space complexity to O(n)
	public static String longestPalindrome2(String s) {
		int n = s.length();
		String result = "";
		boolean[] dp = new boolean[n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= i; j--) {
				dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
				if (dp[j] && (result.equals("") || j - i + 1 > result.length())) {
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}

	public static boolean isPalindrom1(String s) {
		String clean = s.toLowerCase();
		int length = clean.length();
		int forward = 0;
		int backward = length - 1;
		while (backward > forward) {
			char fchar = clean.charAt(forward++);
			char bchar = clean.charAt(backward--);
			if (fchar != bchar) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrom2(String s) {
		String clean = s.toLowerCase();
		return recursiveHelper(clean, 0, clean.length() - 1);
	}

	public static boolean recursiveHelper(String s, int forward, int backward) {
		if (forward == backward) {
			return true;
		}
		if (s.charAt(forward) != s.charAt(backward)) {
			return false;
		}
		if (forward < backward + 1) {
			return recursiveHelper(s, forward + 1, backward - 1);
		}
		return true;
	}

	public boolean isMatch(String text, String pattern) {
		if (pattern.isEmpty()) {
			return text.isEmpty();
		}

		boolean first_match = (!text.isEmpty()) && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
		} else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	public String mostCommonWord(String p, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> count = new HashMap<>();
		// remove all puncations // change to lowercase
		String[] words = p.replaceAll("\\pP", "").toLowerCase().split("\\s+");
		//String res = "";
		for (String w : words) {
			if (!ban.contains(w)) {
				count.put(w, count.getOrDefault(w, 0) + 1);
			}
		}
		return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
