public class Birthday
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] count = new int[n + 2];
        for (int i = 0; i < trials; i++)
        {
            int[] a = new int[n + 2];
            for (int j = 0; j < n; j++)
            {
                int r = (int) (Math.random() * n);
                if (a[r] == 1)
                {
                    count[j] += 1;
                    break;
                }
                else a[r] = 1;
            }
        }
        double[] fraction = new double[n];
        fraction[0] = 0.0;
        for (int i = 1; i < fraction.length; i++)
            fraction[i] = (count[i] / (double) trials) + fraction[i - 1];
        System.out.println(1 + "\t" + count[0] + "\t" + fraction[0]);
        for (int i = 0; fraction[i] <= 0.5; i++)
            System.out.println((i + 2) + "\t" + count[i + 1] + "\t" + fraction[i + 1]);
        System.out.println();

    }
}
