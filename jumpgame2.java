import java.util.ArrayList;
import java.util.List;

public class jumpgame2
{
	public static void main(String[] args)
	{
		int A[] = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		//int A[] = {3,2,1,0,4};
		int result = function(A);
	}
	
	public static int function(int[] A)
	{
		if(A==null || A.length==0)
            return 0;
        List<Integer> q1 = new ArrayList<Integer>(), q2 = new ArrayList<Integer>();
        q1.add(0);
        return loopfunc(A, q1, q2, 0);
	}
	
	public static int loopfunc(int[] num, List<Integer> q1, List<Integer> q2, int level)
    {
        if(level>num.length)
            return -1;
        if(q1.isEmpty())
        {
            int size = q2.size();
            for(int i=0;i<size;i++)
            {
                int idx = q2.remove(0);
                if(idx>=num.length)
                    return level;
                q1.add(idx+num[idx]);
            }
        }
        else
        {
            int size = q1.size();
            for(int i=0;i<size;i++)
            {
                int idx = q1.remove(0);
                if(idx>=num.length)
                    return level;
                q2.add(idx+num[idx]);
            }
        }
        return loopfunc(num, q1, q2, level+1);
    }
}
