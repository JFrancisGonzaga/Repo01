public class Divisors
{
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) return 0;
        else if (a == 0) return b;
        else if (b == 0) return a;
        else
        {
            while (a > 0)
            {
                if (a < b)
                {
                    int k = a;
                    a = b;
                    b = k;
                }
                a = a % b;
            }
            return b;
        }
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b)
    {
        int gcd = gcd(a, b);
        if (a == 0 || b == 0) return 0;
        else return Math.abs((a / gcd) * b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b)
    {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n)
    {
        if (n == 1) return 1;
        else
        {
            int nums = 0;
            for (int i = 1; i < n; i++)
                if (areRelativelyPrime(n, i)) nums++;
            return nums;
        }
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));
    }
}
