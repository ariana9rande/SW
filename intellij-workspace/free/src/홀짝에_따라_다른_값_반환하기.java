public class 홀짝에_따라_다른_값_반환하기
{
    public int solution(int n)
    {
        int odd = 0, even = 0;

        if(n % 2 != 0)
        {
            for(int i = 0; i <= n; i++)
            {
                if(i % 2 != 0)
                    odd += i;
            }
            return odd;
        }
        else
        {
            for(int i = 0; i <= n; i++)
            {
                if(i % 2 == 0)
                    even += i * i;
            }
            return even;
        }
    }
}
