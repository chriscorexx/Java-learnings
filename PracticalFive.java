import java.util.Scanner;

public class PracticalFive{
  public static void main(String[] args){
    Scanner sc =  new Scanner(System.in);

    System.out.println("Enter a string: ");
    String a = sc.nextLine();

    System.out.println("Length of the string: " + a.length());

    System.out.println("To Upper case: " + a.toUpperCase());

    System.out.println("To lower case: " + a.toLowerCase());

    System.out.println("Substring: " + a.substring(3));

    System.out.println("Index of a : " + a.indexOf('a'));

    System.out.println("Replace : " + a.replace("Java", "Javascript"));

    System.out.println("Contains: " + a.contains("Java"));

    System.out.println("Equals: " + a.equals("Java Programming"));
     
    //StringBuffer
     StringBuffer sb = new StringBuffer(a);

    System.out.println("StringBufffer: "+ sb);

    sb.append(" language");
    System.out.println("After append: " + sb);

    sb.insert(0, "This is ");
    System.out.println("After insert: " + sb);

    sb.replace(0, 7, " Learning");
    System.out.println("After replace: " + sb);

    sb.reverse();
    System.out.println("After reverse: " + sb);

    sc.close();

  }
}
