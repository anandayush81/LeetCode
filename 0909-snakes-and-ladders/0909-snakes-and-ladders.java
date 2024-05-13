// class Solution {
//     public int snakesAndLadders(int[][] board) {
        
//     }
// }

// import java.util.*;

class Solution {
    int n;
    class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    Pair getCoord(int s) {
        int row = n - 1 - (s - 1) / n;
        int col = (s - 1) % n;
        if ((n % 2 == 1 && row % 2 == 1) || (n % 2 == 0 && row % 2 == 0))
            col = n - 1 - col;
        return new Pair(row, col);
    }
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int steps = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;
        que.add(1);
        boolean[] seen = new boolean[n * n + 1];
        while (!que.isEmpty()) {
            int N = que.size();
            while (N-- > 0) {
                int x = que.poll();
                if (x == n * n)
                    return steps;
                for (int k = 1; k <= 6; k++) {
                    if (x + k > n * n)
                        break;
                    Pair coord = getCoord(x + k);
                    int r = coord.first;
                    int c = coord.second;
                    if (visited[r][c])
                        continue;
                    visited[r][c] = true;
                    if (board[r][c] == -1)
                        que.add(k + x);
                    else {
                        que.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
