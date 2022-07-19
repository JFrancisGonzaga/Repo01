public class Inversions
{
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a)
    {
        long cnt = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] > a[j])
                    cnt++;
            }
        }
        return cnt;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k)
    {
        int[] inverted = new int[n];
        int i = 0;
        int j = n - 1;
        while (n > 0)
        {
            if (k >= n - 1)
            {
                inverted[inverted.length - n] = j;
                k = k - (n - 1);
                j--;
            }
            else
            {
                inverted[inverted.length - n] = i;
                i++;
            }
            n--;
        }
        return inverted;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] inversion = generate(n, k);
        for (int i = 0; i < n; i++)
            StdOut.print(inversion[i] + " ");
        StdOut.println();
    }
}
