/*
 * 线性级别的TwoSum算法
 * 没有考虑元素重复的问题
 */
package base;

import edu.princeton.cs.algs4.In;
import java.util.Arrays;

public class TwoSumFaster {

	public static int count(int[]a)
	{
		int begin = 0;
		int end = a.length-1;
		int cnt = 0;
		Arrays.sort(a);
		while(begin<end)
		{
			if((a[begin]+a[end]) == 0)
			{
				begin++;end--;
				cnt++;
			}
			else 
			{
				if((a[begin]+a[end]) > 0)
					end--;
				else 
					begin++;
			}
		}
		return cnt;
	}
	
	public static void main(String[]args)
	{
		@SuppressWarnings("deprecation")
		int[]a = In.readInts(args[0]);
		System.out.println(count(a));
	}
}
