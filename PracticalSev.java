import java.util.*;

public class PracticalSev{
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);

       Vector<Integer> v = new Vector<>();
 
      System.out.println("Enter number of elements: ");
      int n = sc.nextInt();

      System.out.println("Enter "+ n +" elements");
      for(int i = 0; i < n; i++){
       v.add(sc.nextInt());                                       
    }
      

    System.out.println("Vector elements are: ");
     for (int i = 0; i < v.size(); i++) {
       System.out.println(v.get(i));
     }
    sc.close();
  }
}
