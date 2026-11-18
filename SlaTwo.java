import java.util.Scanner;

class SlaTwo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name, rollNo, div;
        int score = 0;
        char answer;

        System.out.println("================================");
        System.out.println("       QUIZ MANAGEMENT SYSTEM");
        System.out.println("================================");

        // Student Details
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();

        System.out.print("Enter Division: ");
        div = sc.nextLine();

        System.out.println("\nWelcome " + name + "!");
        System.out.println("Answer the following 5 MCQs.\n");

        // Question 1
        System.out.println("1. Which language is used for Android development?");
        System.out.println("A. Java");
        System.out.println("B. HTML");
        System.out.println("C. CSS");
        System.out.println("D. SQL");
        System.out.print("Enter your answer: ");
        answer = sc.next().charAt(0);

        if (Character.toUpperCase(answer) == 'A') {
            score++;
        }

        // Question 2
        System.out.println("\n2. Which company developed Java?");
        System.out.println("A. Microsoft");
        System.out.println("B. Sun Microsystems");
        System.out.println("C. Google");
        System.out.println("D. Apple");
        System.out.print("Enter your answer: ");
        answer = sc.next().charAt(0);

        if (Character.toUpperCase(answer) == 'B') {
            score++;
        }

        // Question 3
        System.out.println("\n3. Which keyword is used to inherit a class in Java?");
        System.out.println("A. implements");
        System.out.println("B. interface");
        System.out.println("C. extends");
        System.out.println("D. import");
        System.out.print("Enter your answer: ");
        answer = sc.next().charAt(0);

        if (Character.toUpperCase(answer) == 'C') {
            score++;
        }

        // Question 4
        System.out.println("\n4. Which method is the entry point of a Java program?");
        System.out.println("A. start()");
        System.out.println("B. run()");
        System.out.println("C. print()");
        System.out.println("D. main()");
        System.out.print("Enter your answer: ");
        answer = sc.next().charAt(0);

        if (Character.toUpperCase(answer) == 'D') {
            score++;
        }

        // Question 5
        System.out.println("\n5. Which package contains the Scanner class?");
        System.out.println("A. java.io");
        System.out.println("B. java.util");
        System.out.println("C. java.lang");
        System.out.println("D. java.awt");
        System.out.print("Enter your answer: ");
        answer = sc.next().charAt(0);

        if (Character.toUpperCase(answer) == 'B') {
            score++;
        }

        // Calculate Result
        double percentage = (score / 5.0) * 100;

        System.out.println("\n================================");
        System.out.println("          STUDENT REPORT CARD");
        System.out.println("================================");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Division     : " + div);
        System.out.println("--------------------------------");
        System.out.println("Total Marks  : 5");
        System.out.println("Marks Scored : " + score);
        System.out.println("Percentage   : " + percentage + "%");

        if (percentage >= 40) {
            System.out.println("Result       : PASS");
        } else {
            System.out.println("Result       : FAIL");
        }

        System.out.println("================================");

        sc.close();
    }
}
