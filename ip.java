import java.util.ArrayList;
import java.util.List;

public class ip
{
	public static void main(String[] args)
	{
		List<String> result = function("010010");
	}
	
	public static List<String> function(String s)
    {
		List<String> result = new ArrayList<String>();
        if(s==null || s.length()<4)
            return result;
        loopfunc(s, 0, 0, "", result);
        return result;
    }
	
	public static void loopfunc(String s, int begin, int field, String pre, List<String> result)
    {
		if((begin>=s.length()&&field<4) || (begin<s.length()&&field>=4))
            return;
        if(begin==s.length()&&field==4)
        {
            result.add(pre.substring(0, pre.length()-1));
        }
        else
        {
            if(s.charAt(begin)=='0')
            {
                loopfunc(s, begin+1, field+1, pre+"0.", result);
            }
            else
            {
                for(int i=1;i<=Math.min(3, s.length()-begin);i++)
                {
                    int k = Integer.parseInt(s.substring(begin, begin+i));
                    if(k>0 && k<=255)
                    {
                        loopfunc(s, begin+i, field+1, pre+k+".", result);
                    }
                }
            }
        }
    }
}
