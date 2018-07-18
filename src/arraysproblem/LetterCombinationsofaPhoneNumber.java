package arraysproblem;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();

		if (digits.length() == 0)
			return result;

		result.add("");
		for (int i = 0; i < digits.length(); i++)
			result = combine(digitletter[digits.charAt(i) - '0'], result);

		return result;
	}

	public static List<String> combine(String digit, List<String> l) {
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < digit.length(); i++)
			for (String x : l)
				result.add(x + digit.charAt(i));

		return result;
	}

	public static List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

	// A version without first loop, but same time complexity.
	// Both are single queue BFS solutions.
	public static List<String> letterCombinations3(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		while (ans.peek().length() != digits.length()) {
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length()) - '0'];
			for (char c : map.toCharArray()) {
				ans.addLast(remove + c);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String t1 = "98";
		List<String> pout = letterCombinations3(t1);
		System.out.println(Arrays.toString(pout.toArray()));

	}

}
