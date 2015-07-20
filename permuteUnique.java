import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class permuteUnique
{
	public static void main(String[] args)
	{
		int[] a = {-1,-1,3,-1};
		List<List<Integer>> result = function(a);
	}
	
	public static List<List<Integer>> function(int[] num)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return result;
        Arrays.sort(num);
        loopfunc(num, 0, result);
        //perm(num, 0, (num.length-1), result);
        return result;
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(num==null && num.length==0)
//            return res;
//        Arrays.sort(num);
//        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
//        return res;
	}
	
	public static void perm(int[] num, int k, int n, List<List<Integer>> res)
	{
        if (k==n)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : num)
                list.add(i);
            res.add(list);
        }
        else
        {
            for(int i=k;i<=n;i++)
            {
                if (noswap(k,i,num))
                    continue;
                int tmp = num[k];
                num[k]=num[i];
                num[i]=tmp;
                 
                perm(num,k+1,n,res);
                 
                tmp = num[k];
                num[k]=num[i];
                num[i]=tmp;
            }
        }
    }
    
    public static boolean noswap(int k, int i, int[] num)
    {
        for (int j=k;j<i;j++)
        {
            if (num[j]==num[i])
            {
                return true;
            }
        }
        return false;
    }
	
	private static void helper(int[] num, boolean[] used, ArrayList<Integer> item, List<List<Integer>> res)
    {
        if(item.size() == num.length)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            if(i>0 && !used[i-1] && num[i]==num[i-1]) continue;
            if(!used[i])
            {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
	
	public static void loopfunc(int[] num, int begin, List<List<Integer>> result)
    {
        if(begin==num.length-1)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : num)
                list.add(i);
            result.add(list);
        }
        else
        {
            //loopfunc(num, begin+1, result);
            for(int i=begin;i<num.length;i++)
            {
//                if(i==begin || num[i]!=num[begin])
//                {
//                    int tmp = num[begin];
//                    num[begin] = num[i];
//                    num[i] = tmp;
//                    loopfunc(num, begin+1, result);
//                    tmp = num[begin];
//                    num[begin] = num[i];
//                    num[i] = tmp;
//                }
            	boolean flag = false;
            	for(int j=begin;j<i;j++)
            	{
            		if(num[j]==num[i])
            			flag = true;
            	}
            	if(flag)
            		continue;
            	else
                {
                    int tmp = num[begin];
                    num[begin] = num[i];
                    num[i] = tmp;
                    loopfunc(num, begin+1, result);
                    tmp = num[begin];
                    num[begin] = num[i];
                    num[i] = tmp;
                }
            }
        }
    }
}
