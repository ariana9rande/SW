public class 조건_문자열
{
    public int solution(String ineq, String eq, int n, int m)
    {
        if(eq.equals("!"))
        {
            switch(ineq)
            {
                case "<":
                    return n < m ? 1 : 0;
                case ">":
                    return n > m ? 1 : 0;
            }
        }
        else
            switch(ineq)
            {
                case "<":
                    return n <= m ? 1 : 0;
                case ">":
                    return n >= m ? 1 : 0;
            }
        return -1;
    }
}
