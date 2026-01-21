package Oneup.Story5;

public class MyString {
    public String str;
    int count=1;
     
    public MyString(String s){
        this.str=s;
        
    }
    
    
   
    public boolean IsPalindrome(String str,int start,int end){

        if(start>=end) return true;

         if (str.charAt(start) != str.charAt(end))
            return false;

         return IsPalindrome(str, start + 1, end-1 );
    } 
    public void GetComprasedString(String str,int start,int end){
        if(str.length()==0) return;
        if(start==end)  {System.out.println(str.charAt(start)+""+count); return;}
       if (str.charAt(start) == str.charAt(start + 1)) {
            count++;
        } else {
            System.out.print(str.charAt(start) + "" + count);
            count = 1;
        }
        
         GetComprasedString(str, start+1, end);

    }
    

}