public class 등차수열의_특정한_항만_더하기
{
    public int solution(int a, int d, boolean[] included)
    {
        int sum = 0, cnt = 0;
        for(int i = 0; i < included.length; i++)
        {
            if(included[i])
            {
                sum += i;
                cnt++;
            }
        }
        return a * cnt + d * sum;
    }
}
