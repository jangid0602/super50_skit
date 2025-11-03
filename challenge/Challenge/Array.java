import java.util.*;
class Array{

    public List<List<Integer>> ans=new ArrayList<>();
    void combinationalSum(int ind,int target,List<Integer> temp,List<Integer> arr){
        if (ind==arr.size()){
            if (target==0){
            ans.add(temp);
            }
            return ;
        }

        temp.add(arr.get(ind));
        combinationalSum(ind,target-arr.get(ind),temp,arr);
        temp.remove(arr.get(ind));
        combinationalSum(ind+1,target-arr.get(ind),temp,arr);

        return ans.size();
    }
    public static void main(String[] args){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Scanner sc =new Scanner(System.in);

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        int targetSum=sc.nextInt();
        Array obj=new Array();
        obj.combinationalSum(0,targetSum,temp,arr);
        System.out.println(obj.ans.size());
    }
}