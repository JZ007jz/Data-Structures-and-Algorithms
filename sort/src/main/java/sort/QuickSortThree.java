package sort;

import util.SortSelectHelper;

public class QuickSortThree extends Sort {

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
		
		SortSelectHelper.swap(arr, l, (int)((Math.random()*(r-l+1)) + l));
		T v = arr[l];
		
		//优化4：三路
		int lt = l; //arr[l+1, lt] < v;
		int gt = r + 1; //arr[gt, r] > v
		int i = l + 1;  //arr[lt+1, i) == v    这三个赋值都是为了使初始数组为空
		while (i < gt) {
			if (arr[i].compareTo(v) < 0) {
				SortSelectHelper.swap(arr, i, lt + 1);
				i ++;
				lt ++;
			} else if (arr[i].compareTo(v) > 0) {
				SortSelectHelper.swap(arr, i, gt - 1);
				gt --;
			} else {
				i ++;
			}
		}
		
		sort (arr, l, lt-1);
		sort (arr, gt, r);
	}
}
