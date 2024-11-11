import java.util.Scanner;
public class calss {
    public static boolean isprime(int n)
    {
        boolean p = true; /* Define a bool "p", that indicates if n is prime */
        if (n<=1){return false;}/* if n is 1 or less, n cannot be prime by definition*/
        for(int j = 2; j<n;j++) /* a loop checks every number from 2 to n, and checks if any j is a divider of n*/
        {
            p = (n % j != 0); /* the loop will break at the case of n being prime and will not check unnecessary fields*/
            if(!p){
                break;
            }
        }
        return (p);
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        Scanner obj = new Scanner(System.in); /* get input from user*/
        System.out.println("Enter Even number:");
        int k = Integer.parseInt(obj.nextLine());/* assign input in k*/
        int counter1 = 1;
        int [] primes = new int[k]; /* an array of k length, stores the primes until k*/
        primes[0] = 2;
        for (int i =3; i <= k;i+=2 ) /* assign primes to the array with the func. isprime*/
        {
            if(isprime(i))
            {
                primes[counter1] = i;
                counter1++;
            }
        }
        int n1=0,n2=0;
        /* checks the primes array from the smallest and assign it to n1, and checks if n1-k is
         prime, if he is, it assigns n1-k to n2, if not it goes to the next prime in the array */
        for (int i =0; i<primes.length;i++){
            if (primes[i]!=0) {
                n1 = primes[i];
                if (isprime(k - n1)) {
                    n2 = k - n1;
                    break;
                }
            }
        }
        int p1=0, p2=0;
        /* checks the primes array from the smallest and assign it to p1, and checks if k+p1 is
         prime, if he is, it assigns k+p1 to p2, if not it goes to the next prime in the array,
         p1 is minimal because we check from the smallest prime */
        for (int i =0; i<primes.length;i++){
            if (primes[i]!=0) {
                p1 = primes[i];
                if (isprime(k + p1)) {
                    p2 = k +p1;
                    break;
                }
            }
        }
        int c = 0;
        for (int i =0; i<primes.length;i++)/* prints all prime numbers from 2 to k*/
        {
            if (primes[i]==0) {
                break;
            }
            c++;
            System.out.print(primes[i]+" ");
        }
        System.out.println("|So, "+c+" primes");
        /*primal deconstruction*/
        /*loops primes and checks if k2 is divisible by one (from the smallest), if it is, pri is printed ,divide k2 by pri and assign pri the next prime number. loop ends when k2 is prime */
        int k2 = k;
        System.out.println(" ");
        int cnt = 0;
        int pri = primes[cnt];
        while(pri!=0 &k2!=2)
        {
            if (k2%pri==0)
            {
                System.out.print(pri+" * ");
                k2 = k2/pri;
            }
            else
            {
               cnt++;
               pri = primes[cnt];
            }
        }
        System.out.println(" = "+ k );
        System.out.println(" ");
        System.out.println(n1+" "+n2);
        System.out.println(p1+" "+p2);
        System.out.println("322714924");
        long finish = System.currentTimeMillis();
        double runtime = (finish-start)/1000.0;
        System.out.print("runtime for your program is: "+runtime+" seconds");



    }
}
