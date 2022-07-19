public class Clock
{
    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m)
    {
        if (h < 0 || h > 23) throw new IllegalArgumentException("hours must be between 0 and 23");
        if (m < 0 || m > 59) throw new IllegalArgumentException("minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s)
    {
        if (s.length() == 5 && s.charAt(2) == ':')
        {
            String hrs = s.substring(0, 2);
            boolean hnumeric = true;
            try { int numH = Integer.parseInt(hrs); }
            catch (NumberFormatException e) { hnumeric = false; }
            if (hnumeric)
            {
                String mnts = s.substring(3,5);
                boolean mnumeric = true;
                try { int numM = Integer.parseInt(mnts); }
                catch (NumberFormatException e) { mnumeric = false; }
                if (mnumeric)
                {
                    hours = Integer.parseInt(s.substring(0,2));
                    minutes = Integer.parseInt(s.substring(3,5));
                    if (hours < 0 || hours > 23) throw new IllegalArgumentException("hours must be between 0 and 23");
                    if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("minutes must be between 0 and 59");
                }
                else throw new IllegalArgumentException("argument is in the wrong format");
            }
            else throw new IllegalArgumentException("argument is in the wrong format");
        }
        else throw new IllegalArgumentException("argument is in the wrong format");
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString()
    {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that)
    {
        if (this.hours < that.hours) return true;
        if (this.hours > that.hours) return false;
        return this.minutes < that.minutes;
    }

    // Adds 1 minute to the time on this clock.
    public void tic()
    {
        this.minutes++;
        if (this.minutes == 60)
        {
            this.hours++;
            this.minutes = 0;
        }
        if (this.hours == 24) this.hours = 0;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta)
    {
        if (delta < 0) throw new IllegalArgumentException("argument is negative");
        this.minutes += delta;
        if (this.minutes > 59)
        {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
        if (this.hours > 23) this.hours = this.hours % 24;
    }

    // Test client (see below).
    public static void main(String[] args)
    {
        int h = 23;
        int m = 59;
        Clock clock1 = new Clock(h, m);
        StdOut.println(clock1);
        String strclock = "11:13";
        Clock clock2 = new Clock(strclock);
        StdOut.println(clock2);
        StdOut.println(clock1.isEarlierThan(clock2));
        StdOut.println(clock2.isEarlierThan(clock1));
        clock1.tic();
        StdOut.println(clock1);
        clock2.tic();
        StdOut.println(clock2);
        clock1.toc(43);
        StdOut.println(clock1);
        clock2.toc(143);
        StdOut.println(clock2);
    }
}
