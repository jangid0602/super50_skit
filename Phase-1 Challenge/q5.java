public class q5 {
    
    static String candyCrushCharcters(String str)
    {
        StringBuilder sb = new StringBuilder("");
         
        for(int i =0;i<str.length()-1;i++)
        {
            
            char ch1 = str.charAt(i+1);
            char ch2 = str.charAt(i);


            if(ch1 < ch2 || ch2 < ch1)
            {
                if((char)(ch1 + 32) == ch2  || (char)(ch2 + 32) == ch1)
                {
                    i++;
                    if(i == str.length() - 1 && ch1 != str.charAt(str.length() - 1)) sb.append(str.charAt(str.length() - 1));
                    continue;
                }
            }
                 
                sb.append(ch2);
        }
         
        return sb.toString();
    }
    public static void main(String[] args) {
        
        String str = "ABbC";
        System.out.println(candyCrushCharcters(str));

    }
}
