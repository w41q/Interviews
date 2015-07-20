import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordbreak2
{
	public static void main(String[] args)
	{
//		String s = "catsanddog";
//		String[] str = {"cat", "cats", "and", "sand", "dog"};
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//		String[] str = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
//		String s = "a";
//		String[] str = {"a"};
		String s = "aaaaaaa";
		String[] str = {"aaaa","aa","a"};
		Set<String> set = new HashSet<String>();
		for(String word : str)
			set.add(word);
		List<String> result = function2(s, set);
	}
	
	public static List<String> function2(String s, Set<String> wordDict)
	{
		List<String> result = new ArrayList<String>();
        if(s.length()==0||wordDict.size()==0)
            return result;
        boolean[][] table = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
    		for(int j=i;j<s.length();j++)
        	{
        		if(wordDict.contains(s.substring(i, j+1)))
        		{
        			table[i][j] = true;
        		}
        	}
        }
        boolean flag = false;
        for(int i=0;i<table.length;i++)
        {
        	if(table[i][table.length-1])
        	{
        		flag = true;
        		break;
        	}
        }
        if(flag)
        	loopfunc2(s, table, 0, "", result);
        return result;
	}
	
	public static void loopfunc2(String s, boolean[][] table, int begin, String pre, List<String> result)
	{
		if(begin==table.length)
			result.add(pre.substring(1, pre.length()));
		else
		{
			for(int i=begin;i<table.length;i++)
			{
				if(table[begin][i])
					loopfunc2(s, table, i+1, pre+" "+s.substring(begin, i+1), result);
			}
		}
	}
	
	public static List<String> function(String s, Set<String> wordDict)
	{
		List<String> result = new ArrayList<String>();
        if(s.length()==0||wordDict.size()==0)
            return result;
        boolean[] table = new boolean[s.length()];
        List<String>[] pre = new ArrayList[s.length()];
        for(int i=0;i<pre.length;i++)
        	pre[i] = new ArrayList<String>();
        if(wordDict.contains(s.charAt(0)))
            table[0] = true;
        for(int i=0;i<s.length();i++)
        {
        	String str = s.substring(0, i+1);
            if(wordDict.contains(str))
            {
                pre[i].add(str);
                table[i] = true;
            }
            else
            {
                for(int j=1;j<=i;j++)
                {
                	String str2 = s.substring(j, i+1);
                    if(table[j-1]&&wordDict.contains(str2))
                    {
                        table[i] = true;
//                        for(String w : pre[j-1])
//                            pre[i].add(w+" "+s.substring(j, i+1));
                        pre[i].add(str2);
                    }
                }
            }
        }
        loopfunc(pre, pre.length-1, "", result);
        return result;
	}
	
	public static void loopfunc(List<String>[] pre, int end, String str, List<String> result)
	{
		if(end<0)
		{
			result.add(str.substring(0, str.length()-1));
		}
		else
		{
			for(String s : pre[end])
			{
				int idx = end-s.length();
				loopfunc(pre, idx, s+" "+str, result);
			}
		}
	}
}