package com.hjh.main;

import java.util.Scanner;

public class aaa {
   public static void main(String[] args) {
      System.out.println("10개의 정수를 입력하세요");
      Scanner sc = new Scanner(System.in);
      int [] x = new int[10]; 
      
      for(int i=0; i< 10; i++) {
         x[i] = sc.nextInt();
      }
      
      int max = x[0];   // 최대값
      int min = x[0];   // 최소값

      for(int i = 1; i < x.length; i++){
          if(max < x[i]) {
              max = x[i];
          }
          if(min > x[i]) {
              min = x[i];
          }
      }   
      int odd_sum = 0, odd_num = 0, even_sum = 0, even_num = 0;
      int even_min = 0, odd_max = 0;
      
      for(int i = 0; i < x.length; i++)
      {
          if(x[i] % 2 == 0)
          {
              even_sum += x[i];
              even_num++;
              even_min = x[i];
          }
          else
          {
              odd_sum += x[i];
              odd_num++;
              odd_max = x[i];
          }
      }
      
      
      
      for(int i=0; i<x.length; i++) {
         if(x[i] % 2 ==0) { //짝수 최소구하기
            if(x[i] < even_min)
            	even_min = x[i];
         }
         else //홀수 최대
         {
             if(x[i] > odd_max)
            	 odd_max = x[i];
         }
      }
      
      System.out.println("최대값 : " + max + " 최소값 : " + min);
      System.out.println("홀수들의 평균과 짝수들의 평균의 차이는" + (((double)odd_sum/(double)odd_num)-((double)even_sum/(double)even_num)));
      System.out.println("홀수에 대한 최대값은" + odd_max);
      System.out.println("짝수에 대한 최소값은" + even_min);

      sc.close();
   }

}