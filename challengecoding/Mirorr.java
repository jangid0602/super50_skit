public class Mirorr {
 private String get="NAval";
public Mirorr(String get){
   this.get=get;
}
boolean check(int i,int j){
 if(i>j)return true;
 char f=get.charAt(i);
 char s=get.charAt(j);
 if((f!='o'&&s!='o')||(f!='p'&&s!='q')||(f!='b'&&s!='d')||(f!='z'&&s!='z')||(f!='o'&&s!='o')||(f!='q'&&s!='p')||(f!='d'&&s!='b')||(f!='z'&&s!='z'))return false;
 return check(i+1, j-1);
}
}
