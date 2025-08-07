class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> s1 = new ArrayList<>();
        for(int i = 1 ; i <= n ;i++){
            if(i % 3 == 0 && i % 5 == 0){
                s1.add("FizzBuzz");
            }else if(i % 3 == 0){
                s1.add("Fizz");
            }else if(i % 5 == 0){
                s1.add("Buzz");
            }else{
                s1.add(Integer.toString(i));
            }
        }
        return s1;
    }
}
