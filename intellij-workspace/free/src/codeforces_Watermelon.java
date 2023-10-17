import java.util.Scanner;

public class codeforces_Watermelon
{
    public static String solution(int input)
    {
        if(input == 2)
            return "NO";
        else if(input % 2 == 0)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(solution(input));
    }
}
