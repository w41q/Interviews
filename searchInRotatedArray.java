import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class searchInRotatedArray
{
	public static void main(String []args)
	{
		int[] a = {4,5,6,7,0,1,2};
		int result = function(a, 8);
		System.out.println(result);
	}
	
	public static int function(int[] A, int target)
    {
		if(A==null || A.length==0)
            return -1;
        if(A[0]<A[A.length-1])
            return bs(A, 0, A.length-1, target);
        int left = 0, right = A.length-1;
        int idx = 0;
        while(left<right)
        {
            int mid = (left+right)/2;
            if(A[mid]<A[A.length-1])
                right = mid;
            else
                left = mid+1;
        }
        idx = bs(A, 0, left-1, target);
        if(idx!=-1)
            return idx;
        idx = bs(A, left, A.length-1, target);
        if(idx!=-1)
            return idx;
        return -1;
    }
	
	public static int bs(int[] A, int begin, int end, int target)
    {
        while(begin<=end)
        {
            int mid = (begin+end)/2;
            if(A[mid]==target)
                return mid;
            else if(A[mid]<target)
                begin = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
