import java.util.ArrayList;
import java.util.List;

public class generateParentheses
{
	public static void main(String[] args)
	{
		function(3);
	}
	
	public static List<String> function(int n)
	{
		List<String> result = new ArrayList<String>();
        if(n<=0)
            return result;
        loopfunc(n, 0, 0, "", result);
        return result;
	}
	
	public static void loopfunc(int max, int left, int right, String pre, List<String> result)
    {
        if(left==max && right==max)
            result.add(pre);
        else
        {
            if(left==max)
                loopfunc(max, left, right+1, pre+")", result);
            else
            {
                loopfunc(max, left+1, right, pre+"(", result);
                if(left>right)
                    loopfunc(max, left, right+1, pre+")", result);
            }
        }
    }
}