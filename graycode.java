import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class graycode
{
	public static void main(String[] args)
	{
		List<Integer> result = function(2);
	}
	
	public static List<Integer> function(int n)
    {
		List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if(n==0)
            return result;
        int bits[] = new int[n];
        int dir = 1;
        int pos = n-1;
        for(int i=0;i<Math.pow(2,n)-1;i++)
        {
            flip(bits, pos);
            if(pos==n-1)
                dir = -1;
            if(pos==0)
                dir = 1;
            pos += dir;
            
            int value = 0;
            for(int j=0;j<n;j++)
                value += bits[j]*Math.pow(2,n-1-j);
            result.add(value);
        }
        return result;
    }
	
	public static void flip(int[] bits, int n)
    {
        if(bits[n]==1)
            bits[n] = 0;
        else if(bits[n]==0)
            bits[n] = 1;
    }
}
