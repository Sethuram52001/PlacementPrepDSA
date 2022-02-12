public class QueueArray {
    private final int maxSize = 1000;
    private int[] q;
    private int front, rear, currSize;

    QueueArray() {
        q = new int[maxSize];
        front = rear = -1;
        currSize = 0;
    }

    private void insert(int val) {
        if(currSize == maxSize) {
            System.out.println("Queue is full! Can't insert.");
            System.exit(1);
        }

        if(rear == -1) {
            front = 0;
            rear = 0;
        }

        else {
            rear = (rear + 1) % maxSize;
        }

        q[rear] = val;
        currSize++;
    }

    private int remove() {
        if(front == -1) {
            System.out.println("Can't delete on empty queue!");
            System.exit(1);
        }

        int polled = q[front];
        if(currSize == 1) {
            front = rear = -1;
        }
        else {
            front = (front + 1) % maxSize;
        }
        currSize--;
        return polled;
    }

    private void print() {
        for(int i = front; i <= rear; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.print();
        System.out.println("removed: " + q.remove());
        q.print();
    }
}