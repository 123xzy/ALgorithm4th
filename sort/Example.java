package sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * 排序算法的模板
 * @author xzy
 *
 */
public class Example {
	public static void sort(Comparable[] a) {}
	
	public static boolean less(Comparable V,Comparable w)
	{	return V.compareTo(w) < 0;	}
	
	public static void exch(Comparable[] a,int i ,int j){	
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void show(Comparable[] a) {
		for(int i = 0 ;i < a.length;i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	//测试数组元素是否有序
	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length;i++)
			if(less(a[i], a[i-1]))
				return false;
		return true;
	}
}
