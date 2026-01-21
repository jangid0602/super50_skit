
public class OxygenTank{

    static String solve(String s){

        String ans = "";
        int n = s.length();
        int i  = 0;
           while(i<n-1){
            char ch = s.charAt(i);
            char ch1 = s.charAt(i+1);
            if(ch==ch1){
                ans+=ch;
                ans+=ch1;
                i+=2;
                continue;
            }
            if(s.charAt(i)==Character.toLowerCase(s.charAt(i+1)) || Character.toLowerCase(s.charAt(i))==s.charAt(i+1)){
                i+=2;
                continue;
            }
            ans = ans+ s.charAt(i);
            i++;
        }
        if(i==n-1){
            ans = ans+s.charAt(i);
        }

        return ans;

    }

    public static void main(String[] args) {
        String s = "aAbBcC";
        System.out.println(solve(s));
    }
}