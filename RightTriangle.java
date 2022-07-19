public class RightTriangle
{
    public static void main(String[] args)
    {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        // Check if each integer is positive
        boolean positives;
        positives = a > 0 && b > 0;
        positives = positives && c > 0;
        // Check is sides form a Right Triangle
        boolean rightTriangle;
        rightTriangle = (a*a == b*b + c*c) || (b*b == a*a + c*c) || (c*c == a*a + b*b);

        System.out.println(positives && rightTriangle);
    }
}
