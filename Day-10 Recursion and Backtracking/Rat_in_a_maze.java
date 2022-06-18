class Solution {
    static boolean isSafe(int x, int y, int[][] visited, int[][] m, int n) {
        if (((x >= 0 && x < n) && (y >= 0 && y < n)) && (m[x][y] == 1) && (visited[x][y] == 0))
            return true;

        else
            return false;
    }

    static void solve(int[][] m, int n, ArrayList<String> ans, String path, int x, int y, int[][] visited) {

        // you have reached at x , y
        // base case
        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }

        visited[x][y] = 1;

        // 4 choices : U , D , L , R

        // down
        int newX = x + 1;
        int newY = y;
        if (isSafe(newX, newY, visited, m, n)) {
            path = path + "D";
            solve(m, n, ans, path, newX, newY, visited);
            path = path.substring(0, path.length() - 1);
        }

        // up
        newX = x - 1;
        newY = y;
        if (isSafe(newX, newY, visited, m, n)) {
            path = path + "U";
            solve(m, n, ans, path, newX, newY, visited);
            path = path.substring(0, path.length() - 1);
        }

        // left
        newX = x;
        newY = y - 1;
        if (isSafe(newX, newY, visited, m, n)) {
            path = path + "L";
            solve(m, n, ans, path, newX, newY, visited);
            path = path.substring(0, path.length() - 1);
        }

        // right
        newX = x;
        newY = y + 1;
        if (isSafe(newX, newY, visited, m, n)) {
            path = path + "R";
            solve(m, n, ans, path, newX, newY, visited);
            path = path.substring(0, path.length() - 1);
        }

        visited[x][y] = 0;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();

        int[][] visited = new int[n][n];

        if (m[0][0] == 0)
            return ans;

        int srcX = 0, srcY = 0;
        String path = "";

        solve(m, n, ans, path, srcX, srcY, visited);
        Collections.sort(ans);
        return ans;
    }
}