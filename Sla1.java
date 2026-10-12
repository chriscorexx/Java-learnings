import java.util.Scanner;

public class MarksGradeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                sc.close();
                return;
            }

            total += marks[i];
        }

        double average = (double) total / n;
        String grade;
        double gpa;

        if (average >= 90) {
            grade = "A+";
            gpa = 10.0;
        } else if (average >= 80) {
            grade = "A";
            gpa = 9.0;
        } else if (average >= 70) {
            grade = "B";
            gpa = 8.0;
        } else if (average >= 60) {
            grade = "C";
            gpa = 7.0;
        } else if (average >= 50) {
            grade = "D";
            gpa = 6.0;
        } else if (average >= 40) {
            grade = "E";
            gpa = 5.0;
        } else {
            grade = "F";
            gpa = 0.0;
        }

        System.out.println("\n========== STUDENT REPORT CARD ==========");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.println("Subject " + (i + 1) + " Marks : " + marks[i] + "/100");
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Marks  : " + total + "/" + (n * 100));
        System.out.printf("Average      : %.2f%%%n", average);
        System.out.println("Grade        : " + grade);
        System.out.printf("GPA          : %.1f/10.0%n", gpa);
        System.out.println("==========================================");

        sc.close();
    }
}
