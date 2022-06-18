public class Solution {
    static boolean colourPossible(int[][] mat, int node, int[] colour, int clr) {
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[node][j] == 1) {
                if (colour[j] == clr)
                    return false;
            }
        }
        return true;
    }

    static boolean solve(int[][] mat, int node, int m, int[] colour) {
        if (node == mat.length) // all coloring done
            return true;

        for (int i = 1; i <= m; i++) {
            if (colourPossible(mat, node, colour, i)) {
                colour[node] = i;
                if (solve(mat, node + 1, m, colour))
                    return true;
                else
                    colour[node] = 0; // backtrack
            }
        }
        return false;
    }

    public static String graphColoring(int[][] mat, int m) {
        int[] colour = new int[mat.length];
        if (solve(mat, 0, m, colour))
            return "YES";
        return "NO";
    }
}
