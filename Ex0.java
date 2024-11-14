/** Nadav Sudri - 322714924**/
/**
// CS 101 - Pseudocode Outline

// Verbal explanation                                      | Pseudocode
// --------------------------------------------------------|--------------------------------------------------------
// Define a function to check if a given integer k         | 1. input k
// is primal. Function receives a number and first         | 2. boolean p
// checks if the number is 2 or 3. If it is, the           | 3. function name: isprime
// function returns true (as 2 and 3 are prime).           | 4. if k <= 1 return false
// Then it checks every integer between 3 and k,           | 5. if k == 2 or k == 3 return true
// returning true and breaking the loop if any             | 6. for i from 2 to k
// integer divides k with no remainder. If not, it         | 7. if k % i != 0 | p = true
// runs up to k and returns false.                         | 8. if k % i == 0 | p = false
//                                                         | 9. if p = false | exit loop
//                                                         | 10. \\ end for
//                                                         | 11. return p

// Loop to scan even numbers from 2 to k and collect       | 1. list primes (integers)
// primes up to k into an indexed integer list.            | 2. input k
//                                                         | 3. integer counter = 0
//                                                         | 4. for (i from 3 to k | k += 2)
//                                                         | 5. if i isprime()
//                                                         | 6. add i to primes at index counter
//                                                         | 7. counter = counter + 1
//                                                         | 8. \\ end for

// (a) Loop through primes list, find smallest n1          | 1. integers n1, n2 = 0
// such that k-n1 is also prime, making n1 + n2 = k.       | 2. for (i from 0 to prime list length)
//                                                         | 3. n1 = primes[i]
//                                                         | 4. if (k - n1) isprime() | n2 = k - n1 & exit loop
//                                                         | 5. \\ end for
//                                                         | 6. print n1 “+” n2 = k

// (b) Loop through primes list to find smallest p1        | 1. integers p1, p2
// such that k + p1 is prime; set p2 to k + p1 if found.   | 2. for i from 0 to prime list length
//                                                         | 3. p1 = primes[i]
//                                                         | 4. if k + p1 is prime | p2 = k + p1 & exit loop
//                                                         | 5. \\ end for

// (c) Iterate through primes list, print each             | 1. integer counter = 0
// element, and count the number of elements.              | 2. for i from 0 to prime list length
//                                                         | 3. print primes[i]
//                                                         | 4. counter = counter + 1
//                                                         | 5. \\ end for
//                                                         | 6. print counter

// (d) Loop through primes and check divisibility          | 1. integers temp_prime, k2, count
// of k2 by each prime. If divisible, print and            | 2. count = 0
// update k2. Continue until k2 becomes prime.             | 3. temp_prime = primes[count]
//                                                         | 4. k2 = k
//                                                         | 5. while temp_prime != 0 and k2 != 2
//                                                         | 6. if k2 % temp_prime == 0 | print temp_prime
//                                                         | 7. k2 = k2 / temp_prime
//                                                         | 8. else | count = count + 1, temp_prime = primes[count]
//                                                         | 9. \\ end while

// (e) Track program run time by assigning current         | 1. long time a = current time
// time to variables at start and end, and subtracting.    | 2. { **all program here** }
//                                                         | 3. long time b = current time
//                                                         | 4. print (b - a)

// (f) Print user ID                                       | print 322714924
/**
 * Output:
 * Enter Even number larger than 4:
 * 330060
 * a) 7 + 330053 = 330060
 * b) 330067 - 7 = 330060
 * c) Total of 28514 primes in: [ 2 , 330060 )
 * d) 2 * 2 * 3 * 5 * 5501 = 330060
 * e) My id is: 322714924
 * f) runtime for this program is: 4.536 seconds
 * **/
import java.util.Scanner;
class obj
{
   public void jade()
        {
        System.out.println("void");
        }
         static int myint(){return 3;}
}

 class Myclass
 {
     static boolean isprime(int n)
    {
        boolean p = true; /** Define a bool "p", that indicates if n is prime **/
        if (n<=1){return false;}/** if n is 1 or less, n cannot be prime by definition**/
        for(int j = 2; j<Math.sqrt(n);j++) /** a loop checks every number from 2 to square root of n, and checks if any j is a divider of n**/
        {
            p = (n % j != 0); /** the loop will break at the case of n being prime and will not check unnecessary fields**/
            if(!p){
                break;
            }
        }
        return (p);
    }
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        Scanner obj = new Scanner(System.in); /** get input from user**/
        System.out.println("Enter Even number larger than 4:");
        int k = Integer.parseInt(obj.nextLine());/** assign input in k**/
        if (k<4||k%2!=0) /** checks if the given number is even and greater than 4**/
        {
            System.out.println("Error!!"); /** print error and exit the program**/
            System.exit(0);
        }
        int counter1 = 1;
        int [] primes = new int[k]; /** an array of k length, stores the primes until k**/
        primes[0] = 2; /** define the first prime in the array to be 2, true for every given k**/
        for (int i =3; i <= k;i+=2 ) /** assign primes to the array with the func. isprime**/
        {
            if(isprime(i))
            {
                primes[counter1] = i;
                counter1++;
            }
        }
        int n1=0,n2=0;
        /** checks the primes array from the smallest and assign it to n1, then checks if n1-k is
         prime, if it is, it assigns n1-k to n2, if not it goes to the next prime in the array **/
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
        /**checks the primes array from the smallest and assign it to p1, and checks if k+p1 is
         prime, if he is, it assigns k+p1 to p2, if not it goes to the next prime in the array,
         p1 is minimal because we check from the smallest prime **/
        for (int i =0; i<primes.length;i++){
            if (primes[i]!=0) {
                p1 = primes[i];
                if (isprime(k + p1)) {
                    p2 = k +p1;
                    break;
                }
            }
        }
        System.out.println("a) "+n1+" + "+n2 +" = "+k); /** print n1 and n2**/
        System.out.println("b) "+p2+" - "+p1 +" = "+k); /** print p1 and p2**/
        int c = 0;
        for (int i =0; i<primes.length;i++)/** prints all prime numbers from 2 to k**/
        {
            if (primes[i]==0) {
                break;
            }
            c++;
            //System.out.print(primes[i]+" ");
        }
        System.out.println("c) Total of "+c+" primes in: [ 2 , " +k+" )");
        /** primal deconstruction**/
        /**loops primes and checks if k2 is divisible by one (from the smallest), if it is, pri is printed ,divide k2 by pri and assign pri the next prime number. loop ends when k2 is prime **/
        int k2 = k; /** define k2, we dont want to change k for further cases**/
        int cnt = 0;
        int pri = primes[cnt];/** assign pri the 1st prime from array**/
        boolean first = true;/** boolean to check if the number that is printed is the first one to avoid unnecessary "*" **/
        System.out.print("d) ");
        while(pri!=0 &k2!=2)
        {
            if (k2%pri==0) /** if pri is a multiplier of k2, print it and divide it by pri**/
            {
                if (first)
                {
                    System.out.print(pri);
                    k2 = k2/pri;
                }
                first = false;
                System.out.print(" * "+pri);
                k2 = k2/pri;
            }
            else /** when pri is not a multiplier of k2, pri is assigned with the next prime number in order**/
            {
               cnt++;
               pri = primes[cnt];
            }
        }
        System.out.println(" = "+ k ); ///** print k
        System.out.println("e) My id is: 322714924"); /** print my id**/
        long finish = System.currentTimeMillis();
        double runtime = (finish-start)/1000.0;
        System.out.print("f) runtime for this program is: "+runtime+" seconds");




    }
}
