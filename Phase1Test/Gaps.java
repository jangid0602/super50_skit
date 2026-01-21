package Oneup.Phase1Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gaps {
    public static void Gap(int[] arr,int k,int n){
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==2) {
                System.out.println("[1]");
                //System.out.println(" ");
            }
             else System.out.println(arr[i]+1+"-"+(arr[i+1]-1));
        }
        if(arr[n-1]!=k){
            System.out.println(arr[n-1]+"-"+k);
        }
    
        
    }
    public static void main(String[] args) {
        System.out.println("enter no.of pages you want to enter ");
        Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();

      int[] arr =new int[n];
      System.out.println("enter page numbers");
       
       
       for(int i=0;i<n;i++){
        int x=sc.nextInt();
        //sc.nextLine();
        arr[i]=x;

        

       }
       System.out.println("enter total no.of pages");
       int k=sc.nextInt();
       Gap(arr,k,n);

    }
    
}
