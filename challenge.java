import java.util.*;
class Solve{
    
    private String str;
    private int k;
    Solve(String str,int k){
        
        this.str=str;
        this.k=k;
    }
    String shiftingCipher(){
        int size=str.length();
        String answer="";
        for(int i=0;i<size;i++){
            if((str.charAt(i)>='a' && str.charAt(i)<='z')){
                int x=((str.charAt(i)-'a')+k)%26;
                answer+=(char)((x+'a'));
            }
            else if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                int x=((str.charAt(i)-'A')+k)%26;
                answer+=(char)((x+'A'));
            }
            else{
                answer+=str.charAt(i);
            }
        }
        return answer;
    }
}

public class challenge{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter string");
        String str=scanner.nextLine();
        System.out.println("Enter target");
        int k=scanner.nextInt();
        Solve obj=new Solve(str,k);
        System.out.println(obj.shiftingCipher());


    }
}