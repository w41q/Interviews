import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordbreak
{
	public static void main(String[] args)
	{
		String word = "dogs";
		Set<String> dict = new HashSet<String>();
		String[] str = {"dog","s","gs"};
		for(String s:str)
			dict.add(s);
		boolean result = function_dp(word, dict);
	}
	
	public static boolean function_dp(String s, Set<String> dict)
	{
		if(s==null || s.length()==0 || dict.size()==0)
            return false;
        boolean[] table = new boolean[s.length()];
        if(dict.contains(""+s.charAt(0)))
            table[0] = true;
        for(int i=1;i<s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dict.contains(s.substring(0,i+1)) || (table[j]&&dict.contains(s.substring(j+1,i+1))))
                {
                    table[i] = true;
                    break;
                }
            }
        }
        return table[table.length-1];
	}
	
	public static boolean function_recursive(String s, Set<String> dict)
	{
		if(s==null || s.length()==0 || dict.size()==0)
            return false;
        return loopfunc(s, 0, dict);
	}
	
	public static boolean loopfunc(String s, int start, Set<String> dict)
    {
        if(start==s.length())
            return true;
        for(int i=start;i<s.length();i++)
        {
            if(dict.contains(s.substring(start, i+1)))
            {
                if(loopfunc(s, i+1, dict))
                	return true;
            }
        }
        return false;
    }
}
