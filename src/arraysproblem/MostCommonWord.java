package arraysproblem;

import java.util.*;

public class MostCommonWord {

	public static void main(String args[]) {
		String text = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String ban[] = { "hit" };
		System.out.println("The result is : " + mostCommonWord2(text, ban));
	}

	public static String mostCommonWord(String p, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> count = new HashMap<>();
		// remove all puncations // change to lowercase
		String[] words = p.replaceAll("\\pP", "").toLowerCase().split("\\s+");
		//
		for (String w : words) {
			if (!ban.contains(w)) {
				count.put(w, count.getOrDefault(w, 0) + 1);
			}
		}
		return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static String mostCommonWord2(String paragraph, String[] banned) {
		paragraph += ".";
		System.out.println(paragraph);

		Set<String> banset = new HashSet<>();
		for (String word : banned)
			banset.add(word);
		Map<String, Integer> count = new HashMap<>();

		String ans = "";
		int ansfreq = 0;
		System.out.println("ansfreq is : " + ansfreq);

		StringBuilder word = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				System.out.println("finalword is : " + finalword);
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}
		System.out.println("ans is : " + ans);
		return ans;
	}

	class Solution {
		public int maxArea(int[] height) {
			int left = 0;
			int right = height.length - 1;
			int maxArea = 0;
			while (left < right && left >= 0 && right <= height.length - 1) {
				maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

				if (height[left] > height[right]) {
					right--;
				} else {
					left++;
				}
			}
			return maxArea;
		}
	}

	class Solution153Sum {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			Set<List<Integer>> set = new HashSet<>();
			if (nums.length < 3)
				return result;
			Arrays.sort(nums);
			for (int left = 0; left < nums.length - 2; left++) {
				int center = left + 1;
				int right = nums.length - 1;
				while (center < right) {
					int sum = nums[left] + nums[center] + nums[right];
					if (sum == 0)
						set.add(Arrays.asList(nums[left], nums[center], nums[right]));
					if (sum <= 0 && center < right)
						center++;
					if (sum >= 0 && center < right)
						right--;
				}
			}
			return new ArrayList<>(set);
		}
	}

	class _3Sum {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);
			for (int left = 0; left + 2 < nums.length; left++) {
				if (left > 0 && nums[left] == nums[left - 1]) { // skip same result
					continue;
				}
				int center = left + 1, right = nums.length - 1;
				int target = -nums[left];
				while (center < right) {
					if (nums[center] + nums[right] == target) {
						res.add(Arrays.asList(nums[left], nums[center], nums[right]));
						center++;
						right--;
						while (center < right && nums[center] == nums[center - 1])
							center++; // skip same result
						while (center < right && nums[right] == nums[right + 1])
							right--; // skip same result
					} else if (nums[center] + nums[right] > target) {
						right--;
					} else {
						center++;
					}
				}
			}
			return res;
		}
	}
}
