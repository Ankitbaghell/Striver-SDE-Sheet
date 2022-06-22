
package Heap;

import java.util.ArrayList;

public class PriorityQImple { // MIN HEAP / PRIORITY QUEUE
    // we use array to implement heap
    ArrayList<Element> heap;

    public PriorityQImple() {
        heap = new ArrayList<>();
    }

    // Implemeneting Functions
    public void insert(String data, int priority) {
        Element x = new Element(data, priority);
        heap.add(x); // Adding at end of the array
        // now to maintain the heap property we have to do UP - HEAPIFY

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            int childVal = heap.get(childIndex).priority;
            int parentVal = heap.get(parentIndex).priority;
            if (childVal < parentVal) {
                Element temp = heap.get(childIndex); // swapping
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
            } else {
                return;
            }

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public String removeMin() {

        // store the root element ===> minimum , then put last element to root, the
        // to maintain heap proprty , DOWN HEAPIFY

        Element ans = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int parentIndex = 0;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2;

        while (leftChild < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(minIndex).priority > heap.get(leftChild).priority) {
                minIndex = leftChild;
            }
            if (rightChild < heap.size() && heap.get(minIndex).priority > heap.get(rightChild).priority) {
                minIndex = rightChild;
            }
            if (minIndex == parentIndex) {
                break;
            }

            // swapping minIndex and parentIndex
            Element temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
            rightChild = 2 * parentIndex + 2;
        }
        return ans.data;
    }

    public String getMin() {
        if (heap.size() == 0) {
            System.out.println("Empty list");
            return "";
        }
        return heap.get(0).data;
    }

    public boolean isEmpty() {
        if (heap.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return heap.size();
    }

}

class main {
    public static void main(String[] args) {
        PriorityQImple pq = new PriorityQImple();
        pq.insert("P1", 10);
        pq.insert("P2", 0);
        pq.insert("P3", 50);
        pq.insert("P4", 20);

        System.out.println(pq.getMin());
        while (!pq.isEmpty()) {
            System.out.println(pq.removeMin() + " ");
        }
    }
}