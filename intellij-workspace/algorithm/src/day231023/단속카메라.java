package day231023;

import java.util.Arrays;

public class 단속카메라
{
    public static int solution(int[][] routes)
    {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 1;
        int current = routes[0][1];
        for(int i = 1; i < routes.length; i++)
        {
            if(routes[i][0] > current)
            {
                cnt++;
                current = routes[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args)
    {
//        int[][] routes = {
//                {-20, -15},
//                {-14, -5},
//                {-18, -13},
//                {-5, -3}
//        };

//        int[][] routes =
//                {
//                        {0, 10},
//                        {8, 20},
//                        {1, 7},
//                        {2, 8},
//                        {12, 14},
//                        {15, 17},
//                        {20, 23},
//                        {26, 30}
//                };

        int[][] routes = {
                {-20, 15},
                {-20, -15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        };

        for(int[] row : routes)
            System.out.println(Arrays.toString(row));

        System.out.println(solution(routes));
    }
}
