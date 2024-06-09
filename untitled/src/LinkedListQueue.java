class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;
    private int size;

    public LinkedListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Add an element to the queue
    public void enqueue(int item) {
        Node newNode = new Node(item);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            this.size++;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
        this.size++;
        System.out.println(item + " enqueued to queue");
    }

    // Remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int item = this.front.data;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }

        this.size--;
        return item;
    }

    // Get the front element
    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.front.data;
    }

    // Get the rear element
    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.rear.data;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());
    }
}

