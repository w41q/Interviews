public class findPeak
{
	public static void main(String[] args)
	{
		String version1 = "1", version2 = "0";
		String[] str1 = version1.split("\\."), str2 = version2.split("\\.");
        int len = Math.min(str1.length, str2.length);
        for(int i=0;i<len;i++)
        {
            int a = Integer.parseInt(str1[i]), b = Integer.parseInt(str2[i]);
            if(a>b)
                return;
            else if(a<b)
                return ;
        }
        if(str1.length>str2.length)
            return;
        else if(str1.length<str2.length)
            return;
        else
            return;
//		int[] a = {1,2,1};
//		int idx = function(a);
	}
	
	public static int function(int[] num)
	{
		if(num==null || num.length==0)
            return 0;
        int left = 0, right = num.length-1;
        while(left<right)
        {
            int mid = (left+right)/2;
            if(mid==0)
            {
            	if(num[0]>num[1])
            		return 0;
            	else
            		return 1;
            }
            else if(mid==num.length-1)
            {
            	if(num[mid]>num[mid-1])
            		return mid;
            	else
            		return mid-1;
            }
            else
            {
            	if(num[mid]>num[mid-1]&&num[mid]>num[mid+1])
                    return mid;
                else if(num[mid]<num[mid-1])
                    right = mid-1;
                else if(num[mid]<num[mid+1])
                    left = mid+1;
            }
        }
        return left;
	}
}
