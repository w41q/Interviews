import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinations
{
	public static void main(String[] args)
	{
		List<List<Integer>> result = function(4, 3);
	}
	
	public static List<List<Integer>> function(int n, int k)
    {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n<=0 || k<=0 || n<k)
            return result;
        List<Integer> pre = new ArrayList<Integer>();
        loopfunction(1, n, k, pre, result);
        return result;
    }
	
	public static void loopfunction(int begin, int end, int k, List<Integer> pre, List<List<Integer>> result)
    {
		if(k==0)
		{
			List<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<pre.size();i++)
                l.add(pre.get(i));
            result.add(l);
            return;
		}
        if(begin+k-1==end)
        {
            for(int i=begin;i<=end;i++)
                pre.add(i);
            List<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<pre.size();i++)
                l.add(pre.get(i));
            result.add(l);
            for(int i=begin;i<=end;i++)
                pre.remove(pre.size()-1);
        }
        else if(begin+k-1<end)
        {
            for(int i=begin;i<=end-k+1;i++)
            {
                pre.add(i);
                loopfunction(i+1, end, k-1, pre, result);
                pre.remove(pre.size()-1);
            }
        }
    }
}
