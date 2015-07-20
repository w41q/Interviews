import java.util.ArrayList;
import java.util.List;

public class maxproductsubarray
{
	public static void main(String []args)
	{
		List<int[]> aa = new ArrayList<int[]>();
    	 
		int a[] = {-2,0,-1};
		int b[] = {0};
		int c[] = {1};
		int d[] = {2,3,-2,4};
		int e[] = {2,3,-2,-4};
		int f[] = {0,2};
		int g[] = {3,-1,4};
		int h[] = {6,3,-10,0,2};
		int j[] = {2,-5,-2,-4,3};
//		aa.add(a);
//		aa.add(b);
//		aa.add(c);
//		aa.add(d);
//		aa.add(e);
//		aa.add(f);
//		aa.add(g);
//		aa.add(h);
		aa.add(j);
		for(int i=0;i<aa.size();i++)
			System.out.println(function(aa.get(i)));
	}
	
	public static int function(int[] A)
    {
		if(A==null || A.length==0)
			return 0;
		if(A.length==1)
			return A[0];
		int max = A[0], min = A[0], result = A[0];
		for(int i=1;i<A.length;i++)
		{
			int tmp = max;
			max = Math.max(Math.max(max*A[i], A[i]), min*A[i]);
			min = Math.min(Math.min(min*A[i], A[i]), tmp*A[i]);
			result = Math.max(max, result);
		}
		return result;
    }
}
