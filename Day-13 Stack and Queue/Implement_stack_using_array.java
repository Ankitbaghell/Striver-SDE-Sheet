
package Stacks;

public class StacksUsingArrays {
    private int[] arr;
    private int top = -1;

    public StacksUsingArrays() {
        arr = new int[5];
    }

    public void push(int elem) {
        if (top == arr.length - 1) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        arr[top] = elem;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        int x = arr[top];
        top--;
        return x;
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (top == arr.length - 1)
            return true;
        return false;
    }

    public int stacktop() {
        return arr[top];
    }

    public int size() {
        return top + 1;
    }
}

class Main {
    public static void main(String[] args) {
        StacksUsingArrays st = new StacksUsingArrays();
        System.out.println(st.isEmpty());
        st.push(40);
        st.push(20);
        System.out.println(st.isEmpty());
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st.size());
        st.push(50);
        System.out.println(st.stacktop());

    }
}
