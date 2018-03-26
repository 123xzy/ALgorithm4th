package base;
import edu.princeton.cs.algs4.StdIn;
public class Ex_3_4_Parentheses {

	/*public static boolean check(String s)
	{
		int n=s.length();
		Stack<Character> C=new Stack<Character>();
		
		for(int i=0;i<n;i++)
		{
			char c=s.charAt(i);
			if(c=='['||c=='('||c=='{')C.push(c);
			else if(C.pop()!=c)return false;
		}
		return C.isEmpty();
	}*/
	public static boolean isBalanced(String s)
    {
        Stack<Character> open = new Stack<Character>();
        int n = s.length();
        
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{')
                open.push(c);
            else if ((c == ')' && (open.isEmpty() || open.pop() != '(')) ||
                     (c == ']' && (open.isEmpty() || open.pop() != '[')) ||
                     (c == '}' && (open.isEmpty() || open.pop() != '{')))
                return false;
        }
        
        return open.isEmpty();
    }
    
	
	public static void main(String[]args) {
		String s=StdIn.readAll().trim();
		System.out.print(isBalanced(s));
	}
}
