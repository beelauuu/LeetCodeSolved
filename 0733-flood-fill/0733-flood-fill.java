class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return helper(image, sr, sc, color, image[sr][sc]);
}

public int[][] helper(int[][] image, int sr, int sc, int color, int beginning) {
    if(sr >= image.length || sr < 0 || sc < 0 || sc >= image[sr].length || image[sr][sc] == color)  {
            return image;
        }
        
        if(image[sr][sc] != color && image[sr][sc] == beginning) {
            image[sr][sc] = color;
            helper(image, sr+1, sc, color, beginning);
            helper(image, sr, sc+1, color, beginning);
            helper(image,sr-1, sc, color, beginning);
            helper(image,sr, sc-1, color, beginning);
        }
        return image;
    }
}