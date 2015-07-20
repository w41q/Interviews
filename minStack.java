import java.util.Stack;

public class minStack
{
	public static void main(String[] args)
	{
		MinStack ms = new MinStack();
		ms.push(3);
	}
	
	public static class MinStack {
	    private Stack<Integer> st = new Stack<Integer>();
	    private Stack<Integer> st_min = new Stack<Integer>();
	    
	    public void push(int x)
	    {
	        st.push(x);
	        if(st_min.isEmpty())
	        	st_min.push(x);
	        else
	        	if(x<st_min.peek())
	        		st_min.push(x);
	    }

	    public void pop()
	    {
	    	if(!st.isEmpty())
	    	{
		        int x = st.pop();
		        if(x==st_min.peek())
		            st_min.pop();
	    	}
	    }

	    public int top()
	    {
	        return st.peek();
	    }

	    public int getMin()
	    {
	        return st_min.peek();
	    }
	}
}
