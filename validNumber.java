// Simple Version
class validNumber
{
	public static void main(String[] argv)
	{
		String s = "123";
		System.out.println(function(s));
	}
	
	public static boolean function(String s)
	{
		if(s.length()==0)
			return false;
		int idx = 0;
		boolean canDot = true;
		while(idx<s.length())
		{
			char c = s.charAt(idx);
			if(c=='+' || c=='-')
			{
				if(idx!=0)
					return false;
			}
			else if(c=='.')
			{
				if(canDot)
					canDot = false;
				else
					return false;
			}
			else if(c<'0' || c>'9')
				return false;
			idx++;
		}
		return true;
	}
}
