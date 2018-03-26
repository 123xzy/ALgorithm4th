package base;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

/*
 * 可视化的累加器
 * API：
 * VisualAccumulator(int trials,double max):创建一个累加器
 * void addDataValue(double val):添加一个新的数据类型
 * double mean():所有数据值的平均值
 * String toString():对象的字符串表示
 */
public class VisualAccumulator {
	private double total;
	private int N;
	public VisualAccumulator(int trials,double max)
	{
		StdDraw.setXscale(0,trials);
		StdDraw.setYscale(0,max);
		StdDraw.setPenRadius(.005);
	}
	public void addDataValue(double val)
	{
		N++;
		total += val;
		//实时画出所有数据和实时的平均值
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	public double mean()
	{	return total/N;	}
	public String toString()
	{	return "Mean (" + N + " values):" + String.format("%7.5f", mean());	}
	
	public static void main(String[]args)
	{
		int T = Integer.parseInt(args[0]);
		VisualAccumulator a= new VisualAccumulator(T,1.0);
		for(int i = 0;i < T;i++)
			a.addDataValue(StdRandom.random());
		StdOut.println(a);
	}
}
