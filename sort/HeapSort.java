package sort;

public class HeapSort extends Example {
	private void sink(int)
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int k = N/2;k>=1;k--)
			sink(a,k,N);
		while(N > 1) {
			exch(a,1,N--);
			sink(a,1,N);
		}
	}
}
