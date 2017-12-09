package sort;

import util.SortSelectHelper;

public class BubbleSort extends Sort{

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[j-1]) < 0) {
					SortSelectHelper.swap(arr, j, j-1);
				}
			}
		}  
	}
}
