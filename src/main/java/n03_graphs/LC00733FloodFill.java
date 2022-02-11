package n03_graphs;

public class LC00733FloodFill {
    private void floodFillImage(int[][] image, int sr, int sc, int origColor, int newColor)
    {

        if (image[sr][sc] == newColor || image[sr][sc] != origColor)
            return;

        image[sr][sc] = newColor;

        // up pixel
        if (sr - 1 >= 0)
            floodFillImage(image, sr - 1, sc, origColor, newColor);

        // down pixel
        if (sr + 1 < image.length)
            floodFillImage(image, sr + 1, sc, origColor, newColor);

        // left pixel
        if (sc - 1 >= 0)
            floodFillImage(image, sr, sc - 1, origColor, newColor);

        // right pixel
        if (sc + 1 < image[0].length)
            floodFillImage(image, sr, sc + 1, origColor, newColor);



    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int[][] newImage = image.clone();
        floodFillImage(newImage, sr, sc, image[sr][sc], newColor);
        return newImage;
    }
}
