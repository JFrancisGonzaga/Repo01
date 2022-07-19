public class RandomWalker
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        System.out.println("(0, 0)");
        while (Math.abs(x) + Math.abs(y) != r)
        {
            if (Math.random() > 0.5)
            {
                if (Math.random() > 0.5)
                {
                    x++;
                    System.out.println("(" + x + ", " + y + ")");
                }
                else
                {
                    x--;
                    System.out.println("(" + x + ", " + y + ")");
                }
            }
            else
            {
                if (Math.random() > 0.5)
                {
                    y++;
                    System.out.println("(" + x + ", " + y + ")");
                }
                else
                {
                    y--;
                    System.out.println("(" + x + ", " + y + ")");
                }
            }
            steps++;
        }
        System.out.println("steps = " + steps);
    }
}
