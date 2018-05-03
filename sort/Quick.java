package sort;

/**
 * 快速排序
 * @author xzy
 *
 */
public class Quick extends Example {
	public static void sort(Comparable[] aComparables ,int lo,int hi) {
		if(lo < hi) {
			int j = partition(aComparables,lo,hi);
			sort(aComparables, lo, j-1);
			sort(aComparables, j+1, hi);
		}
	}
	
	private static int partition(Comparable[] aComparables,int lo ,int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable vComparable = aComparables[lo];
		while(true)
		{
			while(less(aComparables[++i],vComparable))if(i == hi)break;
			while(less(vComparable,aComparables[--j]))if(j == lo)break;
			if(i >= j)break;
			exch(aComparables,i,j);
		}
		exch(aComparables,lo,j);
		return j;
	}
}
