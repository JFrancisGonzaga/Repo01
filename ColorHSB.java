public class ColorHSB
{
    private final int h1;
    private final int s1;
    private final int b1;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b)
    {
        if (h < 0 || h > 359) throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100) throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100) throw new IllegalArgumentException("the brightness must be between 0 and 100");
        h1 = h;
        s1 = s;
        b1 = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString()
    {
        return "(" + this.h1 + ", " + this.s1 + ", " + this.b1 + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale()
    {
        return this.s1 == 0 || this.b1 == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that)
    {
        if (that == null) throw new IllegalArgumentException("argument is null");
        int hdist = Math.min(Math.abs(this.h1 - that.h1), 360 - Math.abs(this.h1 - that.h1));
        int sdist = this.s1 - that.s1;
        int bdist = this.b1 - that.b1;
        return hdist * hdist + sdist * sdist + bdist * bdist;
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color1 = new ColorHSB(h, s, b);
        String closestColorName = null;
        int mindist = 359 * 359 + 100 * 100 + 100 * 100;
        ColorHSB closestColorHSB = null;
        while (!StdIn.isEmpty())
        {
            String colorName = StdIn.readString();
            int h1 = StdIn.readInt();
            int s1 = StdIn.readInt();
            int b1 = StdIn.readInt();
            ColorHSB color2 = new ColorHSB(h1, s1, b1);
            int dist = color1.distanceSquaredTo(color2);
            if (dist < mindist)
            {
                mindist = dist;
                closestColorName = colorName;
                closestColorHSB = color2;
            }
        }
        StdOut.println(closestColorName + " " + closestColorHSB);
    }
}
