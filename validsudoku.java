import java.util.HashSet;
import java.util.Set;


public class validsudoku
{
	public static void main(String[] args)
	{
		char board[][] = new char[9][9];

		String s[] = new String[9];
//		s[0] = ".87654321";
//		s[1] = "2........";
//		s[2] = "3........";
//		s[3] = "4........";
//		s[4] = "5........";
//		s[5] = "6........";
//		s[6] = "7........";
//		s[7] = "8........";
//		s[8] = "9........";
		s[0] = "..5.....6";
		s[1] = "....14...";
		s[2] = ".........";
		s[3] = ".....92..";
		s[4] = "5....2...";
		s[5] = ".......3.";
		s[6] = "...54....";
		s[7] = "3.....42.";
		s[8] = "...27.6..";
		for(int i=0;i<9;i++)
		{
			board[i] = s[i].toCharArray();
		}
		
		boolean result = function2(board);
	}
	
	public static boolean function(char[][] board)
	{
		if(board.length!=9 || board[0].length!=9)
            return false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                boolean table[] = new boolean[9];
                for(int m=0;m<3;m++)
                {
                    for(int n=0;n<3;n++)
                    {
                        int row = i*3+m, col = j*3+n;
                        if(board[row][col]!='.')
                        {
                            if(table[board[row][col]-'1']!=true)
                                table[board[row][col]-'1']=true;
                            else
                                return false;
                        }
                        
                    }
                }
            }
        }
        
        for(int i=0;i<9;i++)
        {
            boolean table[] = new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(table[board[i][j]-'1']!=true)
                        table[board[i][j]-'1']=true;
                    else
                        return false;
                }
            }
        }
        
        for(int i=0;i<9;i++)
        {
            boolean table[] = new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                    if(table[board[j][i]-'1']!=true)
                        table[board[j][i]-'1']=true;
                    else
                        return false;
                }
            }
        }
        return true;
	}
	
	public static boolean function2(char[][] board)
	{
		if(board.length==0 || board[0].length==0 || board.length!=board[0].length)
            return false;
        int n = board.length;
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                char c = board[i][j];
                if(board[i][j]!='.')
                {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
            set.clear();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                char c = board[j][i];
                if(board[i][j]!='.')
                {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
            set.clear();
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int p=0;p<3;p++)
                {
                    for(int q=0;q<3;q++)
                    {
                        int row = i*3+p, col = j*3+q;
                        if(board[row][col]!='.')
                        {
                            char c = board[row][col];
                            if(set.contains(c))
                                return false;
                            else
                                set.add(c);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
	}
}
