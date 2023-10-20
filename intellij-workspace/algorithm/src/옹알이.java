public class 옹알이
{
    public static int solution(String[] babbling)
    {
        int answer = 0;
        for(String b: babbling)
        {
            while(b.contains("aya") || b.contains("ye") || b.contains("woo") || b.contains("ma"))
            {
                if(b.contains("aya"))
                    b = b.replace("aya", " ");
                else if(b.contains("ye"))
                    b = b.replace("ye", " ");
                else if(b.contains("woo"))
                    b = b.replace("woo", " ");
                else
                    b = b.replace("ma", " ");
            }
            while(b.contains(" "))
                b = b.replace(" ", "");

            if(b.isEmpty())
                answer += 1;
        }
        return answer;
    }

    public static void main(String[] args)
    {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(solution(babbling));

    }
}
