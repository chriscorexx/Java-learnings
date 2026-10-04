public class PracticalFour {
    public static void main(String[] args) {

        // 1. For loop - 1 to 10
        System.out.println("Numbers from 1 to 10:");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }


        // 2. While loop - Even numbers
        System.out.println("\nEven numbers:");

        int i = 2;

        while (i <= 10) {
            System.out.println(i);
            i += 2;
        }


        // 3. Do-while loop - Odd numbers
        System.out.println("\nOdd numbers:");

        int j = 1;

        do {
            System.out.println(j);
            j += 2;
        } while (j <= 10);
    }
}
