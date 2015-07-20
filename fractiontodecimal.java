import java.util.HashMap;

public class fractiontodecimal
{
	public static void main(String []args)
	{
		String s = "B";
		int a = s.charAt(0)-'A'+1;
		char c = (char) (a%26-1+'A');
		System.out.println(function2(-1, -2147483648));
	}
	
	public static String function(int numerator, int denominator)
    {
		if(denominator==0)
            return null;
        if(numerator==0)
            return "0";
        boolean negative = false;
        if((numerator>0&&denominator<0)||(numerator<0&&denominator>0))
            negative = true;
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long a = n/d;
        if(numerator%denominator==0)
        {
        	if(negative)
        		return "-"+Long.toString(a);
        	else
        		return Long.toString(a);
        }
        String b = "";
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        Long remainder = n%d;
        boolean flag = false;
        int count = 0;
        while(!hm.containsKey(remainder))
        {
            hm.put(remainder, count);
            count++;
            n = remainder*10;
            int quotient = (int) (n/d);
            b += Integer.toString(quotient);
            remainder = n%d;
            if(remainder==0)
            {
                flag = true;
                break;
            }
        }
        
        if(flag)
        {
            if(negative)
                return "-"+a+"."+b;
            else
                return a+"."+b;
        }
        else
        {
            int idx = hm.get(remainder);
            if(negative)
                return "-"+a+"."+b.substring(0,idx)+"("+b.substring(idx,b.length())+")";
            else
                return a+"."+b.substring(0,idx)+"("+b.substring(idx,b.length())+")";
        }
    }
	
	public static String function2(int numerator, int denominator)
	{
		if(numerator==0 || denominator==0)
            return "0";
        String intpart = "";
        if((numerator>0&&denominator<0)||(numerator<0&&denominator>0))
            intpart = "-";
        long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
        intpart += "" + (num/den);
        long remainder = num%den;
        if(remainder==0)
            return intpart;
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        String fractionpart = "";
        boolean recursion = true;
        int count = 0;
        while(!hm.containsKey(remainder))
        {
            hm.put(remainder, count);
            count++;
            long tmp = remainder*10;
            fractionpart += "" + tmp/den;
            remainder = tmp%den;
            if(remainder==0)
            {
                recursion = false;
                break;
            }
        }
        if(recursion==true)
        {
            int idx = hm.get(remainder);
            String part1 = fractionpart.substring(0, idx), part2 = fractionpart.substring(idx, fractionpart.length());
            return intpart+"."+part1+"("+part2+")";
        }
        else
            return intpart+"."+fractionpart;
	}
}
