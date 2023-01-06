// Write a program to demonstrate multithreading in java


class Q10 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Odd());
        Thread t2 = new Thread(new Even());
        t1.start();
        t2.start();
    }
}

class Odd implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println(i);
            // Sleep thread for 500 milliseconds
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Even implements Runnable {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}