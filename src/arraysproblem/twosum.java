package arraysproblem;

import java.util.Arrays;

public class twosum {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 11, 7, 23, 1234, 234 };
		int target = 3;
		int l= 1;
		int r =2;
		System.out.println("The two candidates index are : " + new int[] { l, r });
		System.out.println("nums: " + Arrays.toString(nums) + " and Target value is : " + target);
		System.out.println("Check boolean value: " + hasArrayTwoCandidates(nums, target));
		
		if (hasArrayTwoCandidates(nums, target))
			System.out.println("Array has two " + "elements with given sum");
		
		else
			System.out.println("Array doesn't have " + "two elements with given sum");
		// twoSum(nums,target);

	}

	public static int[] twoSum(int[] nums, int target) {

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nums[i] + nums[j] == target) {
				}
			}
		}
		System.out.println("Keyipao");
		throw new IllegalArgumentException("TTTTTTTTTT No two sum solution");
	}

	public static boolean hasArrayTwoCandidates(int[] A, int target) {
		int l, r;
		// sort the array
		Arrays.sort(A);

		// now looking for the two candidates in the sorted array
		l = 0;
		r = A.length - 1;
		while (l < r) {
			if (A[l] + A[r] == target) {
				return true;
			} else if (A[l] + A[r] < target) {
				l++;
			} else {
				r--;
			}
		}
		twoSum(A,target);
		System.out.println("The two candidates index are : " + l + "  " +r);
		return false;
	}

}