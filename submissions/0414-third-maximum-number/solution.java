class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums ){
            if(!pq.contains(i)){
            pq.add(i);
            }
        }
        int th = 0;
        int max = pq.peek();
        for(int i = 0 ; i < 3 ;i++ ){
            if(!pq.isEmpty()){
                th = pq.remove();
            }else{
                th = max;
            }
        }
        return th;
    }
}
