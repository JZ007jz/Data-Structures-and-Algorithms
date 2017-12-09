package sort;

/**
 * 笔记：
 * 		越接近有序，插入算法的性能越接近O(N),越优于选择排序
 * @author Administrator
 *
 */
public abstract class Sort {
	public abstract <T extends Comparable<T>> void sort(T[] arr);
}
