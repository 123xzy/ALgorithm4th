package base;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_22 {

	public static int rank(int key,int[]a) 
	{
		return rank(key,a,0,a.length-1,0);
	}
	public static int rank(int key,int[]a,int lo,int hi,int height)
	{
	
		for(int i=1;i<=height;i++)
			System.out.print(" ");
		System.out.print(hi);System.out.println(lo);
		
		if(lo>hi)return -1;
		int mid=lo+(hi-lo)/2;
		if(key<a[mid])return rank(key,a,lo,mid-1,++height);
		else if(key>a[mid])return rank(key,a,mid+1,hi,++height);
		else return mid;
	}
	
	public static void main(String[]args) {
		
		int[]whitelist=In.readInts(args[0]);
		Arrays.sort(whitelist);
		while(!StdIn.isEmpty())
		{
			int key=StdIn.readInt();
			if(rank(key,whitelist)<0)
				StdOut.println(key);
		}
	}
}
