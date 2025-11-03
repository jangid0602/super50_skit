import java.util.*;
class String1{

    String charShift(int ind,int shift,String s){
        String st;
        for(int i=shift;i<s.size();i++){
            st=st+s[i];
        }

        for(int i=1;i<shift;i++){
            st=st+s[i];
        }

        return st;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=new String(sc.nextLine);

        int shift=sc.nextInt();
        String1 obj=new String1();
        String answer=obj.charShift(0,shift,s);
        System.out.println(answer);
        
    }
}