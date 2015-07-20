import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class foursum
{
	public static void main(String[] args)
	{
		int numbers[] = {-3,-2,-1,0,0,1,2,3};
		char a = '1';
		int k = Integer.parseInt(""+a);
		List<List<Integer>> result = threeSum(numbers, 0);
	}
	
	public static List<List<Integer>> threeSum(int[] num, int target)
    {
		List<List<Integer>> triplet = new ArrayList<List<Integer>>();
        if(num.length<4)
            return triplet;
        Arrays.sort(num);
        // if(num[0]>target || num[num.length-1]<target)
        //     return triplet;
        for(int i=0;i<=num.length-4;i++)
        {
        	if(i==0 || num[i]!=num[i-1])
        	{
        	    for(int j=i+1;j<=num.length-3;j++)
        	    {
        	        //if(num[j]!=num[j-1])
        	        {
        	            int start = j+1;
        	            int end = num.length-1;
        	            while(start<end)
        	            {
        	                if(num[i]+num[j]+num[start]+num[end]==target)
        	                {
        	                    List<Integer> list = new ArrayList<Integer>();
        	                    list.add(num[i]);
        	                    list.add(num[j]);
        	                    list.add(num[start]);
        	                    list.add(num[end]);
        	                    if(!triplet.contains(list))
        	                    	triplet.add(list);
        	                    while(start<end && num[start]==num[start+1])
        	                        start++;
        	                    while(start<end && num[end]==num[end-1])
        	                        end--;
        	                    start++;
        	                    end--;
        	                }
        	                else if(num[i]+num[j]+num[start]+num[end]<target)
        	                    start++;
        	                else
        	                    end--;
        	            }
        	        }
        	    }
	            
        	}
        }
        
        return triplet;
    }
}
