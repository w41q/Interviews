import java.util.HashMap;

public class interleavingString
{
	public static void main(String[] args)
	{
		//String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(function(s1, s2, s3));
	}
	
	public static boolean function(String s1, String s2, String s3)
	{
		if(s1.length()+s2.length()!=s3.length())
            return false;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        return loopfunc(c1, c2, c3, 0, 0, 0);
	}
	
	public static boolean loopfunc(char[] c1, char[] c2, char[] c3, int b1, int b2, int b3)
    {
        if(b1==c1.length && b2==c2.length && b3==c3.length)
            return true;
        else if(b1==c1.length && b2<c2.length && b3<c3.length)
            return loopfunc(c1, c2, c3, b1, b2+1, b3+1);
        else if(b1<c1.length && b2==c2.length && b3<c3.length)
            return loopfunc(c1, c2, c3, b1+1, b2, b3+1);
        else if(b1<c1.length && b2<c2.length && b3<c3.length)
        {
            if(c3[b3]!=c1[b1]&&c3[b3]!=c2[b2])
                return false;
            else if(c3[b3]!=c1[b1])
                return loopfunc(c1, c2, c3, b1, b2+1, b3+1);
            else if(c3[b3]!=c2[b2])
                return loopfunc(c1, c2, c3, b1+1, b2, b3+1);
            else
                return loopfunc(c1, c2, c3, b1, b2+1, b3+1) || loopfunc(c1, c2, c3, b1+1, b2, b3+1);
        }
        else
            return false;
    }
}