class Solution {
    public boolean isNumber(String s) {
                String pattern = "^[+-]?" +
                         "(" +
                             "(\\d+\\.\\d*)|" +     
                             "(\\.\\d+)|" +        
                             "(\\d+)" +
                         ")" +
                         "([eE][+-]?\\d+)?$";       
        return s.trim().matches(pattern);
    }
    
}
