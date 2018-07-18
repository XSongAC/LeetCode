package arraysproblem;

import java.util.*;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] a1 = { 11, 23, 58, 79, 719, };
		int[] a2 = { 20, 21, 96 };
		double ans = findMedianSortedArrays3(a1, a2);
		System.out.println("findMedianSortedArrays is: " + ans);

		System.out.println("even number 4 % 2 = " + 4 % 2);

	}
	

	public static int[] mergerArrays(int[] A, int[] B) {
		int i = 0, j = 0;
		int asize = A.length;
		int bsize = B.length;
		int k = 0;
		int[] C = new int[asize + bsize];

		while (i < asize && j < bsize) {
			if (A[i] < B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}
		}

		while (i < asize) {
			C[k++] = A[i++];
		}
		while (j < bsize) {
			C[k++] = B[j++];
		}
		
		List<Integer> templist = new ArrayList<Integer>();
		for(int c :C){
			templist.add(c);
		} 
		System.out.println("mergerArrays function result (templist) C[] = " + templist);
		return C;
	}
	
	
	
	// Use mine own mergeArray function;
	// No use of the Collections.sort;

	public static double findMedianSortedArrays3(int[] A, int[] B) {
		int[] C = mergerArrays(A,B);
		int csize = C.length;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i< csize; i++){
			list.add(C[i]);
		}
		
		int size = list.size();

		System.out.println(list);

		if (size % 2 == 0) {
			int middle = size / 2;
			int before = middle - 1;
			return ((float) list.get(middle) + (float) list.get(before)) / 2;
		}
		return list.get(size / 2);

	}

	// The sorting algorithm is a modified mergesort (in which the merge is
	// omitted if the highest element in the low sublist is less than the lowest
	// element in the high sublist). This algorithm offers guaranteed n log(n)
	// performance.
	public static double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			list.add(A[i]);
		}
		for (int j = 0; j < n; j++) {
			list.add(B[j]);
		}

		Collections.sort(list);
	

		int size = list.size();

		System.out.println(list);

		if (size % 2 == 0) {
			int middle = size / 2;
			int before = middle - 1;
			return ((float) list.get(middle) + (float) list.get(before)) / 2;
		}
		return list.get(size / 2);

	}

	public static double findMedianSortedArrays1(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = iMin + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = iMax - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
}
