import java.util.*;
public class FloorLava {
  private ArrayList<Integer>array=new ArrayList<>();
  private int k=0;
  public FloorLava( ArrayList<Integer>array,int k){
    this.array=array;
    this.k=k;
  }
   int n=array.size();
  public int maximumLenght(){
  int count=1;
  int maxx=1;
  for(int i=1;i<n;i++){
    int f=array.get(i-1);
    int s=array.get(i);
    if((s-f)<=k)count++;
    else count=1;
    maxx=Math.max(count,maxx);
  }
  return maxx;
  }
}
