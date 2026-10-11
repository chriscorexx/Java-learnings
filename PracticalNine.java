class Parent {
    final int VALUE = 100;

    final void display() {
        System.out.println("Final variable value: " + VALUE);
        System.out.println("This is a final method.");
    }
}

final class Demo {
    void show() {
        System.out.println("This is a final class.");
    }
}

public class PracticalNine {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.display();

        Demo d = new Demo();
        d.show();
    }
}
