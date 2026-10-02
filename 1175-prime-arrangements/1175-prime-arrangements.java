class Solution {
    static boolean[] isPrime = sieve();
    static int[] prefixPrime = set();

    public static int numPrimeArrangements(int n) {
        int mod = 1_000_000_007;
        long proX = 1;
        long proY = 1;
        int x = prefixPrime[n];
        int y = n - x;

        for (int i = x; i > 1; i--) {
            proX = (proX * i) % mod;
        }
        for (int i = y; i > 1; i--) {
            proY = (proY * i) % mod;
        }
        return (int) ((proX * proY) % mod);
    }

    static boolean[] sieve() {
        boolean[] prime = new boolean[101];
        for (int i = 2; i <= 100; i++) prime[i] = true;

        for (int i = 2; i * i <= 100; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    static int[] set() {
        int[] pp = new int[101];
        for (int i = 2; i <= 100; i++) {
            pp[i] = isPrime[i] ? pp[i - 1] + 1 : pp[i - 1];
        }
        return pp;
    }
}