class Dog{
    void sound(){
   System.out.println("Dog barks.");
  }
}
class Cat{
  void sound(){
  System.out.println("Cat meows.");
  }
}

public class DynamicDispatch{
   public static void main(String[] args){
     Dog d = new Dog();
     Cat c = new Cat();

    d.sound();
    c.sound();
  }
}

//DynamicDispatch :  One command, different actions depending on who receives it.
