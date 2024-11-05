public class calss {
    public static boolean isprime(int n){
        boolean p = false;
        if (n<=1){return false;}
        for(int j = 2; j<n;j++){
            p = n % j == 0;
            if(p){
                break;
            }
        }
        return (!p);
    }
    public static void main(String[] args) {
        int k = 1222;
        int counter1 = 0;
        int [] primes = new int[k];
        for (int i =0; i <= k;i++ ) {
            if(isprime(i))
            {
                primes[counter1] = i;
                counter1++;
            }
        }
        for (int i =0; i<primes.length;i++){System.out.print(primes[i]);}
        System.out.println(isprime(38));
        int n1=0,n2=0;
        for (int i =0; i<primes.length;i++){
            if (primes[i]!=0) {
                n1 = primes[i];
                if (isprime(k - n1)) {
                    n2 = k - n1;
                    break;
                }
            }
        }
        System.out.println(n1+" "+n2);
    }
}
