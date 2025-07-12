//add hint function: even/odd* , prime/non-prime* , if divisible by 5
//add score system

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int a;
        int b;
        int x;                                    //random number
        int y;                                    //guessed number
        int z = 0;                                //number of attempts
        String H;                                 //for hint
        boolean E = false;                        //is Even
        System.out.println("Before the start of the game, please enter the range of numbers you want to guess number (for example 1-100): ");
        System.out.print("from ");
        a = scanner.nextInt();
        System.out.print("to ");
        b = scanner.nextInt();

        x = random.nextInt(a , b +1);

        System.out.println("\nWELCOME TO THE GAME!\n");

        if( x%2 == 0){E = true;}                    // odd/Even hint

        do {
            System.out.print("Please Enter your guess: ");
            y = scanner.nextInt();
            z++;
            if(y > x) {
                System.out.println("Think lower!");
            }
            else if(y < x) {
                System.out.println("Think higher!");
            }

            //HINT
            if(z == 5 && !(x == y)) {
                System.out.println("------------------------------------------------");
                System.out.print("Would qou like a hint? (yes/no): ");
                H = scanner.next().toLowerCase();

                if (H.equals("yes")) {
                    if ( isPrime(x) ) {
                        System.out.println("The number is Prime.\n");
                    } else {
                        System.out.println("The number is NOT Prime.\n");
                    }
                }
                System.out.println("------------------------------------------------");
            }
            else if(z == 10 && !(x == y)) {
                System.out.println("------------------------------------------------");
                System.out.print("Would qou like a hint? (yes/no): ");
                H = scanner.next().toLowerCase();

                if (H.equals("yes")) {
                    if (E) {
                        System.out.println("The number is Even.\n");
                    } else {
                        System.out.println("The number is odd.\n");
                    }
                }
                System.out.println("------------------------------------------------");
            }

        }while(x != y);

        System.out.println("\nCongrats! You guessed the correct number!" +
                "\nThe number was " + x);
        System.out.printf("\nYou guessed correct in %d attempts", z);

        scanner.close();
    }
    static boolean isPrime(int x) {

        boolean P = false;

        int[] Prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163,
                167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359,
                367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577,
                587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
                811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
        };

        for(int prime : Prime){
            if(prime == x){
                P = true;
                break;
            }
        }

        return P;

    }
}