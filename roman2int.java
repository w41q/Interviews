//	Un-deletable Version
public class roman2int
{
	public static void main(String[] args)
	{
		String s = "DCXXI";
		System.out.println(convert(s));
	}
	
	public static int convert(String s)
    {
		char cha[] = s.toCharArray();
        int result = 0;
        for(int i=0;i<cha.length;i++)
        {
            char c = cha[i];
            if(c=='M')
            {
                if(i>=1 && cha[i-1]=='C')
                {
                    result += 900;
                    //i++;
                }
                else
                    result += 1000;
            }
            if(c=='D')
            {
                if(i>=1 && (cha[i-1]=='C'))
                    result += 400;
                else
                    result += 500;
            }
            if(c=='C')
            {
                if(i+1<cha.length && cha[i+1]=='M')
                {
                    result += 900;
                    i++;
                }
                else if(i>=1 && cha[i-1]=='X')
                {
                    result += 90;
                    //i++;
                }
                else if(i+1<cha.length && cha[i+1]=='D')
                    continue;
                else
                    result += 100;
            }
            if(c=='L')
            {
                if(i>=1 && (cha[i-1]=='X'))
                    result += 40;
                else
                    result += 50;
            }
            if(c=='X')
            {
                if(i+1<cha.length && cha[i+1]=='C')
                {
                    result += 90;
                    i++;
                }
                else if(i>=1 && cha[i-1]=='I')
                    result += 9;
                else if(i+1<cha.length && cha[i+1]=='L')
                    continue;
                else
                    result += 10;
            }
            if(c=='V')
            {
                if(i>=1 && (cha[i-1]=='I'))
                    result += 4;
                else
                    result += 5;
            }
            if(c=='I')
            {
                if(i+1<cha.length && cha[i+1]=='X')
                {
                    result += 9;
                    i++;
                }
                else if(i+1<cha.length && cha[i+1]=='V')
                    continue;
                else
                    result += 1;
            }
        }
        
        return result;
    }
}
