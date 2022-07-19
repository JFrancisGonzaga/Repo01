public class AudioCollage
{
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha)
    {
        double[] amplified = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            amplified[i] = a[i] * alpha;
        }
        return amplified;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a)
    {
        double[] reversed = new double[a.length];
        for (int i = 0; i < a.length; i++)
            reversed[i] = a[a.length - 1 - i];
        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b)
    {
        double[] merged = new double [a.length + b.length];
        for (int i = 0; i < a.length; i++)
            merged[i] = a[i];
        for (int j = 0; j < b.length; j++)
            merged[a.length + j] = b[j];
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b)
    {
        double[] mix1;
        double[] mix2;
        if (a.length > b.length)
        {
            mix1 = a;
            mix2 = new double[a.length];
            for (int i = 0; i < b.length; i++)
                mix2[i] = b[i];
        }
        else if (b.length > a.length)
        {
            mix1 = b;
            mix2 = new double[b.length];
            for (int j = 0; j < a.length; j++)
                mix2[j] = a[j];
        }
        else
        {
            mix1 = a;
            mix2 = b;
        }
        double[] mixed = new double[mix1.length];
        for (int k = 0; k < mixed.length; k++)
        {
            mixed[k] = mix1[k] + mix2[k];
        }
        return mixed;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha)
    {
        double[] changed = new double[(int) Math.floor(a.length / alpha)];
        for (int i = 0; i < changed.length; i++)
        {
            changed[i] = a[(int) Math.floor(alpha * i)];
        }
        return changed;
    }

    // Creates an audio collage and plays it on standard audio.
    public static void main(String[] args)
    {
        double[] harp = StdAudio.read("harp.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] scratch = StdAudio.read("scratch.wav");
        double[] harps2 = merge(harp, harp);
        double[] beatbox2 = merge(beatbox, beatbox);
        double[] cow2 = changeSpeed(cow, 1.5);
        double[] part1;
        part1 = merge(piano, mix(piano, amplify(harps2, 1.3)));
        part1 = merge(part1, mix(part1, singer));
        double[] part2;
        part2 = merge(merge(buzzer, mix(beatbox2, cow2)), mix(beatbox2, reverse(cow2)));
        part2 = merge(part2, scratch);
        double[] masterpiece = merge(part1, part2);
        StdAudio.play(masterpiece);
    }
}
