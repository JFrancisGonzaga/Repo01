public class Minesweeper
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mines = new boolean[m + 2][n + 2];
        int t = 0;
        while (t < k)
        {
            int mineRow = (int) (Math.random() * m);
            int mineCol = (int) (Math.random() * n);
            if (mines[mineRow + 1][mineCol + 1]) t--;
            else mines[mineRow + 1][mineCol + 1] = true;
            t++;
        }
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (!mines[i][j])
                {
                    int count = 0;
                    if (mines[i - 1][j]) count++;
                    if (mines[i + 1][j]) count++;
                    if (mines[i][j - 1]) count++;
                    if (mines[i][j + 1]) count++;
                    if (mines[i - 1][j - 1]) count++;
                    if (mines[i - 1][j + 1]) count++;
                    if (mines[i + 1][j - 1]) count++;
                    if (mines[i + 1][j + 1]) count++;
                    System.out.print(count + "  ");
                }
                else System.out.print("*  ");
            }
            System.out.println();
        }
    }

}
