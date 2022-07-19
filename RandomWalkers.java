public class RandomWalkers
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int steps = 0;
        for (int t = 0; t <= trials; t++)
        {
            int x = 0;
            int y = 0;
            while (Math.abs(x) + Math.abs(y) != r)
            {
                if (Math.random() > 0.5)
                {
                    if (Math.random() > 0.5) x++;
                    else x--;
                }
                else
                {
                    if (Math.random() > 0.5) y++;
                    else y--;
                }
                steps++;
            }
        }
        double aveSteps = steps / (double) trials;
        System.out.println("average number of steps = " + aveSteps);

    }
}
