//	Deletable Version
public class longestPalindromicSubstring_deletable
{
	public static void main(String[] args)
	{
		//String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		String s = "abcdecba";
		System.out.println(lps_dp(s));
	}
	
	public static String lps_dp(String s)
	{
		char cha[] = s.toCharArray();
		int length[][] = new int[s.length()][s.length()];
		int max_length = 1;
		int max_index[] = new int[2];
		for(int i=0;i<s.length()-1;i++)
		{
			length[i][i] = 1;
			if(cha[i]==cha[i+1])
			{
				length[i][i+1] = 2;
				max_length = 2;
				max_index[0] = i;
				max_index[1] = i+1;
			}
		}
		length[s.length()-1][s.length()-1] = 1;
		
		for(int len=2;len<s.length();len++)
		{
			for(int i=0;i<s.length()-len;i++)
			{
				if(cha[i]==cha[i+len])
				{
					length[i][i+len] = length[i+1][i+len-1] + 2;
					if(length[i][i+len]>max_length)
					{
						max_length = length[i][i+len];
						max_index[0] = i;
						max_index[1] = i+len;
					}
				}
				else
					length[i][i+len] = length[i][i+len-1]>length[i+1][i+len]?length[i][i+len-1]:length[i+1][i+len];
			}
		}
		System.out.println(max_length);
		System.out.println(max_index[0]+" "+max_index[1]);
		System.out.println(length[0][s.length()-1]);
        return s.substring(max_index[0], max_index[1]+1);
    }
}
