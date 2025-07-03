class Solution {
    public List<String> partitionString(String s) {
        Set<String> seen =new HashSet<>();
        List <String> out = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            StringBuilder str = new StringBuilder();
            int j = i;
            while(j < s.length()){
                str.append(s.charAt(j));
                String cur = str.toString();
                if(!seen.contains(cur)){
                    seen.add(cur);
                    out.add(cur);
                    break;
                }
                j++;
            }
            i=j+1;
        }
        return out;
    }
}
