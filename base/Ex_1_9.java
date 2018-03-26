package base;
import java.util.*;
public class Ex_1_9 {

	public static void main(String[]args) {
		String s="";
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		for(int i=N;i>0;i/=2)
			s=(i%2)+s;
		System.out.println(s);
	}
}
