package util;

import java.util.Arrays;

import sort.BubbleSort;
import sort.InsertSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.QuickSortThree;
import sort.ShellSort;
import sort.Derivative.ReversePair;
import sort.Derivative.SelectionN;
import sort.selectioncomparable.SelectionSort;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//测试排序算法辅助函数
        int N = 5;
        Integer[] arr = SortSelectHelper.generateRandomArr(N, 0, 20);
//        Integer[] arr2 = arr;
//        for (int i = 0; i < arr.length; i++) {
//        	System.out.println(arr[i]);
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(arr));
//        Thread.sleep(5000);
//        new InsertSort().sort(arr);
//        SelectionSort.sort(arr);
//        SortSelectHelper.testSort(new InsertSort(), arr2);
//        Thread.sleep(5000);
//        SortSelectHelper.testSort(new SelectionSort(), arr);
//        SortSelectHelper.testSort(new BubbleSort(), arr);
//        SortSelectHelper.testSort(new ShellSort(), arr);
//        SortSelectHelper.testSort(new MergeSort(), arr);
//        SortSelectHelper.testSort(new QuickSort(), arr);
//        SortSelectHelper.testSort(new QuickSortThree(), arr);
        System.out.println(Arrays.toString(arr));
//        new ReversePair().getReversePairNum(arr);
//        new ReversePair().getReversePairNum(arr, 0, arr.length - 1);
        System.out.println(new SelectionN().solve(arr, 0, arr.length - 1, 0));
	}

}
