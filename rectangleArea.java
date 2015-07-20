class rectangleArea
{
	public static void main(String[] argv)
	{
		long A = -1500000001, B = 0, C = -1500000000, D = 1, E = 1500000000, F = 0, G = 1500000001, H = 1;
		long w = Math.min(C, G)-Math.max(A, E), h = Math.min(D, H)-Math.max(B, F);
        long common = 0;
        if(w>0 && h>0)
            common = w*h;
        System.out.println((int)((C-A)*(D-B)+(G-E)*(H-F)-common));
        String s = "(7)-(0)+(4)";
        String[] str = s.split("[()]");
        System.out.println(calculate(s));
	}
	
	public static int calculate(String s)
    {
        if(s.length()==0)
            return 0;
        s = s.trim();
        if(s.charAt(0)=='(')
        {
            int idx = 1, count = 1;
            while(idx<s.length() && count!=0)
            {
            	if(s.charAt(idx)=='(')
            		count++;
            	else if(s.charAt(idx)==')')
            		count--;
                idx++;
            }
            int num = calculate(s.substring(1, idx-1));
            //idx++;
            while(idx<s.length() && s.charAt(idx)==' ')
                idx++;
            if(idx==s.length())
                return num;
            if(s.charAt(idx)=='+')
                return num + calculate(s.substring(idx+1, s.length()));
            else
                return num - calculate(s.substring(idx+1, s.length()));
        }
        else
        {
            int idx = 0;
            while(idx<s.length() && s.charAt(idx)>='0' && s.charAt(idx)<='9')
                idx++;
            int num = Integer.parseInt(s.substring(0, idx));
            while(idx<s.length() && s.charAt(idx)==' ')
                idx++;
            if(idx==s.length())
                return num;
            if(s.charAt(idx)=='+')
                return num + calculate(s.substring(idx+1, s.length()));
            else
                return num - calculate(s.substring(idx+1, s.length()));
        }
    }
}