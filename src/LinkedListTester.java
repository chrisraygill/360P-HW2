import sun.nio.ch.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class LinkedListTester implements Runnable{


    static PriorityQueue queue = new PriorityQueue(5);
    Node a;

    LinkedListTester(Node a) {
        this.a = a;

    }

    public static void main(String[] args) throws InterruptedException {

        Node h = new Node("a", 4);
        Node w = new Node("y", 7);
        Node y = new Node("x", 6);
        Node m = new Node("b", 2);
        Node d = new Node("c", 3);

        Thread t1 = new Thread((new LinkedListTester(h)));
        Thread t2 = new Thread(new LinkedListTester(w));
        Thread t3 = new Thread(new LinkedListTester(y));
        Thread t4 = new Thread(new LinkedListTester(m));
        Thread t5 = new Thread(new LinkedListTester(d));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        int x = queue.search("x");
    }

    @Override
    public void run() {

        try {
            queue.add(a.getName(), a.getPriority());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
