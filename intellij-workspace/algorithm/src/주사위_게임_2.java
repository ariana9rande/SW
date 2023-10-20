public class 주사위_게임_2
{
    public static int solution(int a, int b, int c)
    {
        int sum1, sum2, sum3;
        sum1 = a + b + c;
        sum2 = sum1 * (a * a + b * b + c * c);
        sum3 = sum2 * (a * a * a + b * b * b + c * c * c);

        if(a == b && b == c)
            return sum3;
        else if(a != b && b != c && a != c)
            return sum1;
        return sum2;
    }

    public static void main(String[] args)
    {
        int a = 4, b = 4, c = 4;
        System.out.println(solution(a, b, c));
    }
}
