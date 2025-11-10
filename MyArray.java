import java.util.ArrayList;

public class MyArray {
   ArrayList<Integer>List=new ArrayList<>();
   public MyArray( ArrayList<Integer>List){
    this.List=List;
   }


  public int TheSumThatStandOut(){
     ArrayList<Integer>prefix=new ArrayList<>();
     prefix.add(List.get(0));
     for(int i=1;i<List.size();i++){
      prefix.add(prefix.get(i-1)+List.get(i));
     }
     ArrayList<Integer>Suffix=new ArrayList<>();
     Suffix.add(List.get(List.size()-1));
     for(int i=List.size()-2;i>=0;i--){
      Suffix.add(Suffix.get(i+1)+List.get(i));
     }
     for(int i=0;i<List.size();i++){
      if(prefix.get(i)==Suffix.get(i))return i;
     }
     return -1;
   }



  public int findTheOddOneOut(){
   for(int i=0;i<List.size();i++){
    int count=0;
    for(int j=0;j<List.size();j++){
    if(List.get(i)==List.get(j))count++;
    }
    if(count==1)return List.get(i);
  }
  return -1;
  }
 public boolean pairFinder(int number){
      for(int i=0;i<List.size();i++){
        for(int j=i+1;j<List.size();j++){
          if(List.get(i)+List.get(j)==number)return true;
        }
      }
      return false;
   }
   public int minimumFlip(){
    int countOne=0;
    int countZero=0;
    for(int i=0;i<List.size();i++){
    if(List.get(i)==1)countOne++;
    else if(List.get(i)==0)countZero++;
    else return -1;
   }
   return Math.min(countOne,countZero);
  }

  public int totalEnergyUsed(int intialEnergy){
    if(List.get(0)>intialEnergy)return -1;
    int i;
    for( i=0;i<List.size();i++){
      intialEnergy-=List.get(i);
      if(intialEnergy<0)return i;
    }
    return i;
  }


  public int TheMinimalistPainter(){
     int maxx=Integer.MIN_VALUE;
     for(int i=0;i<List.size();i++){
      maxx=Math.max(maxx,List.get(i));
     }
     int sum=0;
     for(int i=0;i<List.size();i++)sum+=List.get(i);
     return sum-=maxx;
  }
}
