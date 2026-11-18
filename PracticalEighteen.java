import java.util.*;

class PracticalEighteen {
    public static void main(String[] args) {class PracticalSeventeenRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        PracticalSeventeenRunnable obj = new PracticalSeventeenRunnable();

        Thread t1 = new Thread(obj, "Thread 1");
        Thread t2 = new Thread(obj, "Thread 2");

        t1.start();
        t2.start();
    }
}
        Collection<String> names = new ArrayList<>();

        names.add("Chris");
        names.add("John");
        names.add("David");

        System.out.println("Collection: " + names);

        names.remove("John");

        System.out.println("After Removal: " + names);

        System.out.println("Contains Chris: " + names.contains("Chris"));

        System.out.println("Size: " + names.size());
    }
}
