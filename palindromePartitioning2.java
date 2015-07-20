public class palindromePartitioning2
{
	public static void main(String[] args)
	{
		String s = "aaabaa";
		System.out.println(function(s));
	}
	
	public static int function(String s)
	{
		if(s.length()<=1)
            return 0;
        char[] cha = s.toCharArray();
        return loopfunc(cha, 0, cha.length-1);
	}
	
	public static int loopfunc(char[] cha, int begin, int end)
    {
		if(begin>end)
            return 0;
        else if(begin==end)
            return 0;
        else
        {
        	if(valid(cha, begin, end))
        		return 0;
            int min = end-begin;
            for(int i=begin+1;i<=end;i++)
            {
                if(valid(cha, begin, i-1) && valid(cha, i, end))
                    return 1;
            }
            return min;
        }
    }
    
    public static boolean valid(char[] cha, int begin, int end)
    {
        if(begin>end)
            return true;
        else if(begin==end)
            return true;
        else
        {
            while(begin<end)
            {
                if(cha[begin]!=cha[end])
                    return false;
                begin++;
                end--;
            }
            return true;
        }
    }
}