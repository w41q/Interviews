import java.util.ArrayList;
import java.util.List;

public class reverseBit
{
	public static void main(String[] args)
	{
		System.out.println(function(-2147483648));
	}
	
	public static int function(int n)
	{
		List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<32;i++)
        {
            int v = n&(1<<i);
            if(v==0)
            	list.add(0);
            else
            	list.add(1);
        }
        long result = 0;
        int test = 1;
        while(!list.isEmpty())
        {
            int v = list.remove(list.size()-1);
            if(v!=0)
            result += test*v;
            test <<= 1;
        }
        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)result;
	}
}