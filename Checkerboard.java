public class Checkerboard
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n + 1);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int xb = 0; xb < n; xb++)
            for (int yb = 0; yb < n; yb += 2.0)
            {
                if (xb % 2 == 0) StdDraw.filledSquare(xb + 0.5, yb + 0.5, 0.5);
                if (xb % 2 != 0 && yb != n - 1) StdDraw.filledSquare(xb + 0.5, yb + 1.5, 0.5);
            }
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int xg = 0; xg < n; xg++)
            for (int yg = 0; yg < n; yg += 2.0)
            {
                if (xg % 2 != 0) StdDraw.filledSquare(xg + 0.5, yg + 0.5, 0.5);
                if (xg % 2 == 0 && yg != n - 1) StdDraw.filledSquare(xg + 0.5, yg + 1.5, 0.5);
            }
    }
}
