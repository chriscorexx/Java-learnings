import java.util.Scanner;

class Calculator{
  int add (int a, int b){
    return a + b;
  }

  int add (int a, int b, int c){
    return a + b + c;
  }

  double add (double a, double b){
    return a + b;
  }
}


public class PracticalEight{
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   Calculator c = new Calculator();
   
    System.out.println("Enter first integer: ");
    int a = sc.nextInt();

    System.out.println("Enter second integer: ");
    int b = sc.nextInt();

    System.out.println("Addition of a and b: "+ c.add(a, b));

    System.out.println("Enter third integer: ");
    int d = sc.nextInt();

    System.out.println("Addition of a, b and c: "+ c.add(a, b, d));

    System.out.println("Enter first decimal number: ");
    double x = sc.nextDouble();

    System.out.println("Enter second decimal number: ");
    double y = sc.nextDouble();

    System.out.println("Addition of two decimals: "+ c.add(x, y));

  }
}

//Method overloading
