package day231024;

public class 체육대회
{
    static int[][] ability;
    static int[] check_i;
    static int[] check_j;
    static int[] selected;
    static int answer = -1;

    public static void perm(int depth, int sum)
    {
        if(sum > answer)
        {
            answer = sum;
        }

        if(depth == ability[0].length)
        {
            for(int i : selected)
                sum += i;
            return;
        }

        for(int i = 0; i < ability.length; i++)
        {
            for(int j = 0; j < ability[0].length; j++)
            {
                if(check_i[i] == 0 && check_j[j] == 0)
                {
                    check_i[i] = 1;
                    check_j[j] = 1;
                    selected[depth] = ability[i][j];
                    sum += ability[i][j];

                    perm(depth + 1, sum);
                    check_i[i] = 0;
                    check_j[j] = 0;
                    sum -= ability[i][j];
                }
            }
        }
    }

    public static int solution(int[][] ability)
    {
        selected = new int[ability[0].length];
        check_i = new int[ability.length];
        check_j = new int[ability[0].length];

        perm(0, 0);

        return answer;
    }

    public static void main(String[] args)
    {
        ability = new int[][]
                {
                        {40, 10, 10},
                        {20, 5, 0},
                        {30, 30, 30},
                        {70, 0, 70},
                        {100, 100, 100}
                };

        System.out.println(solution(ability));
    }
}
