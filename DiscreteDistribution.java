public class DiscreteDistribution
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[m];
        int count = args.length;
        int[] b = new int[count - 1];
        for (int i = 0; i < b.length; i++)
            b[i] = Integer.parseInt(args[i + 1]);
        int[] sums = new int[b.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++)
            sums[i] = b[i - 1] + sums[i - 1];
        for (int i = 0; i < a.length; i++)
        {
            int r = (int) (Math.random() * sums[sums.length - 1]);
            int j = sums.length;
            for (int s = 0; s < j - 1; s++)
                if (r >= sums[s] && r < sums[s + 1])
                    a[i] = s + 1;
        }
        for (int j = 1; j <= a.length; j++)
        {
            System.out.print(a[j-1] + " ");
            if (j % 25 == 0 && j > 1) System.out.println();
        }
        System.out.println();
    }
}
