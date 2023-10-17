public class 코드_처리하기
{
    public static String solution(String code)
    {
        String answer = "";
        int mode = 0;
        for(int i = 0; i < code.length(); i++)
        {
            switch(mode)
            {
                case 0:
//                    System.out.println("mode 0");
                    if(code.charAt(i) != '1')
                    {
//                        System.out.println("mode 0 not 1");
                        if(i % 2 == 0)
                        {
//                            System.out.println("mode 0 not 1 even " + code.charAt(i) + " added");
                            answer += code.charAt(i);
                        }
                        break;
                    }
                    else
                    {
//                        System.out.println("mode 0 1 mode changed 0 to 1");
                        mode = 1;
                        break;
                    }
                case 1:
//                    System.out.println("mode 1");
                    if(code.charAt(i) != '1')
                    {
//                        System.out.println("mode 1 not 1");
                        if(i % 2 != 0)
                        {
//                            System.out.println("mode 1 not 1 odd " + code.charAt(i) + " added");
                            answer += code.charAt(i);
                        }
                        break;
                    }
                    else
                    {
//                        System.out.println("mode 1 1 mode changed 1 to 0");
                        mode = 0;
                        break;
                    }
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer;
    }

    public static void main(String[] args)
    {
        String code = "abc1abc1abc";
        System.out.println(solution(code));
    }
}
