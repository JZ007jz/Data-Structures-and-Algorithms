package sort;

import java.util.Arrays;

/**
 * 选择排序（从小到大）：先找出数组中最小的元素，与第一个位置交换
 * 然后找出剩余数中最小的元素，与第二个交换，
 * 以此类推
 * @author weide jin
 *
 */
public class SelectSort {

	private static void selectSort (int[] arr ) {
//		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			//寻找[i,arr.length)区间里的最小值
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			//交换元素
			int t = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = t;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 5, 2, 0, 8, 12, 7};
		selectSort(arr);
	}

}
