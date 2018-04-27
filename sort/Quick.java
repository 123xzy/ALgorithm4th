package sort;
/**
 * 快速排序
 * @author xzy
 *
 */
public class Quick {
	public static void sort(Comparable[] aComparables ,int lo,int hi) {
		if(lo < hi) {
			int j = partition(aComparables,lo,hi);
			sort(aComparables, lo, j-1);
			sort(aComparables, j+1, hi);
		}
	}
}
