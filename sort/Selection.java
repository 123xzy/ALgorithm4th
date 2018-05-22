package sort;

/**
 * selection sort 
 * @author xzy
 *
 */
public class Selection extends Example {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0;i < N;i++)
		{
			int min = i;
			/* find min in a[i..N] */
			for(int j = i+1;j < N;j++)
				if(less(a[j], a[min]))min = j;
			/* exchange a[i] with a[min] */
			exch(a, i, min);
		}
	}
}
