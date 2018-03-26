package base;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
/*
 * API：
 * Accumulator():创建一个累加器
 * void addDataValue(double val):添加一个新的数据类型
 * double mean():所有数据值的平均值
 * String toString():对象的字符串表示
 * 
 */
public class Accumulator {
	private double total;
	private int N;
	public void addDataValue(double val) {
		N++;
		total += val;
	}
	public double mean()
	{	return total/N;	}
	public String toString()
	{	return "Mean (" + N + " values):" + String.format("%7.5f", mean());	}
	
	public static void main(String[]args)
	{
		int T = Integer.parseInt(args[0]);
		Accumulator a = new Accumulator();
		for(int i = 0;i < T;i++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}
}
