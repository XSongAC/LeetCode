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

	// 461. Hamming Distance
	// The problem is basically the same as counting the 1 bits in an integer.
	// int a = 0x0005;
	// int b = 0x0007;
	// bitwise and
	// 0101 & 0111=0101
	// System.out.println("a&b = " + (a & b));
	// bitwise OR
	// 0101 | 0111=0111
	// System.out.println("a|b = " + (a | b));
	// bitwise xor
	// 0101 ^ 0111=0010
	// System.out.println("a^b = " + (a ^ b));
	// bitwise Complement
	// ~0101=1010
	// System.out.println("~a = " + ~a);
	// can also be combined with assignment operator to provide shorthand
	// assignment
	// a=a&b
	public static int hammingDistance(int x, int y) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += (x & 1) ^ (y & 1);
			x = x >> 1;
			y = y >> 1;
		}
		return res;
	}

	// 832. Flipping an Image
	// Time Complexity: , where N is the total number of elements in A.
	// Space Complexity: in additional space complexity.
	public static int[][] flipAndInvertImage(int[][] A) {
		int C = A[0].length;
		for (int[] row : A) {
			for (int i = 0; i < (C + 1) / 2; i++) {
				int temp = row[i] ^ 1;
				row[i] = row[C - 1 - i] ^ 1;
				row[C - 1 - i] = temp;
			}
		}
		return A;

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

		String[] words = { "cend", "asdf", "effe", "wer" };
		int res804 = uniqueMorseRepresentations(words);
		System.out.println("The result of LeetCode problem 804 is : " + res804);

		int a461 = 461;
		int b461 = 234;
		System.out.println("The result of LeetCode problem 461. Hamming Distance is : " + hammingDistance(a461, b461));

		System.out.println("LeetCode problem 832. Flipping an Image: Case is: ");
		int[][] case832 = { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 0, 1 } };

		for (int i = 0; i < case832.length; i++) {
			for (int j = 0; j < case832[i].length; j++) {
				System.out.print(case832[i][j] + " ");
			}
			System.out.println();
		}
		int[][] res832 = flipAndInvertImage(case832);
		System.out.println("The result of LeetCode problem 832. Flipping an Image is : ");
		for (int i = 0; i < res832.length; i++) {
			for (int j = 0; j < res832[i].length; j++) {
				System.out.print(res832[i][j] + " ");
			}
			System.out.println();
		}

	}

}
