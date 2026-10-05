import java.util.*;

public class PracticalSeven{
  public static void main(String[] args){

    Vector<Integer> v = new Vector<>();

    v.add(10);
    v.add(20);
    v.add(30);
    System.out.println("After add(): "+ v); //adds element to the array

    v.addElement(40);
    System.out.println("After Element(): "+ v);//adds element to the end of array
    
    //returns the element at the specific index
    System.out.println("get(1):"+ v.get(1));

    //return the number of elements currently in the array
    System.out.println("size(): "+ v.size());
    
    //Returns the current capacity of the Vector.
    System.out.println("capacity(): "+ v.capacity());

    //Checks whether the Vector contains a specific element
    System.out.println("contains(20): "+ v.contains(20));
     
    //Returns the element at the specific index
    System.out.println("elementAt(2): "+ v.elementAt(2));

    //Returns the first element of Vector
    System.out.println("firstElement(): "+ v.firstElement());

    //Returns the last element of Vector
    System.out.println("lastElement(): "+ v.lastElement());
    
    //Returns the index of the first occurrence of an element.
    System.out.println("indexOf(30): "+ v.indexOf(30));

    //Checks whether the Vector contains of no elements
    System.out.println("isEmpty(): "+ v.isEmpty());

    //Removes an element from vector
    v.remove(0);
    System.out.println("After remove: "+ v);

    //Removes an element to a specific index
    v.removeElementAt(1);
    System.out.println("After removeElementAt(1): "+ v);

    //Removes all elemenst from the Vector
    v.removeAllElements();
    System.out.println("After removeAllElement():"+ v);

    //adds element again
    v.add(50);
    v.add(60);

    //Removes all elements
    v.clear();
    System.out.println("After clear():"+ v);
  }
}
