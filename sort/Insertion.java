package sort;

/**
 * insert sort 
 * @author xzy
 *
 */
public class Insertion extends Example {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1;i < N;i++)
		{
			/* insert a[i] into a[1..i-1] */
			for(int j = i;j > 0 && less(a[j], a[j-1]);j--)
				exch(a, j, j-1);
		}
	}
}
