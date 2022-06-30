
package Queues;

import java.util.Stack;

public class QueueUsingArrays {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArrays() {
        arr = new int[5];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (rear == arr.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1)
            front++;
        rear++;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int x = arr[front];
        front++;
        size--;
        return x;
    }

    public boolean isEmpty() {
        if (front == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (rear == arr.length - 1)
            return true;
        return false;
    }

    public int front() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public int size() {
        return size;
    }
}

class Main {
    public static void main(String[] args) {
        QueueUsingArrays q = new QueueUsingArrays();
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        q.enqueue(10);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(890);

        System.out.println(q.size());
        System.out.println(q.isFull());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());

    }
}
