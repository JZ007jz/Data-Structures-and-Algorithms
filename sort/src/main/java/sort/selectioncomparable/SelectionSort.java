package sort.selectioncomparable;

import java.util.Arrays;

import sort.Sort;
import util.SortSelectHelper;

/**
 * 选择排序就是【选择最小的】，每次选出来都加到有序队列中
 * @author Administrator
 *
 */
public class SelectionSort extends Sort {
	
	@Override
	public <T extends Comparable<T>> void sort (T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// 寻找[i, n)区间里的最小值的索引
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				// 使用compareTo方法比较两个Comparable对象的大小
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}	
			}
			
			SortSelectHelper.swap (arr, i, min);
		}
	}	
	
	public static void main(String[] args) {

        // 测试Integer
//        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
//        SelectionSort.sort(a);
//        for( int i = 0 ; i < a.length ; i ++ ){
//            System.out.print(a[i]);
//            System.out.print(' ');
//        }
//        System.out.println();

        // 测试Double
//        Double[] b = {4.4, 3.3, 2.2, 1.1};
//        SelectionSort.sort(b);
//        for( int i = 0 ; i < b.length ; i ++ ){
//            System.out.print(b[i]);
//            System.out.print(' ');
//        }
//        System.out.println();

        // 测试String
//        String[] c = {"D", "C", "B", "A"};
//        SelectionSort.sort(c);
//        for( int i = 0 ; i < c.length ; i ++ ){
//            System.out.print(c[i]);
//            System.out.print(' ');
//        }
//        System.out.println();

        // 测试自定义的类 Student
//        Student[] d = new Student[4];
//        d[0] = new Student("D",90);
//        d[1] = new Student("C",100);
//        d[2] = new Student("B",95);
//        d[3] = new Student("A",95);
//        SelectionSort.sort(d);
//        for( int i = 0 ; i < d.length ; i ++ ) {
//        	System.out.println(d[i]);
//        }
        
        //测试排序算法辅助函数
//        int N = 20000;
//        Integer[] arr = SortSelectHelper.generateRandomArr(N, 0, 100000);
//        SelectionSort.sort(arr);
//        SortSelectHelper.testSort("sort.selectioncomparable.SelectionSort", arr); 
//        System.out.println(Arrays.toString(arr));
            
    }
}
