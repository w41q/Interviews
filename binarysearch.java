
public class binarysearch
{
	public static void main(String[] args)
	{
		//int num[] = {1,3};
		int num[] = {1,2,3,5,6,6,7,8};
		int key = 6;
		int result = bs4(num, key);
		System.out.println(result);
		//int result[] = rangesearch(num, key);
	}
	
	public static int[] rangesearch(int[] A, int target)
	{
		int result[] = new int[2];
		result[0] = -1;
		result[1] = -1;
		if(A.length==0)
			return result;
		if(A.length==1)
		{
			if(A[0]==target)
			{
				result[0] = 0;
				result[1] = 0;
				return result;
			}
			else
				return result;
		}
		
		int start = 0, end = A.length-1;
		while(start<end)
		{
			int mid = (start+end)/2;
			if(A[mid]>=target)
				end = mid;
			else
				start = mid+1;
		}
		if(A[end]!=target)
			return result;
		result[0] = end;
		
		start = 0;
		end = A.length-1;
		while(start<end)
		{
			int mid = (start+end)/2;
			if(A[mid]<=target)
				start = mid+1;
			else
				end = mid;
		}
		result[1] = A[start]==target?start:start-1;

		
		return result;
	}
	
	public static int bs(int num[], int begin, int end, int key)
	{
		if(num.length==0 || begin>end || begin<0 || end>num.length)
			return -1;
		
		int result = 0;
		int mid = (begin+end)/2;
		if(num[mid]==key)
			result = mid;
		else if(num[mid]<key)
			result = bs(num, mid+1, end, key);
		else if(num[mid]>key)
			result = bs(num, begin, mid-1, key);
		return result;
	}
	
	public static int bs2(int num[], int begin, int end, int key)
	{
		if(num.length==0 || begin>end || begin<0 || end>num.length)
		{
			return end+1;
		}

		
		int result = 0;
		int mid = (begin+end)/2;
		if(num[mid]==key)
			result = mid;
		else if(num[mid]<key)
			result = bs2(num, mid+1, end, key);
		else if(num[mid]>key)
			result = bs2(num, begin, mid-1, key);
		return result;
	}
	
	public static int bs3(int num[], int target)
	{
		if(num.length==0 || target<num[0] || target>num[num.length-1])
			return -1;
		int begin = 0, end = num.length-1;
		while(begin<=end)
		{
			int mid = (begin+end)/2;
			if(num[mid]==target)
				end = mid-1;
			else if(num[mid]<target)
				begin = mid+1;
			else
				end = mid-1;
		}
		return -1;
	}
	
	public static int bs4(int[] num, int target)
	{
		if(num.length==0 || target<num[0] || target>num[num.length-1])
			return -1;
		int begin = 0, end = num.length-1;
		while(begin+1<end)
		{
			int mid = begin+(end-begin)/2;
			if(num[mid]==target)
				end = mid;
			else if(num[mid]<target)
				begin = mid;
			else
				end = mid;
		}
		if(num[begin]==target)
			return begin;
		if(num[end]==target)
			return end;
		return -1;
	}
}
