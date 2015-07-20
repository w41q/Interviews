import java.math.BigDecimal;


public class multiplystring
{
	public static void main(String[] args)
	{
		String num1="123", num2 = "4560";
		System.out.println(ms2(num1, num2));
	}
	
	public static String ms1(String num1, String num2)
	{
		BigDecimal n1 = new BigDecimal(num1), n2 = new BigDecimal(num2);
		return n1.multiply(n2).toPlainString();
	}
	
	public static String ms2(String num1, String num2)
	{
		char char1[] = num1.toCharArray(), char2[] = num2.toCharArray();
		char result[] = new char[char1.length+char2.length];
		mul(char1, char2, result);
		int begin = 0;
		while(begin<result.length && result[begin]=='0')
			begin++;
		String r = new String(result);
		if(begin==result.length)
			return "0";
		r = r.substring(begin, r.length());
		return r;
	}
	
	public static void mul(char[] num1, char[] num2, char[] result)
	{
		int value[] = new int[result.length];
		
		for(int i=num2.length-1;i>=0;i--)
		{
			for(int j=num1.length-1;j>=0;j--)
			{
				value[i+j+1] += (num1[j]-'0')*(num2[i]-'0');
			}
		}
		int carry = 0;
		for(int i=value.length-1;i>=0;i--)
		{
			int tmp = value[i]+carry;
			value[i] = tmp%10;
			carry = tmp/10;
			result[i] = (char) ((char)value[i]+'0');
		}
	}
}
