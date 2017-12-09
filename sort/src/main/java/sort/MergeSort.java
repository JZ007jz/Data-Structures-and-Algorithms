package sort;

import java.util.Arrays;

/**
 * 思想参见印象笔记
 * @author Administrator
 *
 */
public class MergeSort extends Sort {

	//递归对arr[l, r]的范围排序(自顶向下)
	private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		//优化2：因为在几乎有序的数组中，插入排序接近O(N)，而数组中元素越少越接近有序，所以当小于一定数目时
		//用插入排序
//		if (r - l <= 15) {
//			new InsertSort().sort(arr, l, r);
//			return;
//		}
		
		int mid= (l + r)/2;
		sort (arr, l, mid);
		sort (arr, mid + 1, r);
		if (arr[mid].compareTo(arr[mid + 1]) > 0) { //优化1：因为此时左右都已分别有序
			merge (arr, l, mid, r);
		}
	}
	
	/**
	 * 递归对arr排序(自底向上)
	 * 作用：此方法未用到通过数组下表获取元素，所以可以用于链表
	 * @param arr
	 * @param n
	 */
	private <T extends Comparable<T>> void sort(T[] arr, int n) {
		//第一层循环定义每次迭代归并的数组大小
		for (int sz = 1; sz < n; sz += sz) {
			//第二层循环开始迭代归并
			for (int i = 0; i + sz < n; i += sz+sz) {
				merge (arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
			}
		}
	}
	
	//对arr[l, mid]和arr[mid+1, r]两部分进行归并
	private <T extends Comparable<T>> void merge (T[] arr, int l, int mid, int r) {
		//另外开辟arr.length的空间
		T[] aux = Arrays.copyOfRange(arr, l, r + 1);
		
		//初始化，i指左半部分初始位置， j指右半部分初始位置
		int i = l; //字母L而非1
		int j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {//左半部分处理完毕
				arr[k] = aux[j - l];
				j++;
			} else if (j > r) {//右半部分处理完毕
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l].compareTo(aux[j - l]) < 0) {
				arr[k] = aux[i - l];
				i++;
			} else {
				arr[k] = aux[j - l];
				j++;
			}
		}
	}

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length - 1);
//		sort (arr,arr.length - 1);
	}

}
