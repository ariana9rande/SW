package day231018;

import java.util.ArrayList;
import java.util.Arrays;

public class 완주하지_못한_선수
{
    public static String solution(String[] participant, String[] completion)
    {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < participant.length - 1; i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];

        return participant[participant.length - 1];
    }

    public static void main(String[] args)
    {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }
}
