public class firstMissingPositive
{
	public static void main(String[] args)
	{
		int[] a = {2,1};
		System.out.println(function(a));
	}
	
	public static int function(int[] nums)
	{
		if(nums.length==0)
            return 1;
        int i = 0;
        while(i<nums.length)
        {
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1])
            {
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            }
            else
                i++;
        }
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=j+1)
                return j+1;
        }
        return nums.length+1;
	}
}