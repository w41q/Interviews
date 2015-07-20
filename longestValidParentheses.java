public class longestValidParentheses
{
	public static void main(String []args)
	{
		String s = "))()())())))()))(()(()))))(()()())))((()()((()))))))()((((())))((((((()())(((()))(())()))((())(()((((((())(()))()())()())))(((((()())()())((((()(((())((()(())(((()))()()())()(())((((((()()())()()((())(((())()())()(())()))()))())(())())((()()(((((()))(()))())(()))(((()())))((((()))((())))())((((((())))(()(()(())()()()()())())(()()())((())()(())((())))(()())(())(((((()()(())()((()))))()())()(())(()((((()(((((()))(()(())(((())))())))(()())))(()))()))(()(()))(((()(())(())()()()))()(((())(((()())(((())())(()))))()()))())()((()()()()))())((()))()()(()()(())(((()()()()(()()())()((()()()())())))()((((()()(((())()()((())))(())(()))))(()(()()()))())(())())))))((((()())((()))(()())((((()))())))))()(()(()))))()))())()(((()()()())()()))(()((())((()(()(((((((()))()())()(()()()((((()())))))))(())()()(()())(())())))((())))())()())))(()))()()))(())()()))(()())))(()((((()()(()()((()))()()))(((()))))))()(())(((())(())())())(((()))((()(()())()()))()))()))()((())(())(((()(((()()())))(((()(()(()())()))()))())))((()))))(((((()()(()())))()())))))((((()(()(((())(()((()(()()()()()(())()(()((()()(()))))()(()(())()()))))()))))()()()()(()()((()()()()()((())))()())(()(())(())(()(()())()()))(()))))(()())())()((()))())()())((((()(()()((())(()()()(((()((()(()())(((()((()(()(()(()((()((()())(((((())((()())())((())))))(((((((()(((((()(()))())((()(((((((()(((((()((()()()())(()(()(())))()((";
		int result = function(s);
	}
	
	public static int function(String s)
    {
		if(s==null || s.length()==0)
            return 0;
        boolean[][] table = new boolean[s.length()][s.length()];
        int maxlen = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            table[i][i] = false;
            if(s.charAt(i)=='(' && s.charAt(i+1)==')')
            {
                table[i][i+1] = true;
                maxlen = 2;
            }
        }
        table[s.length()-1][s.length()-1] = false;
        for(int len = 4;len<=s.length();len++)
        {
            for(int begin=0;begin<=s.length()-len;begin++)
            {
                int end = begin+len-1;
                if(s.charAt(begin)=='(' && s.charAt(end)==')')
                {
                    if(table[begin+1][end-1]==true)
                    {
                        table[begin][end] = true;
                        if(len>maxlen)
                            maxlen = len;
                    }
                    int idx = begin+1;
                    while(idx<end)
                    {
                        if(table[begin][idx]==true && table[idx+1][end]==true)
                        {
                            table[begin][end] = true;
                            if(len>maxlen)
                                maxlen = len;
                            break;
                        }
                        idx++;
                    }
                    if(idx==end)
                        table[begin][end] = false;
                }
            }
        }
        return maxlen;
    }
}
