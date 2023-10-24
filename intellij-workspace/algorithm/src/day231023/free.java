package day231023;

import java.util.ArrayList;
import java.util.Arrays;

public class free
{
    static String[] arr = {"A", "B", "C"}; // 재료 배열
    static String[] sel = new String[3]; // 뽑아오는 문자를 담을 selection


    static void perm(int depth)
    { // 각자 뎁스에서는?
        if(depth == 3)
        { // 최고뎁스에 도달한경우면?
            System.out.println(Arrays.toString(sel)); // 현재 뭘 뽑았는지 프린트
            return;
        }

        for(int i = 0; i < 3; i++)
        { // 각각 3개의 포인터를 떨어트리면서

            sel[depth] = arr[i]; // 현재 i가 가리키고 있는 위치의 문자를 해당 depth의 sel에 넣음
            System.out.print("sel = " + Arrays.toString(sel));
            System.out.print(" i = " + i);
            System.out.println(" depth = " + depth);
            perm(depth + 1); // 다음 재귀 단계로 감
            System.out.println("perm(" + depth + ") returned");
            System.out.print("sel = " + Arrays.toString(sel));
            System.out.print(" i = " + i);
            System.out.println(" depth = " + depth);
        }
    }

    public static void main(String[] args)
    {
        perm(0);
    }
}