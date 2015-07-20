import java.util.Stack;

public class largestRectangleInHistogram
{
	public static void main(String[] argv)
	{
		int[] a = {4,2,0,3,2,5};
		System.out.println(function(a));
	}
	
	public static int function(int[] height)
	{
		if(height.length==0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        int max = 0, idx = 0;
        while(idx<height.length)
        {
            if(st.isEmpty() || height[idx]>=height[st.peek()])
                st.push(idx++);
            else
            {
                int idx2 = st.pop();
                int h = height[idx2], w = st.isEmpty()?idx:idx-idx2;
                max = Math.max(max, h*w);
            }
        }
        while(!st.isEmpty())
        {
            int idx2 = st.pop();
            int h = height[idx2], w = st.isEmpty()?idx:idx-idx2;
            max = Math.max(max, h*w);
        }
        return max;
	}
}