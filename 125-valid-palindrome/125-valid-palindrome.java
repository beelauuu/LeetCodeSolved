class Solution {
    public boolean isPalindrome(String s) {
        String copy = s.toLowerCase();
        copy = copy.replaceAll("[^A-Za-z0-9]","");
        
        for(int i = 0 ; i < copy.length()/2; i++) {
            if(copy.charAt(i) != copy.charAt(copy.length()-i-1)) {
                return false;
            }
        }
        return true;
        
        
    }
}