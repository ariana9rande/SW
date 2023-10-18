package day231018;

import java.util.LinkedHashSet;

public class 중복된_문자_제거
{
    public String solution(String my_string)
    {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String answer = "";

        for(int i = 0; i < my_string.length(); i++)
        {
            linkedHashSet.add(String.valueOf(my_string.charAt(i)));
        }

        for(String s : linkedHashSet)
            answer += s;

        return answer;
    }
}
