public class Huntingtons
{
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna)
    {
        int repeats = 0;
        int max = 0;
        int i = 0;
        while (i < dna.length() - 2)
        {
            if (dna.substring(i, i + 3).equals("CAG") && i < dna.length() - 5)
            {
                repeats++;
                i += 2;
            }
            else if (dna.substring(i, i + 3).equals("CAG") && i >= dna.length() - 5)
            {
                repeats++;
                if (repeats > max) max = repeats;
                i += 2;
            }
            else if (!dna.substring(i, i + 3).equals("CAG"))
            {
                if (repeats > max) max = repeats;
                repeats = 0;
            }
            i++;
        }
       return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s)
    {
        String removedn = s.replace("\n", "");
        String removedt = removedn.replace("\t", "");
        String removeds = removedt.replace(" ", "");
        return removeds;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats)
    {
        if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        else if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington's";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        In datafile = new In(args[0]);
        String s = datafile.readAll();
        s = removeWhitespace(s);
        int repeats = maxRepeats(s);
        String diagnosis = diagnose(repeats);
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnosis);
    }
}
