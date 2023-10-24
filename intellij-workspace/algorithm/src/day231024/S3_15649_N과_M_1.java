package day231024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_15649_N과_M_1
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] selected;
    static int[] check;
    static StringBuilder sb;
    static int cnt = 0;

    public static void perm(int depth)
    {
        if(depth == m)
        {
            for(int n : selected)
            {
                sb.append(n);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(check[i] == 0)
            {
                check[i] = 1;
                selected[depth] = i + 1;
                cnt++;
//                System.out.println("check = " + Arrays.toString(check));
                perm(depth + 1);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        selected = new int[m];
        check = new int[n];
        sb = new StringBuilder();

        perm(0);

        System.out.println(sb);
    }
}
