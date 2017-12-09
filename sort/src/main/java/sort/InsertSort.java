package sort;

import util.SortSelectHelper;

/**
 * 插入排序是，把元素从前向后一个个往有序队列中插（改进方法就是用直接赋值代替交换，因为一次交换是三次赋值）
 * @author Administrator
 *
 */
public class InsertSort extends Sort{
	/**
	 * 默认第一个元素有序，然后依次将未排序部分元素放到有序部分末尾
	 * 与其前一个元素比较，如果小于前一个元素则交换位置，否则就在此
	 */
	@Override
	public <T extends Comparable<T>> void sort (T[] arr) {
		//从第一个而不是第零个开始
		for (int i = 1; i < arr.length; i++) {
			//寻找第i个元素的位置
			//方法1：
//			for (int j = i; j > 0; j--) {
//				if (arr[j].compareTo(arr[j-1]) < 0) {
//					SortSelectHelper.swap(arr, j, j-1);
//				} else {
//					break; //由此可知，插入排序是可以提前结束循环的，而选择排序不可以
//				}
//			}
			
			//方法2：
//			for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//				SortSelectHelper.swap(arr, j, j-1);
//			}
			
			//方法3：（改进）
			T tmp = arr[i];
			int j = i;  //j保存该元素应该放的位置
			for (; j > 0 && tmp.compareTo(arr[j-1]) < 0; j--) {
				arr[j] = arr[j-1];  //原来的不满足就交互（三次赋值）改为不满足就直接赋值
			}
			arr[j] = tmp;
		}
	}
	
	public <T extends Comparable<T>> void sort (T[] arr, int l, int r) {
		//从第一个而不是第零个开始
		for (int i = l + 1; i <= r; i++) {
			//寻找第i个元素的位置
			//方法1：
//			for (int j = i; j > 0; j--) {
//				if (arr[j].compareTo(arr[j-1]) < 0) {
//					SortSelectHelper.swap(arr, j, j-1);
//				} else {
//					break; //由此可知，插入排序是可以提前结束循环的，而选择排序不可以
//				}
//			}
			
			//方法2：
//			for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//				SortSelectHelper.swap(arr, j, j-1);
//			}
			
			//方法3：（改进）
			T tmp = arr[i];
			int j = i;  //j保存该元素应该放的位置
			for (; j > l && tmp.compareTo(arr[j-1]) < 0; j--) {
				arr[j] = arr[j-1];  //原来的不满足就交互（三次赋值）改为不满足就直接赋值
			}
			arr[j] = tmp;
		}
	} 
}
