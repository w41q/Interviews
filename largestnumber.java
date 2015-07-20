import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largestnumber
{
	static class StringComparator implements Comparator<String>
	{
		@Override
		public int compare(String s1, String s2)
		{
			String s12 = s1 + s2;
			String s21 = s2 + s1;
			return -(int) (Long.parseLong(s12) - Long.parseLong(s21));
		}
	}
	
	public static void main(String []args)
	{
		int a[] = {0,10};
		System.out.println(function(a));
	}
	
	public static String function(int[] num)
    {
		if(num==null || num.length==0)
			return "fuck you!";
		if(num.length==1)
			return Integer.toString(num[0]);
		List<String> str = new ArrayList<String>();
		for(int i : num)
			str.add(Integer.toString(i));
		StringComparator sc = new StringComparator();
		Collections.sort(str, sc);
		String result = "";
		for(String s : str)
			result += s;
		int idx = 0;
		while(idx<result.length() && result.charAt(idx)=='0')
			idx++;
		if(idx==result.length())
			return "0";
		else
			return result.substring(idx, result.length());
    }
}
