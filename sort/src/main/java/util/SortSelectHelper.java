package util;

import java.lang.reflect.Method;
import java.util.Arrays;

import sort.Sort;
import sun.security.jgss.spi.MechanismFactory;

public class SortSelectHelper {
	//不允许产生实例
	private SortSelectHelper(){};
	
	//生成n个元素的随机数组，每个元素的范围为[rangeL, rangeR]
	public static Integer[] generateRandomArr (int n, int rangeL, int rangeR) {
		assert rangeL < rangeR;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
		}
		return arr;
	}
	
	public static void print(Object arr[]) {
		Arrays.toString(arr);
		System.out.println(arr);
	}
	
	public static boolean isSorted (Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(arr[i+1]) >0) {
				return false;
			}
		}
		return true;
	}
	
//	public static void testSort (String className, Comparable[] arr) {
//		try {
//			Class sortClass = Class.forName(className);
//			Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
//			Object[] params = new Object[]{arr};
//			long start = System.currentTimeMillis();
//			method.invoke(null, params);
//			assert(isSorted(arr));
//			System.out.println( sortClass.getSimpleName()+ " : " + (System.currentTimeMillis()-start) + "ms" );
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void testSort (Sort sortClass, Comparable[] arr) {
		try {
			long start = System.currentTimeMillis();
			sortClass.sort(arr);
			System.out.println(Arrays.toString(arr));
			System.out.println( sortClass.getClass().getSimpleName()+ " : " + (System.currentTimeMillis()-start) + "ms" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
