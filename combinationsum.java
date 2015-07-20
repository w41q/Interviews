import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class combinationsum
{
	public static void main(String[] args)
	{
		int numbers[] = {1,1};
		int target = 1;
		List<List<Integer>> result = function(numbers, target);
	}
	
	public static List<List<Integer>> function(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length==0)
            return result;
//        if(candidates.length==1)
//        {
//            if(candidates[0]==target)
//            {
//                List l = new ArrayList<Integer>();
//                l.add(target);
//                result.add(l);
//                return result;
//            }
//            else
//                return result;
//        }
        
        Arrays.sort(candidates);
        ArrayList<Integer> pre = new ArrayList<Integer>();
        loopfunction(candidates, 0, target, pre, result);
        return result;
    }
	
	public static void loopfunction(int[] num, int start, int target, ArrayList<Integer> pre, List<List<Integer>> result)
    {
		if(start>=num.length)
            return;
        if(target==0)
        {
        	ArrayList<Integer> l = new ArrayList<Integer>(pre);
            result.add(l);
            return;
        }
        else if(target<0)
            return;
        else
        {
        	//loopfunction(num, level+1, target, pre, result);
        	int idx = start;
            while(idx<num.length)// && target - num[idx]>=0
            {
                pre.add(num[idx]);
                loopfunction(num, idx, target-num[idx], pre, result);
                pre.remove(pre.size()-1);
                idx++;
            }
        }
    }
}
