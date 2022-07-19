public class ShannonEntropy {
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m];
        while (!StdIn.isEmpty())
        {
            int x = StdIn.readInt();
            count[x - 1] += 1;
        }
        double sumPi = 0.0;
        for (int i = 0; i < count.length; i++)
            sumPi += count[i];
        double[] pi = new double[count.length];
        for (int j = 0; j < pi.length; j++)
            pi[j] = count[j] / sumPi;
        double[] pilog = new double[pi.length];
        for (int k = 0; k < pilog.length; k++)
            if (pi[k] == 0) pilog[k] = 0.0;
            else pilog[k] = -(pi[k] * (Math.log(pi[k])/Math.log(2)));
        double shannonEntropy = 0.0;
        for (int s = 0; s < pilog.length; s++)
            shannonEntropy += pilog[s];
        StdOut.printf("%.4f\n", shannonEntropy);




    }

}
