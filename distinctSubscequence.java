public class distinctSubscequence
{
	private static long count = 0;
	public static void main(String[] args)
	{
		//String s = "rabbbit", t = "rabbit";
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", t = "bcddceeeebecbc";
		System.out.println(function(s, t));
	}
	
	public static int function2(String S, String T)
	{
		return 0;
	}
	
	public static long function(String S, String T)
	{
		if(S==null || T==null || S.length()==0 || T.length()==0 || S.length()<T.length())
            return 0;
        char[] s = S.toCharArray(), t = T.toCharArray();
        loopfunc(s, t, 0, 0);
        return count;
	}
	
	public static void loopfunc(char[] s, char[] t, int begins, int begint)
    {
        if(begins==s.length && begint<t.length)
            return;
        if(begins<=s.length && begint==t.length)
        {
            count++;
            return;
        }
        for(int i=begins;i<s.length;i++)
        {
            if(s[i]==t[begint])
                loopfunc(s, t, i+1, begint+1);
        }
    }
}