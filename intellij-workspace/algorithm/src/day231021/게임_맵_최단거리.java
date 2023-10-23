package 프로그래머스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class 게임_맵_최단거리
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] maps;
    static int[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayDeque<int[]> stack;
    static ArrayDeque<int[]> queue;

// dfs로 접근했다가 실패

//    public static int solution(int[][] maps)
//    {
//        int cnt = 0;
//        stack = new ArrayDeque<>();
//        stack.addLast(new int[]{0, 0});
//
//        if(maps.length >= 2 && maps[0].length >= 2)
//            if (maps[maps.length - 1][maps[0].length - 2] == 0 && maps[maps.length - 2][maps[0].length - 1] == 0)
//                return -1;
//
//        while (!stack.isEmpty())
//        {
//            int[] current = stack.removeLast();
//            int cur_r = current[0];
//            int cur_c = current[1];
//
//            cnt++;
//            maps[cur_r][cur_c] = 0;
//
//            if (cur_r == maps.length - 1 && cur_c == maps[0].length - 1)
//            {
//                return cnt;
//            }
//
//            for (int i = 0; i < 4; i++)
//            {
//                int nr, nc;
//                nr = cur_r + dr[i];
//                nc = cur_c + dc[i];
//
//                if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length)
//                    continue;
//
//                if (maps[nr][nc] == 0)
//                    continue;
//
//                stack.addLast(new int[]{nr, nc});
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args)
//    {
//        maps =
//                new int[][]
//                        {
//                                {1, 0, 1, 1, 1},
//                                {1, 0, 1, 0, 1},
//                                {1, 0, 1, 1, 1},
//                                {1, 1, 1, 0, 1},
//                                {0, 0, 0, 0, 1}
//                        };
//
//        System.out.println(solution(maps));
//    }

    // bfs로 접근
    public static int solution(int[][] maps)
    {
        // maps 세로 길이
        int n = maps.length;
        // maps 가로 길이
        int m = maps[0].length;
        visited = new int[n][m];
        queue = new ArrayDeque<>();

        queue.addLast(new int[]{0, 0, 1});

        while (!queue.isEmpty())
        {
            int[] current = queue.removeFirst();
            int cur_r = current[0];
            int cur_c = current[1];
            int cur_dist = current[2];

            // 원래 방문처리했던 위치
//            visited[nr][nc] = 1;

            if (cur_r == n - 1 && cur_c == m - 1)
                return cur_dist;

            for (int i = 0; i < 4; i++)
            {
                int nr = cur_r + dr[i];
                int nc = cur_c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                if (maps[nr][nc] == 0 || visited[nr][nc] == 1)
                    continue;

                // queue에 넣기 전에 방문처리를 하도록 수정하니까 시간초과 통과함 이유는 모름
                visited[nr][nc] = 1;
                queue.addLast(new int[]{nr, nc, cur_dist + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        maps = new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
}
