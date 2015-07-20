class wordsearch
{
	public static void main(String[] args)
	{
		char[][] b = new char[1][2];
		b[0][0] = 'a';
		b[0][1] = 'b';
//		b[0][2] = 'c';
		String s = "ab";
		System.out.println(function(b, s));
	}
	
	public static boolean function(char[][] board, String word)
	{
		if(board.length==0 || board[0].length==0 || word.length()==0)
            return false;
        int rows = board.length, cols = board[0].length;
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(check(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
	}
	
	public static boolean check(char[][] b, int row, int col, String s, int begin)
    {
        if(row<0 || row>=b.length || col<0 || col>=b[0].length || begin>s.length())
            return false;
        if(begin==s.length())
            return true;
        else
        {
            char c = b[row][col];
            if(c!=s.charAt(begin))
                return false;
            b[row][col] = '\0';
            boolean result =  check(b, row+1, col, s, begin+1) || check(b, row-1, col, s, begin+1) || check(b, row, col+1, s, begin+1) || check(b, row, col-1, s, begin+1);
            b[row][col] = c;
            return result;
        }
    }
}