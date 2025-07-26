import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RemovingConflictingPair {
  public long maxSubarrays(int n, int[][] conflictingPairs) {
        if(n==2 || conflictingPairs.length==1) return 1L*n*(n+1)/2;
        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int[] pair:conflictingPairs){
            Arrays.sort(pair);
            PriorityQueue<Integer> pq=map.getOrDefault(pair[1],new PriorityQueue<>((a,b)->b-a));
            pq.offer(pair[0]);
            map.put(pair[1],pq);
        }
        HashMap<Integer,Long> contribution=new HashMap<>();
        long validSubarrays=0,extras=0;
        int index1=0,index2=0;
        for(int i=1;i<=n;i++){
            if(map.containsKey(i)) {
                PriorityQueue<Integer> pq1=map.getOrDefault(i,new PriorityQueue<>());
                pq1.offer(index1);
                pq1.offer(index2);
                index1=pq1.poll();
                index2=pq1.poll();
            }
            validSubarrays+=i-index1;
            Long val=contribution.getOrDefault(index1,0L);
            extras=Math.max(extras,val+(index1-index2));
            contribution.put(index1,val+(index1-index2));
        } return validSubarrays+extras;
    }
  
}
