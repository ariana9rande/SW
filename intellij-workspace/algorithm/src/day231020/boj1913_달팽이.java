package day231020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1913_달팽이
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


        // n * n 배열의 가운데부터 시작
        int r = n / 2, c = n / 2;

        // 1 1 2 2 2 2 3 3 3 3 3 3  -> x/2 번 저장하고 방향전환 후 x/2 번 저장, 그 뒤 x+1번 저장하고
        // 방향전환 후 x+1번 저장. 의 방식으로 반복되므로 limit = 2로 잡고(x) limit회 만큼 반복하면서
        // limit/2회 만큼 저장했을 때(x/2) 방향전환이 이루어지도록 구현
        
        int i = 0, dir = 0, limit = 2;

        int x = -1, y = -1;
        while(true)
        {
            if(i + 1 == target)
            {
                x = r + 1;
                y = c + 1;
            }

            for(int cnt = 1; cnt <= limit; cnt++)
            {
                arr[r][c] = i + 1;

                if(i + 1 == target)
                {
                    x = r + 1;
                    y = c + 1;
                }

                if(i == n * n || (r == 0 && c == 0))
                    break;
//                System.out.println("i = " + i);
//                System.out.printf("arr[%d][%d] = %d cnt = %d limit = %d dir = %d\n", r, c, arr[r][c], cnt, limit, dir);
                r += dr[dir];
                c += dc[dir];

                if(cnt == limit / 2)
                {
                    dir++;
                    dir %= 4;
                }
                i++;
            }
            dir++;
            dir %= 4;
            limit += 2;

            if(i == n * n || (r == 0 && c == 0))
                break;
        }

        StringBuilder answer = new StringBuilder();
        
        for(int j = 0; j < n; j++)
        {
            for(int k = 0; k < n; k++)
            {
                answer.append(arr[j][k]).append(" ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
        System.out.println(x + " " + y);
    }
}
