public class SumOfSubarrays {
  class Solution {
    public int subarraySum(int[] arr) {
         if(arr.length==1) return arr[0];
         int sum=0;
         for(int i=0;i<arr.length;i++){
             sum+=(arr.length-i)*(i+1)*arr[i];
         } return sum;
    }
}
}
