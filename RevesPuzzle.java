public class RevesPuzzle
{
    private static void pole4(int n, String from, String temp, String to, String temp2)
    {
        int k = (int) (n + 1 - Math.round(Math.sqrt(2 * n + 1)));
        if (k == 0)
        {
            StdOut.println("Move disc " + 1 + " from " + from + " to " + to);
            return;
        }
        pole4(k, from, to, temp, temp2);
        pole3(n - k, k, from, temp2, to);
        pole4(k, temp, from, to, temp2);
    }
    private static void pole3(int n, int k, String from, String temp, String to)
    {
        if (n == 0) return;
        pole3(n-1, k, from, to, temp);
        StdOut.println("Move disc " + (n + k) + " from " + from + " to " + to);
        pole3(n-1, k, temp, from, to);
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        pole4(n, "A", "B", "D", "C");
    }
}
