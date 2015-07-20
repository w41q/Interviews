import java.util.HashMap;

public class minWindowSubstring
{
	public static void main(String[] args)
	{
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(function(s, t));
	}
	
	public static String function(String S, String T)
	{
		if(S==null || T==null || S.length()==0 || T.length()==0)
            return "";
        HashMap<Character, Integer> hmt = new HashMap<Character, Integer>();
        for(int i=0;i<T.length();i++)
        {
            char c = T.charAt(i);
            if(hmt.containsKey(c))
                hmt.put(c, hmt.get(c)+1);
            else
                hmt.put(c, 1);
        }
        int begin = 0, end = 0, count = 0, minlen = Integer.MAX_VALUE;
        String minstr = "";
        HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
        while(end<S.length())
        {
            char e = S.charAt(end);
            if(hmt.containsKey(e))
            {
                if(hms.containsKey(e))
                {
                    if(hms.get(e)+1<=hmt.get(e))
                        count++;
                    hms.put(e, hms.get(e)+1);
                }
                else
                {
                    hms.put(e, 1);
                    count++;
                }
            }
            if(count==T.length())
            {
            	char b = S.charAt(begin);
            	while(!hms.containsKey(b)||hms.get(b)>hmt.get(b))
            	{
            		if(hms.containsKey(b)&&hms.get(b)>hmt.get(b))
            			hms.put(b, hms.get(b)-1);
            		begin++;
            		b = S.charAt(begin);
            	}
            	if(end-begin+1<minlen)
                {
                    minstr = S.substring(begin, end+1);
                    minlen = end-begin+1;
                }
            }
            end++;
        }
        return minstr;
	}
}