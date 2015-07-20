import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findSubstring
{
	public static void main(String []args)
	{
		String s = "barfoothefoobarman";
		String[] list = {"bar","foo"};
		List<Integer> result = function(s, list);
	}
	
	public static List<Integer> function(String S, String[] L)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(L==null || L.length==0 || L[0]==null || L[0].length()==0 || S==null || S.length()<L[0].length())
            return result;
        int num = L.length, len = L[0].length();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String str : L)
        {
            if(hm.containsKey(str))
                hm.put(str, hm.get(str)+1);
            else
                hm.put(str, 1);
        }
        for(int i=0;i<=S.length()-num*len;i++)
        {
            HashMap<String, Integer> hmtmp = new HashMap<String, Integer>();
            int j = 0;
            for(j=0;j<num;j++)
            {
                String str = S.substring(i+j*len, i+(j+1)*len);
                if(!hm.containsKey(str))
                    break;
                else
                {
                    if(hmtmp.containsKey(str))
                        hmtmp.put(str, hmtmp.get(str)+1);
                    else
                        hmtmp.put(str, 1);
                    if(hmtmp.get(str)>hm.get(str))
                        break;
                }
            }
            if(j==num)
                result.add(i);
        }
        
        return result;
    }
}
