package arraysproblem;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String as = "ashjgkjghjgjhgjadpiowefweesfsewdashdbd";
		int a1 = lengthOfLongestSubstring3(as);
		System.out.print("lengthOfLongestSubstring3 is: " + a1);

	}

	// Approach 3
	// This would only require n steps
	// define a mapping of the characters to its index, skip the characters
	// immediately when we found a repeated character.
	// the s[j] have a duplicate in the range[i,j) with index j', we don't need
	// to increase i little by little
	// we can skip all the elements in the range[i,j'] and let i to be j'+1
	// directly
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of
														// character
		// try to extend the range[i,j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}

		return ans;

	}

	// Approach 2 Sliding window
	// Requires at most 2n steps.
	// Time Complexity: O(2n) = O(n), In the worst case each character will be
	// visited twice bny i and j;
	// Space complexity: O(min(m,n));
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i,j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	// Brute Force with O(n^3) time
	// Space complexity: O(min(n,m)) O(k) space for checking a substring has no
	// duplicate characters, k is the size of Set
	// The size of the set is upper bounded by the size of the string n and the
	// size of the chatset/aplhabet m
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

}
