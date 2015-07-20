
public class addbinary
{
	public static void main(String[] args)
	{
		String a = "11", b = "1";
		System.out.println(function(a, b));
	}
	
	public static String function(String a, String b)
	{
		if(a.length()==0)
            return b;
        if(b.length()==0)
            return a;
        int maxlen = Math.max(a.length(), b.length());
        int na[] = new int[maxlen], nb[] = new int[maxlen];
        String result = "";
        int i = a.length()-1, j = na.length-1;
        while(i>=0 && j>=0)
        {
            na[j] = (int)(a.charAt(i)-'0');
            i--;
            j--;
        }
        i = b.length()-1;
        j = nb.length-1;
        while(i>=0 && j>=0)
        {
            nb[j] = (int)(b.charAt(i)-'0');
            i--;
            j--;
        }
        int carry = 0;
        i = na.length-1;
        for(;i>=0;i--)
        {
            int tmp = na[i] + nb[i] + carry;
            char c = (char) ((char)(tmp%2)+'0');
            result = ""+c+result;
            //result[i] = tmp%2;
            carry = tmp/2;
        }
        if(carry!=0)
        {
        	char c = (char) ((char)carry+'0');
            result = ""+c+result;
        }
        return result;
	}
}
