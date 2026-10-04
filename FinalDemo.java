class Student {
    final int Rollno = 245101;

    final void display() {
        System.out.println("Rollno of Student is: " + Rollno);
        System.out.println("Final method executed!");
    }
}

class FinalDemo extends Student {
    @Override
    void display() {
        System.out.println("Overridden method!");
    }

    public static void main(String[] args) {
        FinalDemo s = new FinalDemo();
        s.display();
    }
}
