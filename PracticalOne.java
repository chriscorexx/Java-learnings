import java.util.Scanner;

public class PracticalOne
{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
       
      System.out.println("Enter your name: ");
      String name = sc.nextLine();
      
      System.out.println("Enter your age: ");
      int age = sc.nextInt();

      sc.nextLine();

      System.out.println("Enter your college name: ");
      String clg_name = sc.nextLine();

      System.out.println("Enter your rollno: ");
      int rollno = sc.nextInt();

      sc.nextLine();

      System.out.println("My name is " + name + ", I am " + age + " years old. " + "I study in " + clg_name + " college" + " and my rollno is " + rollno );


    }
}
