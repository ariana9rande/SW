package day231023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 피로도
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int perm(int k, int[][] dungeons, String[] sel, int[] check, int cnt, int depth)
    {
        if(depth == dungeons.length)
        {
            return -1;
        }

        for(int i = 0; i < dungeons.length; i++)
        {
            if(check[i] == 0 && dungeons[i][0] <= k)
            {
                check[i] = 1;
                cnt++;
                sel[depth] = Arrays.toString(dungeons[i]);
                k -= dungeons[i][1];
                perm(k, dungeons, sel, check, cnt,depth + 1);

                System.out.println("sel = " + Arrays.toString(sel));
                System.out.print("k = " + k);
                System.out.print(" cnt = " + cnt);
                System.out.println(" depth = " + depth);
                check[i] = 0;
                k += dungeons[i][1];
            }
        }
        return cnt;
    }

    public static int solution(int k, int[][] dungeons)
    {
        String[] sel = new String[dungeons.length];
        int[] check = new int[dungeons.length];
        int cnt = 0;
        int answer = perm(k, dungeons, sel, check, cnt, 0);

        for(String item : sel)
            if(item != null)
                cnt++;

        System.out.println(Arrays.toString(sel));

        return cnt;
    }

    public static void main(String[] args)
    {
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10},
                {20, 10},
                {80, 0},
        };

        System.out.println(solution(k, dungeons));
    }
}
