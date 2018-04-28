package sort;

import com.sun.tools.corba.se.idl.constExpr.LessEqual;
import com.sun.tools.javac.resources.legacy;

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
	
	private static int partition(Comparable[] aComparables,int lo ,int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable vComparable = aComparables[lo];
		while(true)
		{
			while(less(aComparables[++i],vComparable))if(i == hi)break;
			while(less(v,aComparables[--j]))if(j == lo)break;
			if(i >= j)break;
			exch(aComparables,i,j);
		}
		exch(aComparables,lo,j);
		return j;
	}
}
