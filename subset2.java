import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class subset2
{
	public static void main(String[] args)
	{
		int numbers[] = {0};
		List<List<Integer>> result = function2(numbers);
	}
	
	public static List<List<Integer>> function2(int[] num)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(num==null || num.length==0)
            return result;
        Arrays.sort(num);
        List<Integer> list = new ArrayList<Integer>();
        loopfunc(num, 0, list, result);
        return result;
	}
	
	public static void loopfunc(int[] num, int begin, List<Integer> pre, List<List<Integer>> result)
    {
        for(int i=begin;i<num.length;i++)
        {
            pre.add(num[i]);
            result.add(pre);
            if(i<num.length-1)
                loopfunc(num, i+1, pre, result);
            pre.remove(pre.size()-1);
            while(i<num.length-1 && num[i]==num[i+1])
                i++;
        }
    }
	
	public static List<List<Integer>> function(int[] num)
    {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(num==null || num.length==0)
            return result;
        Arrays.sort(num);
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        for(int i=1;i<=num.length;i++)
        {
            List<Integer> pre = new ArrayList<Integer>();
            loopfunction(num, 0, num.length-1, i, pre, hs);
        }
        Iterator iterator = hs.iterator(); 
        // check values
        while (iterator.hasNext())
           result.add((List<Integer>) iterator.next());
        return result;
    }
	
	public static void loopfunction(int[] S, int begin, int end, int k, List<Integer> pre, HashSet<List<Integer>> hs)
    {
        if(k==0)
		{
			List<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<pre.size();i++)
                l.add(pre.get(i));
            if(!hs.contains(l))
            	hs.add(l);
            return;
		}
        if(begin+k-1==end)
        {
            for(int i=begin;i<=end;i++)
                pre.add(S[i]);
            List<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<pre.size();i++)
                l.add(pre.get(i));
            if(!hs.contains(l))
            	hs.add(l);
            for(int i=begin;i<=end;i++)
                pre.remove(pre.size()-1);
        }
        else if(begin+k-1<end)
        {
            for(int i=begin;i<=end-k+1;i++)
            {
                pre.add(S[i]);
                loopfunction(S, i+1, end, k-1, pre, hs);
                pre.remove(pre.size()-1);
            }
        }
    }
}
