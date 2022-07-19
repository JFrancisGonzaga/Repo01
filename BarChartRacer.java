import java.util.Arrays;
public class BarChartRacer
{
    public static void main(String[] args)
    {
        In datafile = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title = datafile.readLine();
        String xAxis = datafile.readLine();
        String source = datafile.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (datafile.hasNextLine())
        {
            datafile.readLine();
            int num = Integer.parseInt(datafile.readLine());
            String[] string = new String[num];
            for (int i = 0; i < num; i++)
                string[i] = datafile.readLine();

            String[] names = new String[num];
            int[] values = new int[num];
            String[] categories = new String[num];

            for (int j = 0; j < num; j++)
            {
                int comma1 = string[j].indexOf(',');
                int comma2 = string[j].indexOf(',', comma1 + 1);
                int comma3 = string[j].indexOf(',', comma2 + 1);
                int comma4 = string[j].indexOf(',', comma3 + 1);
                names[j] = string[j].substring(comma1 + 1, comma2);
                values[j] = Integer.parseInt(string[j].substring(comma3 + 1, comma4));
                categories[j] = string[j].substring(comma4 + 1);
            }

            Bar[] bars = new Bar[num];
            for (int p = 0; p < num; p++)
            {
                bars[p] = new Bar(names[p], values[p], categories[p]);
            }
            Arrays.sort(bars);

            int comma = string[0].indexOf(',');
            chart.setCaption(string[0].substring(0, comma));

            for (int q = num - 1; q >= num - k; q--)
            {
                chart.add(bars[q].getName(), bars[q].getValue(), bars[q].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(200);
            chart.reset();
        }
    }
}
