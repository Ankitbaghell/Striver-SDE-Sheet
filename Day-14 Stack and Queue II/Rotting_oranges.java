
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j)); // adding rotten orange element in queue
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Pair element = q.remove();
                // bfs in 4 directions
                for (int j = 0; j < 4; j++) {
                    int newRow = element.x + directions[j][0];
                    int newCol = element.y + directions[j][1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) { // inside or fresh
                        q.add(new Pair(newRow, newCol));
                        grid[newRow][newCol] = 0; // now mark as visited
                        freshOranges--; // fresh ==> rotten
                    }
                }
            }
        }
        if (freshOranges == 0)
            return time;
        else
            return -1;
    }
}