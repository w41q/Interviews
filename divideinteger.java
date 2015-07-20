import java.util.HashMap;

public class divideinteger
{
	public static void main(String[] args)
	{
		int a = Integer.MIN_VALUE, b = -1;
		System.out.println(function2(a, b));
	}
	
	public static int function(int dividend, int divisor)
	{
		if(divisor==0)
            return Integer.MAX_VALUE;
		if((long)Math.abs((long)dividend)<(long)Math.abs((long)divisor))
            return 0;
        boolean negative = false;
        
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
        {
            negative = true;
        }
        long dvd = (long)Math.abs((long)dividend), dvs = (long)Math.abs((long)divisor);
        long a = dvd, b = dvs;
        long count = 0;
        long result = 0;
        while(dvd>=b)
        {
            dvs = b;
            while(dvs<=dvd)
            {
                dvs <<= 1;
                count++;
            }
            dvd -= dvs>>1;
            result += (long)1<<(count-1);
            count = 0;
        }

        if(negative)
            result = -result;
        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
	}
	
	public static int function2(int dividend, int divisor)
	{
		if(divisor==0)
            return Integer.MAX_VALUE;
        if(dividend==0)
            return 0;
        boolean negative = false;
        if((dividend>0&&divisor<0) || (dividend<0&&divisor>0))
            negative = true;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor), result = 0;
        while(a>=b)
        {
            long b0 = b;
            int count = 0;
            while(b0<=a)
            {
                b0 <<= 1;
                count++;
            }
            long c = b0>>1;
            a -= c;
            result += (long)1<<(count-1);
        }
        if(negative)
        {
            if(-result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)-result;
        }
        else
        {
            if(result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)result;
        }
	}
}
