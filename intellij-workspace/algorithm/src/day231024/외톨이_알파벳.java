package day231024;

import java.util.*;

public class 외톨이_알파벳
{
    public static String solution(String input_string)
    {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        list.add(String.valueOf(input_string.charAt(0)));

        for(int i = 1; i < input_string.length(); i++)
        {
            if(!String.valueOf(input_string.charAt(i - 1)).equals(String.valueOf(input_string.charAt(i))))
                list.add(String.valueOf(input_string.charAt(i)));
        }

        for(String s : list)
        {
            if(!check.contains(s))
                check.add(s);
            else
                if(!sb.toString().contains(s))
                    sb.append(s);
        }

        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        String answer = String.valueOf(arr).isEmpty() ? "N" : String.valueOf(arr);

        return answer;
    }

    public static void main(String[] args)
    {
        String input_string = "edeaaabbccd";
        System.out.println(solution(input_string));
    }
}
