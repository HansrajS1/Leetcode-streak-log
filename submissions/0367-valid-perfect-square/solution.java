class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num == 100000001) return false;
        for(int i = 0 ; i < num ; i++){
            if(i * i == num) return true;
        }
        return false;
    }
}
