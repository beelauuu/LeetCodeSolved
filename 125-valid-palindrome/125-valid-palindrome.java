class Solution {
    public boolean isPalindrome(String s) {
        String copy = s.replaceAll("[^A-Za-z0-9]","");
        copy = copy.toLowerCase();
        
        char[] array = copy.toCharArray();
        List<Character> og = new ArrayList<>();
        List<Character> rev = new ArrayList<>();
        
        for(char c: array) {
            og.add(c);
            rev.add(c);
        }
        
        Collections.reverse(rev);
        
        for(int i = 0; i < og.size(); i++) {
            if(og.get(i) != rev.get(i)) {
                return false;
            }
        }
        
        
        return true;
    }
}