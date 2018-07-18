package arraysproblem;

import java.util.*;

public class quickSortStudies {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		System.out.println(Arrays.toString(arr));
		printArray(arr);
		int high = arr.length;
		quickSort(arr, 0, high - 1);
		System.out.println("After quicksort : " + Arrays.toString(arr));

	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);

		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);

		return i + 1;
	}

	// a swap function
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// A utility function to print array elements
	public static void printArray(int arr[]) {
		System.out.println("Start testing the print function: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
