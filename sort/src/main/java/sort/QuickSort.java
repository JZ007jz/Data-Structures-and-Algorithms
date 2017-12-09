package sort;

import util.SortSelectHelper;

public class QuickSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	// 递归使用快速排序,对arr[l...r]的范围进行排序
	public <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
//		if (l >= r) {
//			return;
//		}
		//优化1：对于小规模数组使用插入排序
		if (r - l <= 15) {
			new InsertSort().sort(arr, l, r); 
			return;
		}
		
		int p = partition (arr, l, r);
		sort (arr, l, p-1);
		sort (arr, p+1, r);
	}
	
	// 对arr[l...r]部分进行partition操作
    // 返回j, 使得arr[l...j-1] < arr[j] ; arr[j+1...i) > arr[j]
	private <T extends Comparable<T>> int partition (T[] arr, int l, int r) {
		//优化2：随机取分界点
		SortSelectHelper.swap(arr, l, (int)((Math.random()*(r-l+1)) + l));
		T v = arr[l];
//		int j = l; // 这样可保证两个初始数组都为空（arr[l...j-1]和arr[j+1...i)）
//		for (int i = l+1; i <= r; i++ ) {
//			if (arr[i].compareTo(v) < 0) {
//				j++;
//				SortSelectHelper.swap(arr, j, i);
//			}
//		}
		
		//优化3：双路快排   arr[l+1, i)   arr(j, r]
		int i = l + 1, j = r;
		while (true) {
			//不是arr[i].compareTo(v) <= 0，因为有等号时一旦出现多个连续相等的数时，会导致递归树不平衡
			while ((i <= r) && (arr[i].compareTo(v) < 0)) {
				i ++;
			}
			while ((j >= l+1) && (arr[j].compareTo(v) > 0)) {
				j --;
			}
			if (i > j) {
				break;
			}
			SortSelectHelper.swap(arr, i, j);
			i ++;
			j --;
		}
		
		//遍历完交换j和l处的元素
		SortSelectHelper.swap(arr, i, j); 
		return j;
		
	}
}
