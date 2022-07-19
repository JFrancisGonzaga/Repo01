public class ThueMorse
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int[] thue = new int[n];
        for (int t = 1; t < thue.length; t++)
        {
            if (t % 2 == 0) thue[t] = thue[t / 2];
            if (t % 2 == 1) thue[t] = 1 - thue[t - 1];
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (thue[i] == thue[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}
