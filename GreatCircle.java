public class GreatCircle
{
    public static void main(String[] args)
    {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double d = Double.parseDouble(args[3]);

        double distance = 2 * 6371.0 * Math.asin(Math.sqrt(Math.sin(Math.toRadians((c-a)/2.0)) *
                Math.sin(Math.toRadians((c-a)/2.0)) + Math.cos(Math.toRadians(a)) * Math.cos(Math.toRadians(c)) *
                        Math.sin(Math.toRadians((d-b)/2.0)) * Math.sin(Math.toRadians((d-b)/2.0))));
        System.out.println(distance + " kilometers");
    }
}
