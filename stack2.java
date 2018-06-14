
public class Stack2{

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack2(int val){
        maxSize = val;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j){
        stackArray[++top] = j;
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize - 1);
    }

    public static void main(String arg[]){
        Stack2 s = new Stack2(10);

        
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        for(int i = 60; i < 100; i = i + 10){
            s.push(i);
        }
    
        while(!s.isEmpty()){
            long value = s.pop();
            System.out.print(value + " ");
        }
        System.out.println();
    }

}