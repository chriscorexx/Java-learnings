class PracticalSeventeenThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        PracticalSeventeenThread t1 = new PracticalSeventeenThread();
        PracticalSeventeenThread t2 = new PracticalSeventeenThread();

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
