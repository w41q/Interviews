import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class threesum
{
	public static void main(String[] args)
	{
		//int numbers[] = {0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14};
		//int numbers[] = {-2,0,1,1,2};
		int numbers[] = {0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14};
		List<List<Integer>> result = threeSum4(numbers);
	}
	
	public static List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> triplet = new ArrayList<List<Integer>>();
        if(num.length<3)
            return triplet;
        Arrays.sort(num);
        if(num[0]>0 || num[num.length-1]<0)
            return triplet;
        for(int i=0;i<=num.length-3;i++)
        {
        	if(i==0 || num[i]!=num[i-1])
        	{
	            int target = -num[i];
	            int start = i+1;
	            int end = num.length-1;
	            while(start<end)
	            {
	                if(num[start]+num[end]==target)
	                {
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(-target);
	                    list.add(num[start]);
	                    list.add(num[end]);
	                    triplet.add(list);
	                    while(start<end && num[start]==num[start+1])
	                        start++;
	                    while(start<end && num[end]==num[end-1])
	                        end--;
	                    start++;
	                    end--;
	                }
	                else if(num[start]+num[end]<target)
	                    start++;
	                else
	                    end--;
	            }
        	}
        }
        return triplet;
    }
	
	public static List<List<Integer>> threeSum2(int[] num)
    {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length<3)
            return result;
        Arrays.sort(num);
        List<Integer> list = new ArrayList<Integer>();
        loopfunc(num, 0, 3, 0, list, result);
        return result;
    }
	
	public static List<List<Integer>> threeSum4(int[] nums)
    {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length==0)
            return result;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        loopfunc2(nums, list, 0, 3, 0, result);
        return result;
    }
	
	public static void loopfunc2(int[] num, List<Integer> pre, int begin, int left, int sum, List<List<Integer>> result)
    {
        if(begin>num.length)
            return;
        if(left==0)
        {
        	if(sum==0)
        	{
	            List<Integer> list = new ArrayList<Integer>();
	            list.addAll(pre);
	            result.add(list);
        	}
        }
        else
        {
	        for(int i=begin;i<num.length;i++)
	        {
	            pre.add(num[i]);
	            loopfunc2(num, pre, i+1, left-1, sum+num[i], result);
	            pre.remove(pre.size()-1);
	        }
        }
    }
	
	public static void loopfunc(int[] num, int begin, int numleft, int target, List<Integer> list, List<List<Integer>> result)
    {
        if(begin+numleft-1>=num.length || numleft<0)
            return;
        if(numleft==0 && target==0)
        {
            List<Integer> l = new ArrayList<Integer>();
            l.addAll(list);
            result.add(l);
            return;
        }
        while(begin+2<num.length-1 && num[begin]==num[begin+1])
            begin++;
//        if(begin+2==num.length-1)
//            return;
        for(int i=begin;i<num.length;i++)
        {
        	if(!list.contains(num[i]) && target-num[i]>num[i])
            {
        		list.add(num[i]);
        		loopfunc(num, i+1, numleft-1, target-num[i], list, result);
                list.remove(list.size()-1);
            }
        }
    }
	
	public static List<List<Integer>> threeSum3(int[] num)
    {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length<3)
            return result;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++)
        {
            if(i==0 || num[i]!=num[i-1])
            {
                int target = -num[i];
                int begin = i+1;
                int end = num.length-1;
                while(begin<end)
                {
                    if(num[begin]+num[end]==target)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(num[i]);
                        l.add(num[begin]);
                        l.add(num[end]);
                        result.add(l);
                        while(begin<end && num[begin+1]==num[begin])
                            begin++;
                        while(begin<end && (num[end-1]==num[end]))
                            end--;
                        begin++;
                        end--;
                    }
                    else if(num[begin]+num[end]<target)
                        begin++;
                    else
                        end--;
                }
            }
        }
        return result;
    }
}
