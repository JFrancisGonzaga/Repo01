import java.awt.Color;
public class KernelFilter
{
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights)
    {
        int width = picture.width();
        int height = picture.height();

        int order = weights.length;

        double targetRed = 0.0;
        double targetGreen = 0.0;
        double targetBlue = 0.0;

        int temp_row = 0;
        int temp_col = 0;

        int[][] red = new int[height][width];
        int[][] green = new int[height][width];
        int[][] blue = new int[height][width];

        Color[][] targetColor = new Color[height][width];
        Picture target = new Picture(width, height);

        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < height; row++)
            {
                Color color = picture.get(col, row);
                red[row][col] = color.getRed();
                green[row][col] = color.getGreen();
                blue[row][col] = color.getBlue();
            }
        }

        for (int col = 0; col < width; col++)
        {
            for (int row = 0; row < height; row++)
            {
                targetRed = 0;
                targetGreen = 0;
                targetBlue = 0;

                for (int i = 0; i < order; i++)
                {
                    for (int j = 0; j < order; j++)
                    {
                        temp_col = (col - order / 2 + i + width) % width;
                        temp_row = (row - order / 2 + j + height) % height;

                        targetRed += (red[temp_row][temp_col] * weights[i][j]);
                        targetGreen += (green[temp_row][temp_col] * weights[i][j]);
                        targetBlue += (blue[temp_row][temp_col] * weights[i][j]);
                    }
                }

                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                targetColor[row][col] = new Color((int) Math.round(targetRed),
                                                  (int) Math.round(targetGreen),
                                                  (int) Math.round(targetBlue));
                target.set(col, row, targetColor[row][col]);
            }
        }
        return target;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture)
    {
        double[][] weights = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture)
    {
        double[][] weights = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        for (int i = 0; i < weights.length; i++)
            for (int j = 0; j < weights.length; j++)
                weights[i][j] = weights[i][j] / 16.0;
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture)
    {
        double[][] weights = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture)
    {
        double[][] weights = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture)
    {
        double[][] weights = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture)
    {
        double[][] weights = new double[9][9];
        for (int i = 0; i < weights.length; i++)
            weights[i][i] = 1 / 9.0;
        return kernel(picture, weights);
    }


    // Test client (ungraded).
    public static void main(String[] args)
    {
        String file = args[0];
        Picture picture = new Picture(file);

        Picture identity = identity(picture);
        identity.show();

        Picture gaussian = gaussian(picture);
        gaussian.show();

        Picture sharpen = sharpen(picture);
        sharpen.show();

        Picture laplacian = laplacian(picture);
        laplacian.show();

        Picture emboss = emboss(picture);
        emboss.show();

        Picture motionBlur = motionBlur(picture);
        motionBlur.show();
    }
}
