import java.util.Scanner;

public class PracticalTwo
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    // Simple if 
    System.out.print("Enter your age: ");
    int age = sc.nextInt();

    if (age >= 18) {
      System.out.println("You are eligiable to vote.");
    }

    //if-else
    System.out.print("\nEnter a number: ");
      int number = sc.nextInt();

    if (number % 2 == 0){
      System.out.println("This number is even.");
    } else {
      System.out.println("This number is odd");
    }


    //Nested if

    System.out.print("\n Enter your age: ");
    int age2 = sc.nextInt();

    System.out.print("\nDo you have an ID to enter (1 for Yes and 2 for No) :");
    int id = sc.nextInt();

    if (age2 >= 18){
      if (id == 1){
        System.out.print("You have an Id, you can enter.");
      } else {
        System.out.print("You have no Id, you cannot enter.");
      }
      
    }else {
      System.out.print("You are under age and cannot enter.");
    }


    //if-else ladder
    System.out.print("\n Enter your marks: ");
    int marks = sc.nextInt();

    if (marks >= 90){
       System.out.println("Grade A") ;
    } else if(marks >= 75){
      System.out.println("Grade B");
    } else if(marks >= 80){
      System.out.println("Grade C");
    } else if(marks >= 75){
      System.out.println("Grade D");
    }else{
     System.out.println("Fail");
    }


  }
}
