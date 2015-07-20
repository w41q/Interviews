import java.util.HashMap;

public class atoi
{
	public static void main(String[] args)
	{
		String s = "+3";
		System.out.println(myatoi(s));
	}
	
	public static int myatoi(String str)
	{
		str = str.trim();
		if(str.length()==0)
			return 0;
		if((str.charAt(0)<'0' || str.charAt(0)>'9') && str.charAt(0)!='+' && str.charAt(0)!='-')
			return 0;
		
		int cursor = 0;
		String sign = "";
		if(str.charAt(0)=='-')
		{
			sign = "-";
			cursor++;
		}
		else if(str.charAt(0)=='+')
		{
			cursor++;
		}
		if(cursor>=str.length())
			return 0;
		if(str.charAt(cursor)<'0' || str.charAt(cursor)>'9')
			return 0;
		
		String outstr = "0";
		while(str.charAt(cursor)=='0')
			cursor++;
		while(cursor<str.length() && str.charAt(cursor)>'0' && str.charAt(cursor)<='9')
		{
			outstr += str.charAt(cursor);
			cursor++;
		}
		double result = Double.parseDouble(outstr);
		if(sign=="-")
			result *= -1;
		if(result>Integer.MAX_VALUE)
			result = Integer.MAX_VALUE;
		else if(result<Integer.MIN_VALUE)
			result = Integer.MIN_VALUE;
		return (int)result;
	}
}
