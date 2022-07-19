public class Ramanujan
{
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n)
    {
        long hi = (long) Math.cbrt(n);
        int cnt = 0;
        for (long a = 1; a <= hi; a++)
        {
            long a3 = a * a * a;
            double b = Math.cbrt(n - a3);
            if (b % 1 == 0) cnt++;
        }
        return cnt >= 4;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args)
    {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
