package day231018;

import java.util.*;

public class 신고_결과_받기
{
    public static int[] solution(String[] id_list, String[] report, int k)
    {
        Map<String, Integer> id_list_map = new LinkedHashMap<>();
        Map<String, ArrayList<String>> report_list = new LinkedHashMap<>();
        Map<String, Integer> getMail = new LinkedHashMap<>();

        for(String s : id_list)
        {
            id_list_map.put(s, 0);
            report_list.put(s, new ArrayList<>());
            getMail.put(s, 0);
//            System.out.println("s = " + s);
        }

//        System.out.println(Arrays.toString(id_list));

        for(String s : report)
            if(report_list.containsKey(s.split(" ")[0]))
            {
                if(!report_list.get(s.split(" ")[0]).contains(s.split(" ")[1]))
                    report_list.get(s.split(" ")[0]).add(s.split(" ")[1]);
            }

        for(ArrayList<String> item : report_list.values())
        {
            for(String s : item)
                id_list_map.put(s, id_list_map.get(s) + 1);
        }


        ArrayList<String> banned = new ArrayList<>();

        for(String s : id_list_map.keySet())
        {
            if(id_list_map.get(s) >= k)
                banned.add(s);
        }

        for(String s : report_list.keySet())
        {
            for(String b : banned)
                if(report_list.get(s).contains(b))
                {
//                    System.out.println("report_list.get(s) = " + report_list.get(s));
                    getMail.put(s, getMail.get(s) + 1);
                }
        }

        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++)
        {
            result[i] = getMail.get(id_list[i]);
        }

//        System.out.println("id_list_map = " + id_list_map);
//        System.out.println("report_list = " + report_list);

        return result;
    }

    public static void main(String[] args)
    {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}
