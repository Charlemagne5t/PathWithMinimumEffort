import java.util.*;

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;
        PriorityQueue<int[]> priorityQueue  = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[] start = {0,0,0};
        priorityQueue.add(start);
        while (!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            if(current[0] == heights.length - 1 && current[1] == heights[0].length - 1){
                return current[2];
            }
            int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            visited[current[0]][current[1]] = true;
            for (int[] dir: directions) {
                int nextI = current[0] + dir[0];
                int nextJ = current[1] + dir[1];
                if(nextI >= 0 && nextI < heights.length && nextJ >= 0 && nextJ < heights[0].length && !visited[nextI][nextJ]){
                    priorityQueue.add(new int[]{nextI, nextJ, Math.max(current[2], Math.abs(heights[current[0]][current[1]] - heights[nextI][nextJ]))});
                }
            }
        }

        return 0;
    }
}
