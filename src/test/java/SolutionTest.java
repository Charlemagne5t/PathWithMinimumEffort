import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void minimumEffortPathTest1() {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5},
        };
        int expected = 2;
        int actual = new Solution().minimumEffortPath(heights);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void minimumEffortPathTest2() {
        int[][] heights = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5},
        };
        int expected = 1;
        int actual = new Solution().minimumEffortPath(heights);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minimumEffortPathTest3() {
        int[][] heights = {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1},
        };
        int expected = 0;
        int actual = new Solution().minimumEffortPath(heights);

        Assert.assertEquals(expected, actual);
    }
}
