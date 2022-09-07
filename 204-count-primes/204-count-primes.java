class Solution {
   public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int counter = 0;
        for(int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
       
       
        for(int i = 2; i*i < primes.length; i++) {
            if(primes[i]) {
                for(int j = i; j*i < primes.length; j++) {
                    primes[i*j] = false;
                }
            }
        }
       
       for(int i = 2; i < primes.length; i++) {
           if(primes[i]) {
               counter++;
           }
       }
       return counter;
}
}