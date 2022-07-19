public class MaximumSquareSubmatrix
{
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a)
    {
        int n = a.length;
        int[][] subs = new int[n][n];
        for (int i = 0; i < n; i++)
            subs[0][i] = a[0][i];
        for (int j = 0; j < n; j++)
            subs[j][0] = a[j][0];
        for (int p = 1; p < n; p++)
        {
            for (int q = 1; q < n; q++)
            {
                if (a[p][q] == 1)
                {
                    int min = Math.min(subs[p - 1][q], subs[p - 1][q - 1]);
                    min = Math.min(subs[p][q - 1], min);
                    subs[p][q] = min + 1;
                }
                else subs[p][q] = 0;
            }
        }
        int max = StdStats.max(subs[0]);
        for (int r = 1; r < n; r++)
            max = Math.max(max, StdStats.max(subs[r]));
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        }
        StdOut.println(size(a));
    }
}
