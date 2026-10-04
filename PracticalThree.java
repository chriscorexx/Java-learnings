import java.util.Scanner;

public class PracticalThree{
  public static void main(String[] args){
  Scanner sc = new Scanner(System.in);

    System.out.println("Enter first number: ");
    double num1 = sc.nextDouble();

    System.out.println("Enter second number: ");
    double num2 = sc.nextDouble();

    System.out.print("Enter a operator (+, -, /, *, %); ");
    char operator = sc.next().charAt(0);

    switch(operator){

      case '+':
        System.out.print("Result: " + (num1 + num2));
        break;
      case '-':
        System.out.print("Result: " + (num1 - num2));
        break;

      case '/':
        System.out.print("Result: " + (num1 / num2));
        break;
      case '*':
        System.out.print("Result: " + (num1 * num2));
        break;
      case '%':
        System.out.print("Result: " + (num1 % num2));
        break;

      default:
      System.out.println("Invalid operator");
    }
    sc.close();
  }
}
