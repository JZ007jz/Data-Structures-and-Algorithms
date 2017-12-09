package sort.Derivative;

import java.util.Arrays;

import sort.InsertSort;

/**
 * 求逆序对个数
 * @author 146717
 *
 */
public class ReversePair {

	/*
	 *双重循环暴力解法O（N^2）
	 */
	public void getReversePairNum (Integer[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					num ++;
				}
			}
		}
		System.out.println(num);
	}
	
	/**
	 * 归并排序思想解决
	 */
	public void getReversePairNum (Integer[] arr, int l, int r) {
		Long num = solve (arr, l, r);
		System.out.println(num);
	}
	
	private Long solve (Integer[] arr, int l, int r) {
		if (l >= r) {
			return 0L;
		}
		int mid = (l + r)/2;
		Long num1 = solve (arr, l, mid);
		Long num2 = solve (arr, mid + 1, r);
		
		return num1 + num2 + merge (arr, l, mid, r);
	}

	private Long merge (Integer[] arr, int l, int mid, int r) {
		Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
		Long num = 0L;
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = aux[j - l];
				j ++;
			} else if (j > r) {
				arr[k] = aux[i - l];
				i ++;
			} else if (arr[i] > arr[j]) {
				arr[k] = aux[j - l];
				num += (mid - i + 1);
				j ++;
			} else {
				arr[k] = aux[i - l];
				i ++;
			}
		}
		return num; 
	}
	
}
