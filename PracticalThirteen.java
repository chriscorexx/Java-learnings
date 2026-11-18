interface MyInterface {
    void display();
}

class PracticalThirteen implements MyInterface {

    public void display() {
        System.out.println("Interface implemented successfully");
    }

    public static void main(String[] args) {
        PracticalThirteen obj = new PracticalThirteen();
        obj.display();
    }
}
