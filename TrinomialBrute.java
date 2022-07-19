public class TrinomialBrute
{
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k)
    {
        long t;
        if (n == 0 && k == 0) t = 1;
        else if (k < -n || k > n) t = 0;
        else t = trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
        return t;
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
