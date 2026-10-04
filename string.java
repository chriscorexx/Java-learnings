import java.util.Scanner;

public class jastring{
  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter first string: ");
    String s1 = sc.nextLine();
    
    System.out.println("Enter first string: ");
    String s2 = sc.nextLine();

    int len = s1.length();
    int len2 = s2.length();
    System.out.println("The length of s1 string is : " + len);
    System.out.println("The length of s2 string is : " + len2);

    System.out.println("String concatenation");
    
    System.out.print(s1 + " " + s2);

  }
}
