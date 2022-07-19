public class BandMatrix
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i == j) System.out.print("*  ");
                if (j > i)
                {
                    if (j - i <= width) System.out.print("*  ");
                    else System.out.print("0  ");
                }
                if (i > j)
                {
                    if (i - j <= width) System.out.print("*  ");
                    else System.out.print("0  ");
                }
            }
            System.out.println();
        }


    }
}
