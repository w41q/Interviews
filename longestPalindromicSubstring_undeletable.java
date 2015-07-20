//	Un-deletable Version
public class longestPalindromicSubstring_undeletable
{
	public static void main(String[] args)
	{
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		//String s = "abcdecba";
		System.out.println(lps_dp(s));
	}
	
	public static String lps_dp(String s)
	{
		char cha[] = s.toCharArray();
		boolean palindrom[][] = new boolean[s.length()][s.length()];
		// default is false
//		for(int i=0;i<s.length();i++)
//		{
//			for(int j=0;j<s.length();j++)
//			{
//				palindrom[i][j] = false;
//			}
//		}
		
		int max_length = 1;
		int max_index[] = new int[2];
		for(int i=0;i<s.length()-1;i++)
		{
			palindrom[i][i] = true;
			if(cha[i]==cha[i+1])
			{
				palindrom[i][i+1] = true;
				max_length = 2;
				max_index[0] = i;
				max_index[1] = i+1;
			}
		}
		palindrom[s.length()-1][s.length()-1] = true;;
		
		for(int len=2;len<s.length();len++)
		{
			for(int i=0;i<s.length()-len;i++)
			{
				if(cha[i]==cha[i+len] && palindrom[i+1][i+len-1])
				{
					palindrom[i][i+len] = true;
					max_length = len;
					max_index[0] = i;
					max_index[1] = i+len;
				}
			}
		}
		System.out.println(max_length);
		System.out.println(max_index[0]+" "+max_index[1]);
        return s.substring(max_index[0], max_index[1]+1);
    }
}
