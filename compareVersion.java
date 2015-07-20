import java.util.ArrayList;
import java.util.List;

public class compareVersion
{
	public static void main(String []args)
	{
		int a = 3;
		String s = Integer.toString(a);
		System.out.println(function("1.0", "1"));
	}
	
	public static int function(String version1, String version2)
    {
		String str1[] = version1.split("\\."), str2[] = version2.split("\\.");
        for(int i=0;i<Math.max(str1.length, str2.length);i++)
        {
        	if(i<str1.length && i<str2.length)
        	{
        		int a = Integer.parseInt(str1[i]), b = Integer.parseInt(str2[i]);
                if(a<b)
                    return -1;
                else if(a>b)
                    return 1;
        	}
        	else if(i>=str1.length)
        	{
        		int a = 0, b = Integer.parseInt(str2[i]);
                if(a<b)
                    return -1;
                else if(a>b)
                    return 1;
        	}
        	else if(i>=str2.length)
        	{
        		int a = Integer.parseInt(str1[i]), b = 0;
                if(a<b)
                    return -1;
                else if(a>b)
                    return 1;
        	}
        }
        return 0;
    }
}
