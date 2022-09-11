class Solution {
    public int[] countBits(int n) {
        int[] toReturn = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            int counter = 0;
            for(int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j) == '1') {
                    counter++;
                }
            }
            toReturn[i] = counter;
        }
        
        return toReturn;
    }
}