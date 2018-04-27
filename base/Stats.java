package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 背包的典型用例
 * @author xzy
 *
 */
public class Stats {
	public static void main(String[] args) {
		
		Bag<Double> numbers = new Bag<Double>();
		
		while(!StdIn.isEmpty())
			numbers.add(StdIn.readDouble());
		int N = numbers.size();
		
		double sum = 0.0;
		
		for(double x : numbers)
			sum += x;
		double mean = sum/N;
		
		sum = 0.0;
		for(double x : numbers)
			sum += (x - mean)*(x-mean);
		double std = Math.sqrt(sum/(N-1));
		StdOut.printf("Mean:" + mean);
		StdOut.printf("Std dev:"+std );
	}
}
