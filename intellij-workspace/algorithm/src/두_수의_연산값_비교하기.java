public class 두_수의_연산값_비교하기
{
    public int solution(int a, int b)
    {
        Integer ab, x;

        ab = Integer.parseInt(((Integer)a).toString() + ((Integer)b).toString());
        x = a * b * 2;

        return ab > x? ab : x;
    }
}
