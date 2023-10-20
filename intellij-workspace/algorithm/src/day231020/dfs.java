package day231020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class dfs
{





    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int cnt = 1;
    static int nr = -1, nc = -1;
    static ArrayList<String> stack = new ArrayList<>();

    public static int dfs(int[][] matrix, int[][] visited, int r, int c)
    {
        visited[r][c] = 1;
        stack.add(r + " " + c);
        int n = matrix[0].length;

        while(!stack.isEmpty())
        {
            for(int i = 0; i < 4; i++)
            {
                nr = r + dr[i];
                nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if(visited[r][c] == 0 && matrix[r][c] == 1)
                {
                    stack.add(r + " " + c);
                    visited[r][c] = 1;
                    matrix[r][c] = 0;
                    cnt++;
                }
                int[] pop = {Integer.parseInt(stack.remove(stack.size() - 1).split(" ")[0]), Integer.parseInt(
                        stack.remove(stack.size() - 1).split(" ")[1])};
                r = pop[0];
                c = pop[1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int[] row : matrix)
        {
            System.out.println(Arrays.toString(row));
        }

        int result = -1;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int temp = -1;
                if(matrix[i][j] == 1)
//                    temp = dfs(i, j);
                if(temp > result)
                    result = temp;
            }
        }

        System.out.println(result);
    }
}
/*
7
0 0 0 0 0 1 1
0 0 0 0 0 0 0
0 0 1 1 1 0 0
0 0 1 0 1 1 1
0 1 1 0 0 1 0
0 0 1 1 1 0 0
0 0 0 0 0 0 0
 */