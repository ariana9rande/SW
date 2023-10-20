public class 더_크게_합치기
{
    public int solution(int a, int b)
    {
        Integer ab, ba;

        ab = Integer.parseInt(((Integer)a).toString() + ((Integer)b).toString());
        ba = Integer.parseInt(((Integer)b).toString() + ((Integer)a).toString());

        return ab > ba? ab : ba;
    }
}
