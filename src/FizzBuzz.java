public class FizzBuzz {
    public static void fizzBuzz() {
        for (int x = 1; x <= 100; x++) {
            if (x % 3 == 0 & x % 5 == 0) {
                System.out.println("FizzBuzz");
                continue;
            } else if (x % 3 == 0) {
                System.out.println("Fizz");
                continue;
            } else if (x % 5 == 0) {
                System.out.println("Buzz");
                continue;
            }
            System.out.println(x);
        }
    }
}
