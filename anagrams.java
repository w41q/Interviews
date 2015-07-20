import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class anagrams
{
	public static void main(String[] args)
	{
		String strs[] = {"abc","bca","e","cba"};
		List<String> l = function(strs);
	}
	
	public static List<String> function(String[] strs)
	{
		List<String> result = new ArrayList<String>();
        if(strs.length==0)
            return result;
        if(strs.length==1)
        {
            result.add(strs[0]);
            return result;
        }
        HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;i++)
        {
            char cha[] = strs[i].toCharArray();
            Arrays.sort(cha);
            String sortStr = new String(cha);
            if(hm.containsKey(sortStr))
            {
                hm.get(sortStr).add(strs[i]);
            }
            else
            {
                List<String> l = new ArrayList<String>();
                l.add(strs[i]);
                hm.put(sortStr, l);
            }
        }
        for(List<String> l:hm.values())
        {
            if(l.size()>1)
                result.addAll(l);
        }
        return result;
	}
}
