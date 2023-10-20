package day231020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1913
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        // 상 우 하 좌
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = n / 2, c = n / 2;
        int cnt = 1, dir = 0, check = 0;
        int x = -1, y = -1;
        for(int i = 0; i < n * n; i++)
        {
            arr[r][c] = i + 1;
            if(i + 1 == target)
            {
                x = r + 1;
                y = c + 1;
            }
            System.out.printf("arr[%d][%d] = %d", r, c, arr[r][c]);
            System.out.print(" check = " + check);
            System.out.println(" cnt = " + cnt);

            r += dr[dir];
            c += dc[dir];
            check++;

            if(check == cnt)
            {
                dir++;
                dir %= 4;
                check = 0;
                cnt++;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(x + " " + y);
    }
}
