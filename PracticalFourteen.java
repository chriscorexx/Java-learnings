import java.util.Scanner;
import java.util.ArrayList;

class PracticalFourteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter 3 names:");

        for (int i = 0; i < 3; i++) {
            names.add(sc.nextLine());
        }

        System.out.println("Names are:");

        for (String name : names) {
            System.out.println(name);
        }

        sc.close();
    }
}
