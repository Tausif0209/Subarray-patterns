import java.util.HashMap;

public class SubarraysWithSumk {
  public int cntSubarrays(int[] arr, int k) {
       if(arr.length==1) return arr[0]==k?1:0;
       HashMap<Integer,Integer> map=new HashMap<>();
       map.put(0,1);
       int sum=0,count=0;
       for(int el:arr){
           sum+=el;
           count+=map.getOrDefault(sum-k,0);
           map.put(sum,map.getOrDefault(sum,0)+1);
       } return count;
    }
}
