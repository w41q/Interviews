import java.util.ArrayList;
import java.util.List;


public class permutationsequence
{
	public static void main(String[] args)
	{
		System.out.println(function(3,5));
	}
	
	public static String function(int n, int k)
	{
		if(k<=0)
            return "FUCK YOU!!!";
        if(n==1)
        {
            if(k==1)
                return "1";
            else
                return "GO FUCK YOURSELF!";
        }
        int nn = 1;
        for(int i=1;i<=n-1;i++)
        {
            nn *= i;
        }
        List<Integer> l = new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
            l.add(i);
        String result[] = {""};
        loopfunction(n, nn, k, "", l, result);
        return result[0];
	}
	
	public static void loopfunction(int currsize, int nextsize, int k, String prestr, List<Integer> num, String[] result)
    {
        if(num.size()==0)
        {
        	result[0] = prestr;
        	return;
        }
        int idx = (int) Math.ceil((double)k/nextsize);
        
        prestr = prestr+num.get(idx-1);
        num.remove(idx-1);
        if(currsize==1)
        {
        	result[0] = prestr;
        	return;
        }
        else
        	loopfunction(currsize-1, nextsize/(currsize-1), k-(idx-1)*nextsize, prestr, num, result);
    }
}
