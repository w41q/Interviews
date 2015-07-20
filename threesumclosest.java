import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class threesumclosest
{
	public static void main(String[] args)
	{
		int numbers[] = {0,2,1,-3};
		int result = threeSum(numbers, 1);
		System.out.println(result);
	}
	
	public static int threeSum(int[] num, int target)
    {
		int closest = Integer.MAX_VALUE;
        int result = 0;
        if(num.length<3)
            return 1234;
        Arrays.sort(num);
        for(int i=0;i<=num.length-3;i++)
        {
        	if(i==0 || num[i]!=num[i-1])
        	{
	            int start = i+1;
	            int end = num.length-1;
	            while(start<end)
	            {
	                if(num[i]+num[start]+num[end]==target)
	                {
	                	return num[i]+num[start]+num[end];
	                }
	                else if(num[i]+num[start]+num[end]<target)
	                {
	                	if(Math.abs(num[i]+num[start]+num[end]-target)<closest)
	                	{
	                		closest = Math.abs(num[i]+num[start]+num[end]-target);
	                		result = num[i]+num[start]+num[end];
	                	}
	                	start++;
	                }
	                    
	                else
	                {
	                	if(Math.abs(num[i]+num[start]+num[end]-target)<closest)
	                	{
	                		closest = Math.abs(num[i]+num[start]+num[end]-target);
	                		result = num[i]+num[start]+num[end];
	                	}
	                	end--;
	                }
	            }
        	}
        }
        return result;
    }
}
