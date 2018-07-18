package arraysproblem;

import java.util.*;

public class LeetCodeSolutions {

	// LeetCode 771
	public static int numJewelsInStones(String J, String S) {
		int res = 0;
		Set<Character> setJ = new HashSet<>();
		for (char j : J.toCharArray()) {
			setJ.add(j);
		}
		for (char s : S.toCharArray()) {
			if (setJ.contains(s)) {
				res++;
			}
		}
		return res;

	}

	// LeetCode 760. Find Anagram Mappings
	// Time Complexity: O(N), where N is the length of A.
	// Space Complexity: O(N).
	public static int[] anagramMappings(int[] A, int[] B) {
		Map<Integer, Integer> D = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			D.put(B[i], i);
		}
		int[] ans = new int[A.length];
		int t = 0;
		for (int x : A) {
			ans[t++] = D.get(x);
		}
		return ans;
	}

	// 709. To Lower Case
	public static String toLowerCase(String str) {
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";

		char[] s = str.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (upper.contains(str.substring(i, i + 1))) {
				s[i] = lower.charAt(upper.indexOf(s[i]));
			}
		}
		return new String(s);
	}

	// 804. Unique Morse Code Words
	// Time Complexity: O(S), where S is the sum of the lengths of words in
	// words.
	// We iterate through each character of each word in words.
	// Space Complexity: O(S).
	public static int uniqueMorseRepresentations(String[] words) {
		String[] d = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		HashSet<String> s = new HashSet<>();
		for (String word : words) {
			String code = "";
			for (char c : word.toCharArray())
				code += d[c - 'a'];
			s.add(code);
		}
		return s.size();
	}

	public static void main(String args[]) {
		String J = "C";
		String S = "aAAbBbBBC";
		int res771 = numJewelsInStones(J, S);
		System.out.println("res771 is: " + res771);

		int[] A = { 1, 2, 3 };
		int[] B = { 2, 3, 1 };
		int ans[] = anagramMappings(A, B);
		System.out.println("The result of LeetCode problem 760 is : ");
		System.out.println(Arrays.toString(ans));
		
		
		String[] words = {"cend","asdf","effe","wer"};
		int res804 = uniqueMorseRepresentations(words);
		System.out.println("The result of LeetCode problem 804 is : " + res804);
		

	}
}
