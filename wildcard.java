public class wildcard
{
	public static void main(String[] args)
	{
		String s = "hi";
		String p = "*?";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p)
	{
		if(s==null || s.length()==0 || p==null || p.length()==0)
        {
            if(s.length()==0 && p.length()==0)
                return true;
            else if(p.length()==0)
                return false;
            else
            {
                for(int i=0;i<p.length();i++)
                {
                    if(p.charAt(i)!='*')
                        return false;
                }
                return true;
            }
        }
        int pt1 = 0, pt2 = 0, pstar = -1, ps = -1;
        while(pt1<s.length())
        {
            char c1 = s.charAt(pt1), c2 = pt2==p.length()?'\0':p.charAt(pt2);
            if(c1==c2||c2=='?')
            {
                pt1++;
                pt2++;
                continue;
            }
            else if(c2=='*')
            {
                ps = pt1;
                pstar = pt2;
                pt2++;
            }
            else
            {
                if(pstar!=-1)
                {
                    ps++;
                    pt1 = ps;
                    pt2 = pstar+1;
                }
                else
                    return false;
            }
        }

        while(pt2<p.length() && p.charAt(pt2)=='*')
            pt2++;
        if(pt2==p.length())
            return true;
        else
            return false;
	}
}
