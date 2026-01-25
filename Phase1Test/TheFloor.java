package Oneup.Phase1Test;

import java.util.Scanner;

public class TheFloor {
    public static boolean floor(int[] arr,int k,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n-1;j++){
                if(arr[i]-arr[j]<=k){
                    System.out.println(arr[i]+" "+arr[j]);
                }

            }
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter array size");
        int n=sc.nextInt();
        int[] arr =new int[n];
        System.out.println("enter elements");
        for(int i=0;i<n;i++){
        int x=sc.nextInt();
        //sc.nextLine();
        arr[i]=x;

        }
        System.out.println("enter difference");
        int k=sc.nextInt();
        floor(arr,k,n);

    }
    
}
