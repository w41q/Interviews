//	Un-deletable Version
public class zigzag
{
	public static void main(String[] args)
	{
		String s = "ABC";
		System.out.println(convert2(s, 2));
	}
	
	public static String convert(String s, int nRows)
    {
		if(s.length()<=nRows || nRows==1)
			return s;
        char cha[] = s.toCharArray();
        char out[] = new char[cha.length];
        int head = 0;
        int step[] = new int [2];
        step[0] = 2*(nRows - 1);
        step[1] = 2*(nRows - 1);
        int offset = 0;
        int cursor = 0;
        int newline = 0;
        while((head+1)%(nRows+1)!=0)
        {
        	
            while(head+offset<=cha.length-1)
            {
                out[cursor] = cha[head+offset];
                offset += step[newline%2];
                cursor++;
                newline++;
            }
            head++;
            step[0] -= 2;
            step[1] = 2*(nRows - 1) - step[0];
            if(step[0]==0)
            {
                step[0] = 2*(nRows - 1);
                step[1] = 2*(nRows - 1);
            }
            newline = 0;
            offset = 0;
        }
        
        String output = new String(out);
        return output;
    }
	
	public static String convert2(String s, int nRows)
    {
		if(s==null || s.length()==0 || nRows<=0)
            return "";
        if(s.length()<=nRows || nRows==1)
            return s;
        String result = "";
        for(int begin=0;begin<nRows;begin++)
        {
            int idx = begin;
            int[] step = new int[2];
            if(begin==0 || begin==nRows-1)
            {
            	step[0] = 2*(nRows-1);
            	step[1] = step[0];
            }
            else
            {
            	step[0] = 2*(nRows-1)-2*begin;
                step[1] = 2*(nRows-1)-step[0];
            }
            int count = 0;
            while(idx<s.length())
            {
                result += s.charAt(idx);
                idx += step[count%2];
                count++;
            }
        }
        return result;
    }
}
