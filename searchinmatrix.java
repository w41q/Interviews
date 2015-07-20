
public class searchinmatrix
{
	public static void main(String[] args)
	{
		int matrix[][] = new int[3][10];
//
//		matrix[0][0] = 1; matrix[0][1] = 2; matrix[0][2] = 3; matrix[0][3] = 4; matrix[0][4] = 5;
//		matrix[1][0] = 6; matrix[1][1] = 7; matrix[1][2] = 8; matrix[1][3] = 9; matrix[1][4] = 10;
//		matrix[2][0] = 11; matrix[2][1] = 12; matrix[2][2] = 13; matrix[2][3] = 14; matrix[2][4] = 15;
//		matrix[3][0] = 16; matrix[3][1] = 17; matrix[3][2] = 18; matrix[3][3] = 19; matrix[3][4] = 20;
//		matrix[4][0] = 21; matrix[4][1] = 22; matrix[4][2] = 23; matrix[4][3] = 24; matrix[4][4] = 25;
		//[119,121,122,124,125,125,125,126,127,128],[131,133,134,134,134,135,135,137,137,139],[141,143,145,147,148,150,150,150,150,152],
		matrix[0][0] = 119; matrix[0][1] = 121; matrix[0][2] = 122; matrix[0][3] = 124; matrix[0][4] = 125; matrix[0][5] = 125; matrix[0][6] = 125; matrix[0][7] = 126; matrix[0][8] = 127; matrix[0][9] = 128;
		matrix[1][0] = 131; matrix[1][1] = 133; matrix[1][2] = 134; matrix[1][3] = 134; matrix[1][4] = 134; matrix[1][5] = 135; matrix[1][6] = 135; matrix[1][7] = 137; matrix[1][8] = 137; matrix[1][9] = 139;
		matrix[2][0] = 141; matrix[2][1] = 143; matrix[2][2] = 145; matrix[2][3] = 147; matrix[2][4] = 148; matrix[2][5] = 150; matrix[2][6] = 150; matrix[2][7] = 150; matrix[2][8] = 150; matrix[2][9] = 152;
		
//		matrix[0][0] = 1; matrix[0][1] = 3; matrix[0][2] = 5; matrix[0][3] = 7;
//		matrix[1][0] = 10; matrix[1][1] = 11; matrix[1][2] = 16; matrix[1][3] = 20;
//		matrix[2][0] = 23; matrix[2][1] = 30; matrix[2][2] = 34; matrix[2][3] = 50;
		
//		int matrix[][] = new int[2][1];
//		matrix[0][0] = 1; matrix[1][0] = 3;
		int target = 150;
		System.out.println(function(matrix, target));
	}
	
	public static boolean function(int[][] matrix, int target)
	{
		int rows = matrix.length;
        if(rows==0)
            return false;
        int cols = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[rows-1][cols-1])
            return false;
        int top = 0, bottom = rows-1;
        while(top<bottom)
        {
        	if(matrix[bottom][0]<target)
        	{
        		top = bottom;
            	break;
        	}
            int mid = (top+bottom)/2;
            if(matrix[mid][0]==target)
                return true;
            else if(matrix[mid][0]<target)
                top = mid;
            else
                bottom = mid-1;
            if(top+1==bottom)
            	break;
        }
        if(matrix[bottom][0]==target)
        	return true;
        int left = 0, right = cols-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(matrix[top][mid]==target)
                return true;
            else if(matrix[top][mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
	}
	
	public static boolean function2(int[][] matrix, int target)
	{
		if(matrix==null || matrix.length==0 || matrix[0].length==0)
			return false;
		int rows = matrix.length, cols = matrix[0].length;
		int begin = 0, end = rows*cols-1;
		while(begin<end)
		{
			int mid = (begin+end)/2;
			int r = mid/cols, c = mid%cols;
			if(matrix[r][c]==target)
				return true;
			else if(matrix[r][c]<target)
				begin = mid+1;
			else
				end = mid-1;
		}
		return false;
	}
}
