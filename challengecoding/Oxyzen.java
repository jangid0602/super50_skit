public class Oxyzen {
  private String input="Naval";
  public Oxyzen(String input){
    this.input=input;
  }
  public String check(){
    int n=input.length();
    String ans="";
    if(n<2)return ans;
    for(int i=1;i<n;i++){
      int f=input.charAt(i-1);
      int s=input.charAt(i);
      if((f-s)==32||(f-s)==-32){
         i++;
        continue;
      }
      else {
        ans+=f;
        if(i==n-1)ans+=s;
      }
      
    }
    return ans;
  }
}
