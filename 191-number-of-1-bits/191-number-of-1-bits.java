public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int ones = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                ones++;
            }
        }
        
        return ones;
    }
}