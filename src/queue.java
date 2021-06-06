import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
    ArrayQueue arrayQueue = new ArrayQueue(3);
    char key=' ';
    Scanner sc = new Scanner(System.in);
    boolean loop = true;
    while (loop){
        System.out.println("");
    }
    }
}
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        int front= -1;
        int rear = -1;
    }
    public boolean isFull(){
        return rear== maxSize-1;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void addQueue(int n){
        if(isFull()){
            System.out.println("Full");
        }else{
            rear++;
            arr[rear]= n;
        }

    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Empty");

        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("");
        }else{
            for(int i = 0 ; i<arr.length; i++){
                System.out.println(arr[i]);
            }
        }
    }
    public int head(){
        if(isEmpty()){
            System.out.println("null");
            throw new RuntimeException("null");
        }else{
            return arr[front+1];

        }
    }


}
