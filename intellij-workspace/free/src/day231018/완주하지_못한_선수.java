package day231018;

import java.util.ArrayList;
import java.util.Arrays;

public class 완주하지_못한_선수
{
    public static String solution(String[] participant, String[] completion)
    {
        ArrayList<String> participant2 = new ArrayList<>();
        ArrayList<String> completion2 = new ArrayList<>();

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(String p : participant)
            participant2.add(p);

        for(String c : completion)
            completion2.add(c);

        for(int i = 0; i < completion2.size(); i++)
        {
            for(int j = 0; j < participant2.size(); j++)
            {
                if(participant2.get(j).equals(completion2.get(i)))
                {
                    // System.out.println(i + " " + j);
                    // System.out.println("c = " + completion2);
                    // System.out.println("p = " + participant2);
                    completion2.remove(completion2.get(i));
                    participant2.remove(participant2.get(j));
                    i--;
                    break;
                }
            }
        }

        return participant2.get(0);
    }

    public static void main(String[] args)
    {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }
}
