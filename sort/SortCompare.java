package sort;

import base.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/** 
 * analyic model
 * argu:Insertion Selection 1000 100
 * @author xzy
 *
 */
public class SortCompare {
	
	/* use kind of sort and compute time */
	public static double time(String alg,Double[] a) {
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		//if(alg.equals("Shell")) Shell.sort(a);	
		//if(alg.equals("Merge")) Merge.sort(a);
		if(alg.equals("Quick")) Quick.sort(a);
		if(alg.equals("Heap")) HeapSort.sort(a);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg,int N,int T) {
		double total = 0.0;
		Double[] aDoubles = new Double[N];
		/* test for T times */
		for(int i = 0;i < T;i++)
		{
			/* create a array[N] and sort it*/
			for(int j = 0;j < N;j++)
				aDoubles[j] = StdRandom.uniform();
			total += time(alg, aDoubles);
		}
		return total;
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T); /* time in algorithm 1 */
		double t2 = timeRandomInput(alg2, N, T); /* time in algorithm 2 */
		StdOut.printf("alg1 used %.3fs\n",t1);
		StdOut.printf("alg2 used %.3fs\n",t2);
		StdOut.printf("For %d random doubles\n	%s is",N,alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1,alg2);
	}
	
}
