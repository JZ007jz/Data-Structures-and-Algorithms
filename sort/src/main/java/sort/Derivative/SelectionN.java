package sort.Derivative;

import util.SortSelectHelper;

/**
 * 利用快排思想求一个数组中第几小的数
 * @author 146717
 *
 */
public class SelectionN {
	public int solve (Integer[] arr, int l, int r, int k) {
		if (l == r) {
			return arr[l];
		}
		// partition之后, nums[p]的正确位置就在索引p上
		int p = partition (arr, l, r);
		if (p == k) {// 如果 k == p, 直接返回nums[p]
			return arr[p];
		} else if (p > k) { // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
			return solve (arr, l, p - 1, k);
		} else { // 如果 k > p, 则需要在nums[p+1...r]中找第k小元素
			return solve (arr, p + 1, r, k);
		}
	}
	
	// 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
	private int partition (Integer[] arr, int l, int r) {
		SortSelectHelper.swap(arr, l, (int)(Math.random()*(r-l+1))+l);
		int v = arr[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < v) {
				j ++;
				SortSelectHelper.swap(arr, i, j); 
			}
		}
		SortSelectHelper.swap(arr, l, j); 
		return j;
	}
}
