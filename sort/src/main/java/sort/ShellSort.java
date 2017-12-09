package sort;

public class ShellSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length;
		int h = 1;
		//如果n大就扩大间距
		while (h < n/3) {
			h= h * 3 + 1;
		}
		//h=1时代表排序完成
		while (h >= 1) {
			//内部其实是插入排序
			for (int i = h; i < n; i++) {
				T tmp = arr[i];
				int j = i;
				for (; j >= h && tmp.compareTo(arr[j - h]) < 0; j -= h) {
					arr[j] = arr[j - h];
				}
				arr[j] = tmp;
			}
			h /= 3;
		}
	}
}
