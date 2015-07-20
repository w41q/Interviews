import java.util.ArrayList;
import java.util.List;

public class regMatching2
{
	public static void main(String[] args)
	{
		String s = "a";
		String p = ".*..a*";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p)
	{
		if(s.isEmpty() && p.isEmpty())
            return true;
        if(!s.isEmpty() && p.isEmpty())
            return false;
        if(p.equals(".*"))
        	return true;
		
		char schar[] = s.toCharArray();
		char pchar[] = p.toCharArray();
		
//		if(pchar.length==1)
//		{
//			if(schar.length<1 || (pchar[0]!='.' && schar[0]!=pchar[0]))
//				return false;
//			return schar[0]==pchar[0];
//		}
		
		if(p.length() == 1 || p.charAt(1) != '*')
		{
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));
		}
		else
		{
			int idx = 0;
			while(idx<schar.length && ((pchar[0]==schar[idx]) || (pchar[0]=='.')))
			{
				if(isMatch(s.substring(idx, s.length()), p.substring(2, p.length())))
					return true;
				idx++;
			}
			return isMatch(s.substring(idx, s.length()), p.substring(2, p.length()));
		}
	}
}
