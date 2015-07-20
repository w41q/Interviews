public class countandsay
{
	public static void main(String[] args)
	{
		System.out.println(function(4));
	}
	
	public static String function(int n)
	{
		if(n<=0)
            return "";
        String pre = "1";
        for(int i=1;i<n;i++)
        {
            String cur = "";
            int idx = 0;
            while(idx<pre.length())
            {
                int count = 0, ptr = idx;
                char c = pre.charAt(idx);
                while(ptr<pre.length() && pre.charAt(ptr)==c)
                {
                	count++;
                	ptr++;
                }
                cur += ""+count+c;
                idx = ptr;
            }
            pre = cur;
        }
        return pre;
	}
}
