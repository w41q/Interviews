
public class rotateimage
{
	public static void main(String[] args)
	{
		int matrix[][] = new int[5][5];

		matrix[0][0] = 1; matrix[0][1] = 2; matrix[0][2] = 3; matrix[0][3] = 4; matrix[0][4] = 5;
		matrix[1][0] = 6; matrix[1][1] = 7; matrix[1][2] = 8; matrix[1][3] = 9; matrix[1][4] = 10;
		matrix[2][0] = 11; matrix[2][1] = 12; matrix[2][2] = 13; matrix[2][3] = 14; matrix[2][4] = 15;
		matrix[3][0] = 16; matrix[3][1] = 17; matrix[3][2] = 18; matrix[3][3] = 19; matrix[3][4] = 20;
		matrix[4][0] = 21; matrix[4][1] = 22; matrix[4][2] = 23; matrix[4][3] = 24; matrix[4][4] = 25;
		
		function(matrix);
	}
	
	public static void function(int[][] matrix)
	{
		int rows = matrix.length;
        if(rows==0)
        {
            return;
        }
        int cols = matrix[0].length;
        if(rows!=cols)
            return;
        if(rows%2==0)
        {
            int width = cols/2;
            for(int i=0;i<width;i++)
            {
                for(int j=0;j<width;j++)
                {
                    // col: cols-i, row:j
                    int tmp = matrix[j][cols-1-i];
                    matrix[j][cols-1-i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for(int i=width;i<2*width;i++)
            {
                for(int j=0;j<width;j++)
                {
                    // col: width-i+width, row:j
                    int tmp = matrix[j][2*width-i-1];
                    matrix[j][2*width-i-1] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for(int i=width;i<2*width;i++)
            {
                for(int j=width;j<2*width;j++)
                {
                    // col: width-i+width, row:j
                    int tmp = matrix[j][2*width-i-1];
                    matrix[j][2*width-i-1] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }
        else
        {
            int width = (cols-1)/2;
            for(int i=0;i<width;i++)
            {
                for(int j=0;j<width;j++)
                {
                    // col: cols-i, row:j
                    int tmp = matrix[j][cols-1-i];
                    matrix[j][cols-1-i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for(int i=width+1;i<rows;i++)
            {
                for(int j=0;j<width;j++)
                {
                    // col: width-i+width-1, row:j
                    int tmp = matrix[j][2*width-i];
                    matrix[j][2*width-i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for(int i=width+1;i<rows;i++)
            {
                for(int j=width+1;j<cols;j++)
                {
                    // col: width-i+width-1, row:j
                    int tmp = matrix[j][2*width-i];
                    matrix[j][2*width-i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
            for(int i=0;i<width;i++)
            {
                int tmp = matrix[width][cols-1-i];
                matrix[width][cols-1-i] = matrix[i][width];
                matrix[i][width] = tmp;
            }
            for(int j=0;j<width;j++)
            {
                int tmp = matrix[j][width];
                matrix[j][width] = matrix[width][j];
                matrix[width][j] = tmp;
            }
            for(int i=width+1;i<rows;i++)
            {
                int tmp = matrix[width][2*width-i];
                matrix[width][2*width-i] = matrix[i][width];
                matrix[i][width] = tmp;
            }
        }
	}
}
