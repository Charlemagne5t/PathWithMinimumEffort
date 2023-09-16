import java.util.Arrays;

public class Solution {
    int globalMinCost = Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;
        dfs(heights, 0, 0, visited, 0);

        return globalMinCost;
    }

    public void dfs(int[][] heights, int i, int j, boolean[][] visited, int currentScore) {
        if(i == heights.length - 1 && j == heights[0].length - 1){
            globalMinCost = Math.min(currentScore, globalMinCost);
            return;
        }
        if(currentScore >= globalMinCost){
            return;
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] dir: directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(nextI >= 0 && nextI < heights.length && nextJ >= 0 && nextJ < heights[0].length && !visited[nextI][nextJ]){
                visited[nextI][nextJ] = true;
                dfs(heights, nextI, nextJ, visited, Math.max(Math.abs(heights[i][j] - heights[nextI][nextJ]), currentScore));
                visited[nextI][nextJ] = false;
            }
        }

    }
}
